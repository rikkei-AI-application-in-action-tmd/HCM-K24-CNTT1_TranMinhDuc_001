package com.rikkei.refactoring.model;

public class Order {
    private User user;
    private double total;
    private String status;

    public Order(User user, double total, String status) {
        this.user = user;
        this.total = total;
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
