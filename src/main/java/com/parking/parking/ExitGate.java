package com.parking.parking;

public class ExitGate extends Gate {

    public ExitGate(ParkingLot l, int n){
        super(l, n);
        //exit gate
        type = "Exit";
    }

    public boolean ExitLot(Car c){
        if(c.ticket == null || c.ticket.lot != lot){
            System.out.println("Car "+c.license+" is not in Lot "+ lot.name);
            return false;
        }
        Ticket ticket = c.giveTicket();
        System.out.println("Car "+c.license+" presents ticket with timestamp "+ticket.timestamp);
        lot.payTicket(ticket.price);
        System.out.println("Car "+c.license+" pays "+ticket.price+" cents");
        return true;
    }
}
