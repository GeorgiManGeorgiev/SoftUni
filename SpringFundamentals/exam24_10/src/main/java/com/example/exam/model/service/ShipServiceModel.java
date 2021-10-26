package com.example.exam.model.service;

import com.example.exam.model.entity.CategoryNameEnum;
import com.example.exam.model.entity.User;

import java.time.LocalDate;

public class ShipServiceModel {


    private Long id;
    private String name;
    private Long power;
    private Long health;
    private LocalDate created;
    private CategoryNameEnum category;
    private User user;

    public ShipServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public ShipServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShipServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public ShipServiceModel setPower(Long power) {
        this.power = power;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public ShipServiceModel setHealth(Long health) {
        this.health = health;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public ShipServiceModel setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public ShipServiceModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }

    public User getUser() {
        return user;
    }

    public ShipServiceModel setUser(User user) {
        this.user = user;
        return this;
    }
}
