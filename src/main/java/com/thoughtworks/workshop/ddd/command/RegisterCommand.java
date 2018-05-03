package com.thoughtworks.workshop.ddd.command;

import javax.validation.constraints.NotBlank;

public class RegisterCommand {
    @NotBlank(message = "PolicyNumber can not be empty")
    private String email;
    @NotBlank(message = "Email can not be empty")
    private String policyNumber;
    @NotBlank(message = "Password can not be empty")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
