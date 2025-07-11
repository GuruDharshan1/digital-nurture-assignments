package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/authenticate")
    public TokenResponse authenticate(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            throw new RuntimeException("Missing or invalid Authorization header");
        }

        String[] credentials = new String(Base64.getDecoder().decode(authHeader.substring(6))).split(":");
        String username = credentials[0];
        String password = credentials[1];

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        String token = jwtUtil.generateToken(username);
        return new TokenResponse(token);
    }

    static class TokenResponse {
        private String token;
        public TokenResponse(String token) {
            this.token = token;
        }
        public String getToken() {
            return token;
        }
        public void setToken(String token) {
            this.token = token;
        }
    }
}
