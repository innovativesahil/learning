package com.sahil.learning.lld.parkinglotsystem;

import com.sahil.learning.lld.parkinglotsystem.model.*;

import java.util.List;
import java.util.UUID;

public class ParkingLotDemo {

    public static void main(String[] args) {

        ParkingLot parkingLot = ParkingLot.getInstance();


        ParkingSpot parkingSpot = new ParkingSpot(UUID.randomUUID().toString(), VehicleType.CAR);
        ParkingSpot parkingSpotBike = new ParkingSpot(UUID.randomUUID().toString(), VehicleType.BIKE);
        ParkingSpot parkingSpotBus = new ParkingSpot(UUID.randomUUID().toString(), VehicleType.BUS);
        Level level = new Level(0, List.of(parkingSpot, parkingSpotBike, parkingSpotBus));
        parkingLot.addLevel(level);

        Vehicle car = new Car("car");
        Vehicle bike = new Bike("bike");
        Vehicle truck = new Truck("truck");
        Vehicle bus = new Bus("bus");

        System.out.println("Parking for car " + parkingLot.parkVehicle(car));
        System.out.println("Unparking for car " + parkingLot.unparkVehicle(car));
        System.out.println("Parking for bike " + parkingLot.parkVehicle(bike));
        System.out.println("Unparking for bike " + parkingLot.unparkVehicle(bike));
        System.out.println("Parking for bus " + parkingLot.parkVehicle(bus));
        System.out.println("Unparking for bus " + parkingLot.unparkVehicle(bus));
        System.out.println("Parking for truck " + parkingLot.parkVehicle(truck));
        System.out.println("Unparking for truck " + parkingLot.unparkVehicle(truck));

        parkingLot.displayAvailability();

    }
}
