package com.example.mamatva01.Controller;

import com.example.mamatva01.Service.BasicInfoService;
import com.example.mamatva01.model.BasicInfo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/receptionist")
public class ReceptionistController {

    @Autowired
    private BasicInfoService basicInfoService;
    @GetMapping("/")
    public String index() {
        System.out.println("receptionist done");
        return "receptionist/index";
    }

    @GetMapping("/Manage_Patient")
    public String managepatient() {
        System.out.println("receptionist done");
        return "receptionist/Manage_Patient";
    }

    @GetMapping("/Manage_Patient/Add_Patient")
    public String addpatient() {
        System.out.println("add patient done");
        return "receptionist/Add_Patients";
    }

    @GetMapping("/Manage_Patient/Add_Patient/Add_ANC")
    public String anc() {
        System.out.println("add anc open");
        return "receptionist/Add_ANC";
    }

    @GetMapping("/Report")
    public String report() {
        System.out.println("report opened");
        return "receptionist/Report";
    }
    @GetMapping("/dashboard")
    public String dashboard() {
        System.out.println("dashboard opened");
        return "receptionist/index";
    }

    @PostMapping("/createPatient")
    public String createBasicInfo(@ModelAttribute BasicInfo theBasicInfo, HttpSession session){
        boolean f = basicInfoService.checkId(theBasicInfo.getMotherId());
        if (f){
            session.setAttribute("msg", "Mother id already exists");
            System.out.println("already have");
        } else {
            BasicInfo basicInfo=basicInfoService.createBasicInfo(theBasicInfo);
            System.out.println("basic info");
            if(basicInfo!=null)
            {
                session.setAttribute("msg", "Registered successfully");
                System.out.println("registered successf");
            }
            session.setAttribute("msg", "Something is wrong in Server.");
            System.out.println("ok");
        }

        System.out.println("done");
        return "redirect:/Manage_Patient/Add_Patients";
    }
}