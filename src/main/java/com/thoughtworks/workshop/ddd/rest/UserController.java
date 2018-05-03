package com.thoughtworks.workshop.ddd.rest;

import com.thoughtworks.workshop.ddd.command.LoginCommand;
import com.thoughtworks.workshop.ddd.command.RegisterCommand;
import com.thoughtworks.workshop.ddd.command.SetPasswordCommand;
import com.thoughtworks.workshop.ddd.domain.User;
import com.thoughtworks.workshop.ddd.domain.service.UserApplicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@Api(value = "User REST API", description = "User API")
public class UserController {
    private UserApplicationService userApplicationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "POST", notes = "Registration")
    public User register(@RequestBody @Valid RegisterCommand command) {
        return userApplicationService.register(command);
    }

    @PutMapping(value = "/password")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "PUT", notes = "Set Password")
    public User setPassword(@RequestBody @Valid SetPasswordCommand command) {
        return userApplicationService.setPassword(command);
    }

    @PostMapping(value = "/login")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "POST", notes = "Login")
    public User setPassword(@RequestBody @Valid LoginCommand command) {
        return userApplicationService.login(command);
    }

}
