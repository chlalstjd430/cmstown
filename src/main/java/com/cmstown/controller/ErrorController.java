package com.cmstown.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/error")
public class ErrorController {
    @RequestMapping(value = {"/data"}, method = RequestMethod.GET)
    public String main(){
        return "errorData";
    }

    @RequestMapping(value = "/projects")
    public String projects(){
        return "projects";
    }


}
