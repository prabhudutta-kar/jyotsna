package com.example.mamatva01.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController
{
    @GetMapping("/logout")
public String logoutPage(HttpServletRequest request, HttpServletResponse response)
    {
 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
 if (auth != null) {
 new SecurityContextLogoutHandler().logout(request, response, auth);
 }
 HttpSession session = request.getSession(false);
 if (session != null) {
 session.invalidate();
 }
return "redirect:/login?logout";
 }}