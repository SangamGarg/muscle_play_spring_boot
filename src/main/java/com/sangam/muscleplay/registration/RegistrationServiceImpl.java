package com.sangam.muscleplay.registration;

import com.sangam.muscleplay.registration.model.RegistrationRequestModel;
import com.sangam.muscleplay.registration.model.UserDetailsResponseModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public UserDetailsResponseModel addUser(RegistrationRequestModel registrationRequestModel) {
        String userId = registrationRequestModel.getUserId();
        if (registrationRepository.existsById(userId)) {
            throw new RuntimeException("User already exists");
        }
        UserDetailsResponseModel userDetails = new UserDetailsResponseModel();
        BeanUtils.copyProperties(registrationRequestModel, userDetails);
        // Save the user details
        return registrationRepository.insert(userDetails);
    }

    @Override
    public UserDetailsResponseModel getUser(String userId) {
        return registrationRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }

    @Override
    public String deleteUser(String userId) {
        if (registrationRepository.existsById(userId)) {
            registrationRepository.deleteById(userId);
            return "User Deleted";
        } else {
            return "User not exists";
        }
    }

    @Override
    public UserDetailsResponseModel updateUser(String userId, UserDetailsResponseModel userDetailsResponseModel) {
        UserDetailsResponseModel userDetails = registrationRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        // Copy non-null properties from userDetailsResponseModel to userDetails
        copyNonNullProperties(userDetailsResponseModel, userDetails);
        return registrationRepository.save(userDetails);
    }
    private void copyNonNullProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }

    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

}
