package com.parking.parking;

import java.time.LocalDateTime;

public class Ticket{
    int price;
    Car car;
    ParkingLot lot;
    LocalDateTime timestamp;


    public Ticket(int p, Car c, ParkingLot l){
        //a ticket has a price associated with it based on the lot
        price = p;
        //a ticket has to belong to a car
        car = c;
        //a ticket has to belong to a lot
        lot = l;
        timestamp = LocalDateTime.now();
    }
}
