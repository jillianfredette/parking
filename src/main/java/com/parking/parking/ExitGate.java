package com.parking.parking;

public class ExitGate extends Gate {

    public ExitGate(ParkingLot l){
        super(l);
        //exit gate
        type = GateType.Exit;
    }

    public boolean ExitLot(Car c){
        Ticket ticket = c.giveTicket();
        System.out.println("Car "+c.license+" presents ticket with timestamp "+ticket.timestamp);
        lot.payTicket(ticket.price);
        System.out.println("Car "+c.license+" pays "+ticket.price+" cents");
        return true;
    }
}
