package com.sangam.muscleplay.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupportServiceImpl implements SupportService {
    @Autowired
    private SupportRepository supportRepository;

    @Override
    public SupportResponseModel getSupport() {

        List<SupportResponseModel> supportList = supportRepository.findAll();

        // Here we assume there is only one document
        if (!supportList.isEmpty()) {
            return supportList.get(0);
        } else {

            // Handle case where there is no support document found
            // This is just an example; you can handle it as needed
            return null;
        }

//
//        SupportResponseModel support = supportRepository.findById("669158e16ae910df1062cd71").orElseThrow(() -> new RuntimeException("Error getting the document. Please try again later."));
//        return support.getSupport();
    }
}
