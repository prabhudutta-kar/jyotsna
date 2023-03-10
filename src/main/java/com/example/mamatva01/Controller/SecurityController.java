package com.example.mamatva01.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userProtection")
public class SecurityController {

    @GetMapping("/")
    public String home(){
        return "userProtection/home";
    }
}
