package com.thoughtworks.workshop.ddd.command;

import javax.validation.constraints.NotBlank;

public class SetPasswordCommand {
    @NotBlank(message = "email can not be empty")
    private String email;
    @NotBlank(message = "password can not be empty")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
