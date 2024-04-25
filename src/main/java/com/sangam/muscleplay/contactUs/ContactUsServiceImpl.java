package com.sangam.muscleplay.contactUs;

import com.sangam.muscleplay.about_us.AboutUsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactUsServiceImpl implements ContactUsService {
    @Autowired
    private ContactUsRepository contactUsRepository;

    @Override
    public String getContactUs() {
        ContactUsModel contactUs = contactUsRepository.findById("660d2f7acda913b996ea3690").orElseThrow(() -> new RuntimeException("Error getting the document. Please try again later."));
        return contactUs.getContactUs();
    }
}