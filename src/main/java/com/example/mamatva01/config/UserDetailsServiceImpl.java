package com.example.mamatva01.config;

import com.example.mamatva01.model.User;
import com.example.mamatva01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            User theUser = userRepo.findByEmail(email);
            if (theUser!=null){
                return new CustomUserDetails(theUser);
            }
        throw new UsernameNotFoundException("user not available");
    }
}
