package com.example.videoflix.controllers;
import com.example.videoflix.Response;
import com.example.videoflix.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class AuthController

{
    @Autowired
    private AuthenticationManager authentication;

    @PostMapping(value = "/auth", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })



        public ResponseEntity login(@RequestBody UserModel user)
        {


            try{

                authentication.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));


                var response = new Response( "You login Successfully", null);

                return new ResponseEntity( response, HttpStatus.OK);

            }

            catch (BadCredentialsException ex)
            {


                var response = new Response( "You username/password were entered incorrectly..", null);

                return new ResponseEntity( response, HttpStatus.UNAUTHORIZED);
            }



        }







}
