package com.designpattern.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping(value = "/all")
    public String testEndPoint(){
        return "Response";
    }
}
