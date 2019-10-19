package com.parking.parking;

public class ParkingLot {
    //max capacity
    int capacity;
    //current occupancy
    int occupancy;
    //price of the lot
    int price;
    //current profits
    int profit;
    String name;

    public ParkingLot(int c, int p, String n){
        //initialized with a max capacity
        capacity = c;
        //initially empty
        occupancy = 0;
        //initialize with the price of the lot
        price = p;
        //initially has no profits
        profit = 0;
        name = n;
    }

    public void Enter(){
        //when a car enters the occupancy increases
        occupancy++;
    }

    public int getPrice(){
        //returns the price of the lot
        return price;
    }

    public void payTicket(int p){
        //when a ticket is paid the profits increase
        profit+=p;
    }

    public void Exit(){
        occupancy--;
    }

}
