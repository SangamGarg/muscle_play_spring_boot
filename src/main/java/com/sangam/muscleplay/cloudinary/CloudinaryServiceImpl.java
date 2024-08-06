package com.sangam.muscleplay.cloudinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.api.ApiResponse;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {
    @Autowired
    private Cloudinary cloudinary;


    @Override
    public List<String> getImagesFromFolder(String folderPath) {
        List<String> imageUrls = new ArrayList<>();

        try {
            Map options = ObjectUtils.asMap("type", "upload", "prefix", folderPath + "/");

            ApiResponse result = cloudinary.api().resources(options);
            List<Map<String, Object>> resources = (List<Map<String, Object>>) result.get("resources");

            for (Map<String, Object> resource : resources) {
                imageUrls.add((String) resource.get("secure_url"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return imageUrls;
    }
}
