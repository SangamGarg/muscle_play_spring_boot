package com.sangam.muscleplay.privacy_policy;

import com.sangam.muscleplay.about_us.AboutUsRepository;
import com.sangam.muscleplay.about_us.AboutUsResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrivacyPolicyServiceImpl implements PrivacyPolicyService {
    @Autowired
    private PrivacyPolicyRepository privacyPolicyRepository;

    @Override
    public PrivacyPolicyResponseModel getPrivacyPolicy() {

        List<PrivacyPolicyResponseModel> policyResponseModels = privacyPolicyRepository.findAll();

        if (!policyResponseModels.isEmpty()) {
            return policyResponseModels.get(0);
        } else {
            // Handle case where there is no support document found
            // This is just an example; you can handle it as needed
            return null;
        }
    }
}
