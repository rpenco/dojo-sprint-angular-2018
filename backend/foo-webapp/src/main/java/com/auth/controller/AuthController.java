package com.auth.controller;

import com.auth.service.TokenService;
import com.foo.dto.TechnoDto;
import com.foo.dto.UserContext;
import com.foo.dto.UserDto;
import jdk.nashorn.internal.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    @RequestMapping(method = POST)
    public ResponseEntity<String> createToken(@RequestBody UserDto userDto) {

        // Vérification credentials bdd



        String createdToken = tokenService.createJWT(userDto);
        return new ResponseEntity<>(createdToken, CREATED);
    }
}
