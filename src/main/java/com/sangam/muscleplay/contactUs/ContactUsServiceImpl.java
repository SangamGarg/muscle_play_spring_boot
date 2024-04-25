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
        ContactUsModel contactUs = contactUsRepository.findById("662a59fb2742417060622e55").orElseThrow(() -> new RuntimeException("Error getting the document. Please try again later."));
        return contactUs.getContactUs();
    }
}
