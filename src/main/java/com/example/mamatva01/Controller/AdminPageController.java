package com.example.mamatva01.Controller;

import com.example.mamatva01.Service.UserService;
import com.example.mamatva01.model.User;
import com.example.mamatva01.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminPageController {
    @Autowired
    private com.example.mamatva01.Service.UserService UserService;

//    public User users;
    @GetMapping("/Patient")
    public String managepatient()
    {        System.out.println("Patient done");
        return "admin/Patient";
    }
    @GetMapping("/AddNurse")
    public String AddNurse()
    {        System.out.println("Nurse Done");
        return "admin/AddNurse";
    }
    @GetMapping("/AddReceptionist")
    public String AddReceptionist()
    {        System.out.println("Nurse Done");
        return "admin/AddReceptionist";
    }
    @GetMapping("/User")
    public String AddUser(Model model)
    {
        List<User> users = UserService.findAllUsers();
        model.addAttribute("users", users);
        System.out.println(users);
        return "admin/User";
    }
    @GetMapping("/Report")
    public String Report()
    {        System.out.println("Report Done");
        return "admin/Report";
    }
    @GetMapping("/index")
    public String index()
    {        System.out.println("Report Done");
        return "admin/index";
    }
    @GetMapping("/EditUser")
    public String EditUser()
    {        System.out.println("Report Done");
        return "admin/Edit_User";
    }


    //Creation controller


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
        return "redirect:/admin/index";
    }





}
