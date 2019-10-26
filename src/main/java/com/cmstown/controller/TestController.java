package com.cmstown.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping("")
    public String test(){
        return "checkPWPopup";
    }
}
