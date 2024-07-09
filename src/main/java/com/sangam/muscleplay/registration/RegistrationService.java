package com.sangam.muscleplay.registration;

import com.sangam.muscleplay.registration.model.RegistrationRequestModel;
import com.sangam.muscleplay.registration.model.UserDetailsResponseModel;

public interface RegistrationService {
    public UserDetailsResponseModel addUser(RegistrationRequestModel registrationRequestModel);

    public UserDetailsResponseModel getUser(String userId);

    public String deleteUser(String userId);

    public UserDetailsResponseModel updateUser(String userId, UserDetailsResponseModel userDetailsResponseModel);


}