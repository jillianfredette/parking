package com.parking.parking;

import java.util.HashMap;
import java.util.HashSet;

public class ParkingLot {
    //max capacity
    final int capacity;
    //current occupancy
    int occupancy;
    //price of the lot
    final int price;
    //current profits
    int profit;
    String name;
    HashMap<Integer, EntranceGate> entGates = new HashMap<Integer, EntranceGate>();
    HashMap<Integer, ExitGate> exitGates = new HashMap<Integer, ExitGate>();

    public ParkingLot(String n, int c, int p){
        //initialized with a max capacity
        capacity = c;
        //initially empty
        occupancy = 0;
        //initialize with the price of the lot
        price = p;
        //initially has no profits
        profit = 0;
        name = n;
        System.out.println("Parking Lot "+this.name+" added with capacity "+ this.capacity +" cars and price "+this.price+" cents");
    }

    public boolean addEntrance(int n){
        if(entGates.containsKey(n)){
            return false;
        }

        entGates.put(n, new EntranceGate(this, n));
        System.out.println("Gate "+n+" added to Lot "+this.name+" as an Entrance");

        return true;
    }

    public boolean addExit(int n){
        if(exitGates.containsKey(n)){
            return false;
        }

        exitGates.put(n, new ExitGate(this, n));
        System.out.println("Gate "+n+" added to Lot "+this.name+" as an Exit");

        return true;
    }

    public boolean Enter(Car c, int n){
        //make sure the gate exists
        if(!entGates.containsKey(n)){
            System.out.println("Invalid input, Lot "+this.name+" does not have an entrance gate "+n);
            return false;
        }
        if(!entGates.get(n).EnterLot(c)){
            return false;
        }
        //allow the car to enter the lot
        System.out.println("Car "+c.license+" enters Lot "+this.name+" through gate "+n);
        //when a car enters the occupancy increases
        occupancy++;
        return true;
    }

    public int getPrice(){
        //returns the price of the lot
        return price;
    }

    public void payTicket(int p){
        //when a ticket is paid the profits increase
        profit+=p;
    }

    public boolean Exit(Car c, int n){
        if(!exitGates.containsKey(n)){
            System.out.println("Invalid input, Lot "+this.name+" does not have an exit gate "+n);
            return false;
        }
        if(!exitGates.get(n).ExitLot(c)){
            return false;
        }
        //the car exits the lot
        System.out.println("Car "+c.license+" exits Lot "+this.name+" through gate "+n);
        //the occupancy decreases
        occupancy--;
        return true;
    }

}
