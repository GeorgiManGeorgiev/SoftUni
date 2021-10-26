package com.example.exam.web;

import com.example.exam.service.ShipService;

import com.example.exam.service.UserService;
import com.example.exam.util.CurrentUser;

import com.example.exam.view.ShipViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;



@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final ShipService shipService;
    private final UserService userService;



    public HomeController(CurrentUser currentUser, ShipService shipService, ModelMapper modelMapper, UserService userService) {
        this.currentUser = currentUser;
        this.shipService = shipService;
        this.userService = userService;
    }


    @GetMapping()
    public String index(Model model) {
        if (currentUser.getId() == null) {
            return "index";
        }




        List<ShipViewModel> ships = shipService.getAllShips();
        model.addAttribute("ships", ships);


        return "home";
    }
}

