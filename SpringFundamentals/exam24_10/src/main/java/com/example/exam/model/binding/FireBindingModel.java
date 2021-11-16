package com.example.exam.model.binding;

public class FireBindingModel {

    Long attackerShipId;
    Long defenderShipId;

    public FireBindingModel() {
    }

    public Long getAttackerShipId() {
        return attackerShipId;
    }

    public FireBindingModel setAttackerShipId(Long attackerShipId) {
        this.attackerShipId = attackerShipId;
        return this;
    }

    public Long getDefenderShipId() {
        return defenderShipId;
    }

    public FireBindingModel setDefenderShipId(Long defenderShipId) {
        this.defenderShipId = defenderShipId;
        return this;
    }
}
