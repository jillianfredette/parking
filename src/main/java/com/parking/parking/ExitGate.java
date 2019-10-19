package com.parking.parking;

public class ExitGate extends Gate {

    public ExitGate(ParkingLot l, int n){
        super(l, n);
        type = "Exit";
    }

    public boolean ExitLot(Car c){
        if(c.ticket == null || c.ticket.lot != lot){
            System.out.println("Car "+c.license+" is not in Lot "+ lot.name);
            return false;
        }
        Ticket ticket = c.giveTicket();
        lot.payTicket(ticket.price);
        System.out.println("Car "+c.license+" pays "+ticket.price+" cents");
        lot.Exit();
        System.out.println("Car "+c.license+" exits Lot "+lot.name);
        return true;
    }
}
