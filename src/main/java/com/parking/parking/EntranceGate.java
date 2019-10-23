package com.parking.parking;

public class EntranceGate extends Gate{

    public EntranceGate(ParkingLot l){
        super(l);
        //entrance gate
        type = GateType.Entrance;
    }

    public boolean EnterLot(Car c){
        //can't enter the lot if it is full
        if(lot.occupancy == lot.capacity){
            System.out.println("Lot "+lot.name+" is at max capacity");
            return false;
        }
        //issue the car a ticket with the price for the lot, the car, and the lot
        Ticket ticket = new Ticket(lot.getPrice(), c, lot);
        c.getTicket(ticket);
        System.out.println("Car "+c.license+" takes ticket with timestamp "+ticket.timestamp);
        return true;
    }

}
