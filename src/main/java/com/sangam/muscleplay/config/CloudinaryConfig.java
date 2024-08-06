package com.sangam.muscleplay.config;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {
    @Value("${cloudinary.api.key}")
    String apiKey;
    @Value("${cloudinary.api.secret}")
    String apiSecret;
    @Value("${cloudinary.cloud.name}")
    String cloudName;

    @Bean
    public Cloudinary getCloudinary() {
        Map<Object, Object> configMap = new HashMap<>();
        configMap.put("cloud_name", cloudName);
        configMap.put("api_key", apiKey);
        configMap.put("api_secret", apiSecret);
        configMap.put("secure", true);
        return new Cloudinary(configMap);
    }
}
