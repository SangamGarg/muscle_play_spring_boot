package com.sangam.muscleplay.registration;

import com.sangam.muscleplay.registration.model.RegistrationRequestModel;
import com.sangam.muscleplay.registration.model.UserDetailsResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody RegistrationRequestModel registrationRequestModel) {
        try {
            UserDetailsResponseModel responseModel = registrationService.addUser(registrationRequestModel);
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUser(@PathVariable String userId) {
        try {
            UserDetailsResponseModel responseModel = registrationService.getUser(userId);
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable String userId, @RequestBody UserDetailsResponseModel userDetailsResponseModel) {
        try {
            UserDetailsResponseModel responseModel = registrationService.updateUser(userId, userDetailsResponseModel);
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId) {
        try {
            String responseModel = registrationService.deleteUser(userId);
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
