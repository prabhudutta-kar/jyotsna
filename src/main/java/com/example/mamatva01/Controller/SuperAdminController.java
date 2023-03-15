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
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/superadmin")
public class SuperAdminController {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private UserService UserService;

    private void UserDetails(Model m, Principal p){
        String email= p.getName();
        User theUser =userRepo.findByEmail(email);
        m.addAttribute("theUser", theUser);
    }

    @GetMapping("/")
    public String home(){
        return "superadmin/index";
    }
    
    @GetMapping("/Addadmin")
	public String addadmin()
	{
		System.out.println("Addadmin done");
		return "superadmin/Addadmin";
		
	}
    
    @GetMapping("/Addlocation")
	public String addlocation()
	{
		System.out.println("Addlocation done");
		return "superadmin/Superadmin_location";
		
	}
    
	@GetMapping("/User")
	public String user(Model model)
	{
		List<User> users = UserService.findAllUsers();
		model.addAttribute("users", users);
		System.out.println(users);
		return "superadmin/User";
		
	}
	
	@GetMapping("/Reports")
	public String Reports()
	{
		System.out.println("Reports done");
		return "superadmin/Report";
		
	}
	@GetMapping("/Edit_User")
	public String EditUser()
	{
		System.out.println("Reports done");
		return "superadmin/Edit_User";
		
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
	        return "redirect:/superadmin/index";
	    }
}