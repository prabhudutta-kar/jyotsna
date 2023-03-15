package com.example.mamatva01.Controller;
import com.example.mamatva01.Service.UserService;
import com.example.mamatva01.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private UserService UserService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute User theUser, HttpSession session){
        boolean f = UserService.checkEmail(theUser.getEmail());
        if (f){
            session.setAttribute("msg", "Email id already exists");
        } else {
            User User=UserService.createUser(theUser);
            if(User!=null)
            {
                session.setAttribute("msg", "Registered successfully");
            }
                session.setAttribute("msg", "Something is wrong in Server.");
        }

        //System.out.println(theUser);
        return "redirect:/login";
    }

//    public String login(@ModelAttribute User theUser)
}
