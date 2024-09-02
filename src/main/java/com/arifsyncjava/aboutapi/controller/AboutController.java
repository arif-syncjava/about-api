package com.arifsyncjava.aboutapi.controller;

import com.arifsyncjava.aboutapi.model.DataModel;
import com.arifsyncjava.aboutapi.service.AboutService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AboutController {

    private final AboutService aboutService;
    private final HttpServletRequest request;

    public AboutController(AboutService aboutService, HttpServletRequest request) {
        this.aboutService = aboutService;
        this.request = request;
    }


    @GetMapping
    public ResponseEntity<DataModel.AboutResponse> about () {
           return aboutService.execute(request);
    }



}
