package com.sangam.muscleplay.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
    @Autowired
    HomeService homeService;

    @PostMapping("/home")
    public ResponseEntity<?> getHomeData(@RequestBody HomeRequestBody requestBody) {
        try {
            HomeResponseModel responseModel = homeService.getHomeData(requestBody);
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
