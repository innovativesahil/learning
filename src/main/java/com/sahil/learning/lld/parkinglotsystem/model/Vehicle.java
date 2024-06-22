package com.sahil.learning.lld.parkinglotsystem.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public abstract class Vehicle {

    @Getter
    private final VehicleType vehicleType;
    private final String vehicleId;

    public Vehicle(VehicleType vehicleType, String vehicleId) {
        this.vehicleType = vehicleType;
        this.vehicleId = vehicleId;
    }

}
