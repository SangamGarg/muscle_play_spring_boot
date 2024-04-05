package com.sangam.muscleplay.support;

import com.sangam.muscleplay.about_us.AboutUsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupportServiceImpl implements SupportService {
    @Autowired
    private SupportRepository supportRepository;

    @Override
    public String getSupport() {
        SupportModel support = supportRepository.findById("660d3025cda913b996ea3692").orElseThrow(() -> new RuntimeException("Error getting the document. Please try again later."));
        return support.getSupport();
    }
}
