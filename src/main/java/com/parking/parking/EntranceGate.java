package com.parking.parking;

public class EntranceGate extends Gate{

    public EntranceGate(ParkingLot l, int n){
        super(l, n);
        //entrance gate
        type = "Entrance";
    }

    public boolean EnterLot(Car c){
        //can't enter the lot if it is full
        if(lot.occupancy == lot.capacity){
            System.out.println("Lot "+lot.name+" is at max capacity");
            return false;
        }
        //can't enter the lot if the car is already in another lot
        if(c.ticket != null) {
            System.out.println("Car "+c.license+" is already in a lot");
            return false;
        }
        //issue the car a ticket with the price for the lot, the car, and the lot
        Ticket ticket = new Ticket(lot.getPrice(), c, lot);
        c.getTicket(ticket);
        System.out.println("Car "+c.license+" takes ticket");
        //allow the car to enter the lot
        lot.Enter();
        System.out.println("Car "+c.license+" enters Lot "+lot.name);
        return true;
    }

}
