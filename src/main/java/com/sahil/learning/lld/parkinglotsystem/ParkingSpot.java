package com.sahil.learning.lld.parkinglotsystem;

import com.sahil.learning.lld.parkinglotsystem.model.Vehicle;
import com.sahil.learning.lld.parkinglotsystem.model.VehicleType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString(exclude = "vehicle")
@EqualsAndHashCode
@Getter
public class ParkingSpot {

    private final String parkingSpotId;
    private Vehicle vehicle;
    private final VehicleType type;

    public ParkingSpot(String parkingSpotId, VehicleType type) {
        this.parkingSpotId = parkingSpotId;
        this.type = type;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public synchronized void parkVehicle(Vehicle vehicle) {
        if (vehicle.getVehicleType() == type) {
            this.vehicle = vehicle;
        } else {
            throw new IllegalArgumentException("Can't park a %s in %s spot".formatted(vehicle.getVehicleType(), type));
        }
    }

    public void unparkVehicle(Vehicle  vehicle) {
        if(vehicle.equals(this.vehicle)){
            this.vehicle = null;
        }else {
            throw new IllegalArgumentException("Can't unpark vehicle %s".formatted(vehicle));
        }
    }
}
