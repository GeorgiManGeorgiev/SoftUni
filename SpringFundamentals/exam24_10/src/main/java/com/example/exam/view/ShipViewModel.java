package com.example.exam.view;

import com.example.exam.model.entity.Category;
import com.example.exam.model.entity.User;

public class ShipViewModel {

    private Long id;
    private Long health;
    private String name;
    private Long power;
    private Category category;
    private User user;

    public ShipViewModel() {
    }

    public Long getId() {
        return id;
    }

    public ShipViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public ShipViewModel setHealth(Long health) {
        this.health = health;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShipViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public ShipViewModel setPower(Long power) {
        this.power = power;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public ShipViewModel setCategory(Category category) {
        this.category = category;
        return this;
    }

    public User getUser() {
        return user;
    }

    public ShipViewModel setUser(User user) {
        this.user = user;
        return this;
    }
}
