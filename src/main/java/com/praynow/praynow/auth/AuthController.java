package com.praynow.praynow.auth;

import com.praynow.praynow.security.JwtUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    @Value("${app.auth.username}")
    private String adminUsername;

    @Value("${app.auth.password}")
    private String adminPassword;

    @Value("${app.auth.username2}")
    private String adminUsername2;

    @Value("${app.auth.password2}")
    private String adminPassword2;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Operation(summary = "Login to get JWT token")
    @ApiResponse(responseCode = "200", description = "Login successful, returns JWT token")
    @ApiResponse(responseCode = "401", description = "Invalid credentials")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest credentials) {
        String username = credentials.getUsername();
        String password = credentials.getPassword();


        if ((adminUsername.equals(username) && adminPassword.equals(password)) ||
            (adminUsername2.equals(username) && adminPassword2.equals(password))) {
            String token = jwtUtil.generateToken(username);
            return ResponseEntity.ok(Map.of("token", token));
        }

        return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
    }

}
