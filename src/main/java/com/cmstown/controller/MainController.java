package com.cmstown.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value = "/")
    public String root(){
        return "main";
    }
    @RequestMapping(value = "/main")
    public String main(){
        return "main";
    }


    @RequestMapping(value = "/projects")
    public String projects(){
        return "projects";
    }
}
