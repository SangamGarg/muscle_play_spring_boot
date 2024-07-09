//package com.sangam.muscleplay.config;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//@Component
//public class AuthInterceptor implements HandlerInterceptor {
//    @Value("${app.auth.token}")
//    private String validToken;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
//
//        if (!isValidAuthorization(authorizationHeader)) {
//            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Unauthorized");
//            return false;
//        }
//
//        return true;
//    }
//
//    private boolean isValidAuthorization(String authorizationHeader) {
//        // Implement your logic to validate the authorization header here
//        // For example, you might check if the header contains a valid token
//
//        // For demonstration purposes, let's assume the valid token is "MyToken123"
//        String validToken = "MyToken123";
//        return authorizationHeader != null && authorizationHeader.equals(validToken);
//    }
//}
