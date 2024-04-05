package com.sangam.muscleplay.about_us;

import com.sangam.muscleplay.support.SupportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AboutUsServiceImpl implements AboutUsService {
    @Autowired
    private AboutUsRepository aboutUsRepository;

    @Override
    public String getAboutUs() {
        AboutUsModel aboutUs = aboutUsRepository.findById("660d2f7acda913b996ea3690").orElseThrow(() -> new RuntimeException("Error getting the document. Please try again later."));
        return aboutUs.getAboutUs();
    }
}
