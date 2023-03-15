package com.example.mamatva01.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/")
    public String index(){
        System.out.println("admin done");
        return "admin/index";
    }
//    @GetMapping("/")
//    public String Dashboard(){
//        System.out.println("Open DashBoard");
//        return "admin/index";
//    }
//    @PostMapping("/createNurse")
//
//        public String CreateNurse()
//        {
//            return"redirect:/register";
//        }


}
