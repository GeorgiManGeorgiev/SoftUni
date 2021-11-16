package com.example.exam.service;

import com.example.exam.model.entity.Ship;
import com.example.exam.model.service.ShipServiceModel;
import com.example.exam.view.ShipViewModel;

import java.util.List;

public interface ShipService {
    void addShip(ShipServiceModel shipServiceModel);


    List<ShipViewModel> getAllShips();


    List<ShipViewModel> getShipsByUserId(Long id);

    List<ShipViewModel> getShipsOfOtherUsers(Long id);

    void makeDamageFromShipToShip(Long attackerShipId, Long defenderShipId);
}
