package com.example.exam.service.impl;

import com.example.exam.model.entity.Ship;
import com.example.exam.model.service.ShipServiceModel;
import com.example.exam.repository.ShipRepository;
import com.example.exam.service.CategoryService;
import com.example.exam.service.ShipService;
import com.example.exam.service.UserService;
import com.example.exam.util.CurrentUser;

import com.example.exam.view.ShipViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ShipServiceImpl implements ShipService {

    private final ModelMapper modelMapper;
    private final ShipRepository shipRepository;
    private final UserService userService;
    private final CurrentUser currentUser;
    private final CategoryService categoryService;

    public ShipServiceImpl(ModelMapper modelMapper, ShipRepository shipRepository, UserService userService, CurrentUser currentUser, CategoryService categoryService) {
        this.modelMapper = modelMapper;
        this.shipRepository = shipRepository;
        this.userService = userService;
        this.currentUser = currentUser;
        this.categoryService = categoryService;
    }


    @Override
    public void addShip(ShipServiceModel shipServiceModel) {
        Ship ship = modelMapper.map(shipServiceModel, Ship.class);
        ship.setUser(userService.findById(currentUser.getId()));
        ship.setCategory(categoryService.findByCategoryNameEnum(shipServiceModel.getCategory()));

        shipRepository.save(ship);
    }

    @Override
    public List<ShipViewModel> getAllShips() {
        return shipRepository.getAllShips().stream().map(shipServiceModel ->
                modelMapper.map(shipServiceModel, ShipViewModel.class)
        ).collect(Collectors.toList());

    }

    @Override
    public List<ShipViewModel> getShipsByUserId(Long id) {


        return shipRepository.getShipsByUserId(id).map(ships -> ships.stream().map(ship -> modelMapper.map(ship, ShipViewModel.class)).collect(Collectors.toList())).orElse(null);
    }

    @Override
    public List<ShipViewModel> getShipsOfOtherUsers(Long id) {

        return shipRepository.getShipsOfOtherUsers(id).map(ships -> ships.stream().map(ship -> modelMapper.map(ship, ShipViewModel.class)).collect(Collectors.toList())).orElse(null);
    }

    @Override
    public void makeDamageFromShipToShip(Long attackerShipId, Long defenderShipId) {
        Ship attackerShip = shipRepository.getShipById(attackerShipId);
        Ship defenderShip = shipRepository.getShipById(defenderShipId);

        defenderShip.setHealth(defenderShip.getHealth() - attackerShip.getPower());
        if (defenderShip.getHealth() <= 0) {
            shipRepository.delete(defenderShip);
        } else {
            shipRepository.save(defenderShip);
        }
    }


}
