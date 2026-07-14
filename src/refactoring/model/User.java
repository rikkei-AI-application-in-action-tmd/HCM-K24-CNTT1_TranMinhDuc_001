package com.rikkei.refactoring.model;

public class User {
    private String email;
    private int status; // 1: active, other: locked

    public User(String email, int status) {
        this.email = email;
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
