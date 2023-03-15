package com.example.mamatva01.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Set;

@Configuration
public class CustomSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws
            IOException, ServletException {
        Set<String> roles=AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        if(roles.contains("ROLE_SUPERADMIN"))
        {
            response.sendRedirect("/superadmin/");
        }
        else if(roles.contains("ROLE_ADMIN"))
        {
            response.sendRedirect("/admin/");
        }
        else if(roles.contains("ROLE_CONSULTANT"))
        {
            response.sendRedirect("/consultant/");
        }
        else
        {
            response.sendRedirect("/receptionist/");
        }
    }
}
