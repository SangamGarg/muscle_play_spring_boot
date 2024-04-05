package com.sangam.muscleplay.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ValidationConfig {
    //This Method will trigger before persisting any data in the database and this will trigger
    // if any null value is sent by the user
    @Bean
    public ValidatingMongoEventListener validationMongoEventListener() {
        return new ValidatingMongoEventListener(validatior());
    }

    // implementation class for the Validator
    @Bean
    public LocalValidatorFactoryBean validatior() {
        return new LocalValidatorFactoryBean();
    }
}
