package com.example.exam.view;

public class UserViewModel {
    private String username;
    private Integer countOfShips;

    public UserViewModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserViewModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public Integer getCountOfShips() {
        return countOfShips;
    }

    public UserViewModel setCountOfShips(Integer countOfShips) {
        this.countOfShips = countOfShips;
        return this;
    }
}
