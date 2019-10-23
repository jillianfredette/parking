package com.parking.parking;

import java.util.HashMap;

public class ParkingGroup {
    //price of the lots
    int price;
    //discount for the lots
    int discount;
    //group has a name
    String name;
    HashMap<String, ParkingLot> lots = new HashMap<String, ParkingLot>();

    public ParkingGroup(String n, int p, int d){
        price = p;
        discount = d;
        name = n;
        System.out.println("Parking group "+name+" added with a price for lots of "+price+" cents and a discount for lots of "+discount+" percent");
    }

    public int inquirePrice(){
        System.out.println("Parking Group "+this.name+" sends pricing information");
        return getPrice();
    }

    public int getPrice(){
        return (price-((discount*price)/100));
    }

    public ParkingLot addLot(String n, int c){
        if(lots.containsKey(n)){
            System.out.println("Parking Group "+this.name+" already has a lot named "+n+", lot not added");
            return null;
        }
        ParkingLot newLot = new ParkingLot(this, n, c);
        lots.put(newLot.name, newLot);
        System.out.println("Parking Lot "+newLot.name+" added to Parking Group "+this.name);
        return newLot;
    }
}
