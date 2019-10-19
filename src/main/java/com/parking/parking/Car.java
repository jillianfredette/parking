package com.parking.parking;

public class Car {
    int license;
    Ticket ticket;

    public Car(int l){
        license = l;
        System.out.println("Car "+this.license+" added");
    }

    public void getTicket(Ticket t){
        ticket = t;
    }

    public Ticket giveTicket(){
        Ticket paidTicket = ticket;
        ticket = null;
        return paidTicket;
    }
}
