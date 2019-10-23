package com.parking.parking;

import java.util.HashMap;
import java.util.HashSet;

public class ParkingLot {
    //max capacity
    final int capacity;
    //current occupancy
    int occupancy;
    //current profits
    int profit;
    String name;
    ParkingGroup group;
    EntranceGate entGate;
    ExitGate exitGate;

    public ParkingLot(ParkingGroup g, String n, int c){
        //set group lot belongs to
        group = g;
        //initialized with a max capacity
        capacity = c;
        //initially empty
        occupancy = 0;
        //initially has no profits
        profit = 0;
        //give lot a name
        name = n;
        entGate = new EntranceGate(this);
        exitGate = new ExitGate(this);
        System.out.println("Parking Lot "+this.name+" added with a capacity of "+ this.capacity +" cars and belongs to Parking Group "+group.name);
    }

    public boolean Enter(Car c){
        if(!entGate.EnterLot(c)){
            return false;
        }
        //allow the car to enter the lot
        System.out.println("Car "+c.license+" enters Lot "+this.name);
        //when a car enters the occupancy increases
        occupancy++;
        return true;
    }

    public int getPrice(){
        //returns the price of the lot
        return group.getPrice();
    }

    public void payTicket(int p){
        //when a ticket is paid the profits increase
        profit+=p;
    }

    public boolean Exit(Car c){
        if(!exitGate.ExitLot(c)){
            return false;
        }
        //the car exits the lot
        System.out.println("Car "+c.license+" exits Lot "+this.name);
        //the occupancy decreases
        occupancy--;
        return true;
    }

    public int inquireSpace(){
        System.out.println("Parking Lot "+this.name+" sends information about current availability");
        return (capacity-occupancy);
    }

}
