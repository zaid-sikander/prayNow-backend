package com.praynow.praynow.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LoginRequest {
    @Schema(example = "admin")
    private String username;

    @Schema(example = "your-password")
    private String password;
}
