package com.NamAir.NamAir_Backend.DTO;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}