package com.sangam.muscleplay.about_us;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutUsServiceImpl implements AboutUsService {
    @Autowired
    private AboutUsRepository aboutUsRepository;

    @Override
    public AboutUsResponseModel getAboutUs() {

        List<AboutUsResponseModel> aboutUs = aboutUsRepository.findAll();

        if (!aboutUs.isEmpty()) {
            return aboutUs.get(0);
        } else {
            // Handle case where there is no support document found
            // This is just an example; you can handle it as needed
            return null;
        }
//
//        AboutUsResponseModel aboutUs = aboutUsRepository.findById("660d2f7acda913b996ea3690").orElseThrow(() -> new RuntimeException("Error getting the document. Please try again later."));
//        return aboutUs.getAboutUs();
    }
}
