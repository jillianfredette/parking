package com.parking.parking;

import java.util.HashMap;

public class Car {
    String license;
    Ticket ticket;

    public Car(String l){
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

    public void inquirePrice(ParkingGroup g){
        System.out.println("Car "+this.license+" inquires about price from Parking Group "+g.name);
        int price = g.inquirePrice();
        System.out.println("Car "+this.license +" receives total price (price with discount) of "+price+" cents from Parking Group "+g.name);
    }

    public void inquireSpace(ParkingLot l){
        System.out.println("Car "+this.license+" inquires about availability from Parking Lot "+l.name);
        int space = l.inquireSpace();
        System.out.println("Car "+this.license+" receives current availability of "+space+" spaces from Parking Lot "+l.name);
    }

    public void park(HashMap<String, ParkingLot> lotsMap){
        ParkingLot lot = null;
        boolean entered = false;

        if(this.ticket != null) {
            System.out.println("Car "+this.license+" is already in a lot, can't enter another lot");
            return;
        }

        //find lot with lowest price and availability
        for(HashMap.Entry<String, ParkingLot> entry : lotsMap.entrySet()){
            if(entry.getValue().vacancy() != 0){
                if(lot == null) lot = entry.getValue();
                else{
                    if(entry.getValue().getPrice() < lot.getPrice()) lot = entry.getValue();
                }
            }
        }
        if (lot == null) {
            //if no lots have availability, can't park
            System.out.println("All lots are full, Car "+this.license+" can't park");
        }
        else{
            entered = lot.Enter(this);
        }
    }

    public void exit(){
        if(ticket != null){
            ticket.lot.Exit(this);
        }
        else System.out.println("Car "+this.license+" is not in a lot, can't exit");
    }
}
