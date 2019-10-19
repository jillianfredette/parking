package com.parking.parking;

public abstract class Gate{
    //a gate is either entrance or exit
    String type;
    //a gate has to belong to a lot
    ParkingLot lot;
    //a gate has a number
    int gateNum;

    public Gate(ParkingLot l, int n) {
        lot = l;
        gateNum = n;
    }
}
