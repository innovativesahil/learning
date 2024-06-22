package com.sahil.learning.lld.parkinglotsystem;

import com.sahil.learning.lld.parkinglotsystem.model.Vehicle;

import java.util.List;

public class Level {

    private final int floor;
    private final List<ParkingSpot> parkingSpots;

    public Level(int floor, List<ParkingSpot> parkingSpots) {
        this.floor = floor;
        this.parkingSpots = parkingSpots;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for(ParkingSpot parkingSpot : parkingSpots) {
            if(parkingSpot.isAvailable() && parkingSpot.getType().equals(vehicle.getVehicleType())){
                parkingSpot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }
    public boolean unparkVehicle(Vehicle vehicle) {
        for(ParkingSpot parkingSpot : parkingSpots) {
            if(!parkingSpot.isAvailable() && parkingSpot.getVehicle().equals(vehicle)){
                parkingSpot.unparkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public void displayAvailability() {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if(parkingSpot.isAvailable()){
                System.out.printf("Parking spot available at floor %d %s%n", floor, parkingSpot);
            }
        }
    }

}
