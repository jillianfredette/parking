package com.parking.parking;

public abstract class Gate{
    //a gate is either entrance or exit
    GateType type;
    //a gate has to belong to a lot
    ParkingLot lot;

    public Gate(ParkingLot l) {
        lot = l;
    }
}
