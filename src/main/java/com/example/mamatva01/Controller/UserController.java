package com.example.mamatva01.Controller;

import com.example.mamatva01.Service.UserService;
import com.example.mamatva01.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService UserService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/signin")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute User theUser){

        Boolean f =UserService.checkEmail(theUser.getEmail());

        if (f){
            System.out.println("This Email already exists.");
        } else {
            User User=UserService.createUser(theUser);
            if(User!=null)
            {
                System.out.println("Successfully Registered");
            }
            else System.out.println("Something is wrong in Server.");
        }

        //System.out.println(theUser);
        return "redirect:/register";
    }

//    public String login(@ModelAttribute User theUser)
}
