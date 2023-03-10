package com.example.mamatva01.Service;

import com.example.mamatva01.model.User;

public interface UserService {
    public User createUser(User theUser);
    public boolean checkEmail(String email);
}

