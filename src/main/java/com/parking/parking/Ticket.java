package com.parking.parking;

public class Ticket{
    int price;
    Car car;
    ParkingLot lot;

    public Ticket(int p, Car c, ParkingLot l){
        //a ticket has a price associated with it based on the lot
        price = p;
        //a ticket has to belong to a car
        car = c;
        //a ticket has to belong to a lot
        lot = l;
    }
}
