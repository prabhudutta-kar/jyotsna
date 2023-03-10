package com.example.mamatva01.Service;

import com.example.mamatva01.model.User;
import com.example.mamatva01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User createUser(User theUser){
        theUser.setPassword(passwordEncoder.encode(theUser.getPassword()));
//        theUser.setRole();

        return userRepo.save(theUser);
    }

    @Override
    public boolean checkEmail(String email) {
        return userRepo.existsByEmail(email);
    }
}
