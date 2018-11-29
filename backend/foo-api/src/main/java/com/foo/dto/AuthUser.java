package com.foo.dto;

import io.jsonwebtoken.Claims;
import lombok.Data;

@Data
public class AuthUser {
    private String nom;

    private String tgi;

    private String role;

    public AuthUser(Claims verifyResult) {
        this.setNom(verifyResult.get("username", String.class));
        this.setRole(verifyResult.get("role", String.class));
        this.setTgi(verifyResult.get("tgi", String.class));
    }
}
