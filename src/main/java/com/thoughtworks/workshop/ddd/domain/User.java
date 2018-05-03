package com.thoughtworks.workshop.ddd.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {
    private String uuid;
    private String email;

    @JsonIgnore
    private String password;

    public User(String uuid, String email, String password) {
        this.uuid = uuid;
        this.email = email;
        this.password = password;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

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
