package com.thoughtworks.workshop.ddd.domain.service;

import com.thoughtworks.workshop.ddd.command.LoginCommand;
import com.thoughtworks.workshop.ddd.command.RegisterCommand;
import com.thoughtworks.workshop.ddd.command.SetPasswordCommand;
import com.thoughtworks.workshop.ddd.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserApplicationService {

    private UserService userService;

    private EmailService emailService;

    @Autowired
    public UserApplicationService(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    public User register(RegisterCommand command) {
        User user = userService.createUser(command);
        emailService.send(command.getEmail());
        return user;
    }

    public User setPassword(SetPasswordCommand command) {
        User user = userService.setPassword(command);
        emailService.send(command.getEmail());
        return user;
    }


    public User login(LoginCommand command) {
        return userService.login(command);
    }
}
