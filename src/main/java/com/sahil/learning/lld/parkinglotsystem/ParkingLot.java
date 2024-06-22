package com.sahil.learning.lld.parkinglotsystem;

import com.sahil.learning.lld.parkinglotsystem.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private static ParkingLot parkingLot;
    private final List<Level> levels;

    private ParkingLot() {
        levels = new ArrayList<>();
    }

    public static synchronized ParkingLot getInstance() {
        if (parkingLot == null) {
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }

    public void addLevel(Level level) {
        levels.add(level);
    }

    public List<Level> getLevels() {
        return levels;
    }

    public boolean parkVehicle(final Vehicle vehicle) {
        for(Level level : levels) {
            if(level.parkVehicle(vehicle)){
                return true;
            }
        }
        return false;
    }
    public boolean unparkVehicle(final Vehicle vehicle) {
        for(Level level : levels) {
            if(level.unparkVehicle(vehicle)){
                return true;
            }
        }
        return false;
    }

    public void displayAvailability(){
        for (Level level: levels){
            level.displayAvailability();
        }
    }
}
