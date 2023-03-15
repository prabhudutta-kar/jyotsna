package com.example.mamatva01.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/consultant")
public class ConsultantController {
    @GetMapping("/")
    public String index(){
        return "consultant/index";
    }
}
