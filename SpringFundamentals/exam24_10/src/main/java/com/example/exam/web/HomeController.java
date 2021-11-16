package com.example.exam.web;

import com.example.exam.model.binding.FireBindingModel;
import com.example.exam.service.ShipService;
import com.example.exam.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final ShipService shipService;


    public HomeController(CurrentUser currentUser, ShipService shipService) {
        this.currentUser = currentUser;
        this.shipService = shipService;

    }


    @ModelAttribute
    public FireBindingModel fireBindingModel() {
        return new FireBindingModel();
    }

    @GetMapping()
    public String index(Model model) {
        if (currentUser.getId() == null) {
            return "index";
        }

        model.addAttribute("currentUserShips", shipService.getShipsByUserId(currentUser.getId()));
        model.addAttribute("defenderShips", shipService.getShipsOfOtherUsers(currentUser.getId()));
        model.addAttribute("ships", shipService.getAllShips());
        model.addAttribute("currentUser", currentUser);



        return "home";
    }


    @PostMapping("")
    public String fire(FireBindingModel fireBindingModel, Model model){
        shipService.makeDamageFromShipToShip(fireBindingModel.getAttackerShipId(),fireBindingModel.getDefenderShipId());



        model.addAttribute("currentUserShips", shipService.getShipsByUserId(currentUser.getId()));
        model.addAttribute("defenderShips", shipService.getShipsOfOtherUsers(currentUser.getId()));
        model.addAttribute("ships", shipService.getAllShips());
        model.addAttribute("currentUser", currentUser);

        return "home";
    }
}

