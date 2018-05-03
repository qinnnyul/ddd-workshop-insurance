package com.thoughtworks.workshop.ddd.domain.service;

import com.thoughtworks.workshop.ddd.command.LoginCommand;
import com.thoughtworks.workshop.ddd.command.RegisterCommand;
import com.thoughtworks.workshop.ddd.command.SetPasswordCommand;
import com.thoughtworks.workshop.ddd.domain.User;
import com.thoughtworks.workshop.ddd.exception.BadRequestException;
import com.thoughtworks.workshop.ddd.exception.ResourceConflictException;
import com.thoughtworks.workshop.ddd.exception.UnauthorizedException;
import com.thoughtworks.workshop.ddd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User createUser(RegisterCommand command) {
        if (userRepository.isAlreadyExistby(command.getEmail())){
            throw new ResourceConflictException("Email exist");
        }

        if (validate(command.getEmail(), command.getPolicyNumber())) {
            throw new BadRequestException("PolicyNumber not correct");
        }

        UUID uuid = UUID.randomUUID();
        User user = new User(uuid.toString(), command.getEmail(), command.getPassword());
        userRepository.save(user);
        return user;
    }

    public User setPassword(SetPasswordCommand command) {
        User user = userRepository.findByEmail(command.getEmail());
        user.setPassword(command.getPassword());
        userRepository.save(user);
        return user;
    }


    public User login(LoginCommand command) {
        User user = userRepository.findByEmail(command.getEmail());
        if (command.getPassword().equals(user.getPassword())){
            return user;
        }
        throw new UnauthorizedException("Login failed");
    }

    private boolean validate(String email, String policyNumber){
        return true;
    }

}


