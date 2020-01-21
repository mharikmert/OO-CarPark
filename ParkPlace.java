package com.company;
//Park Place class
public class ParkPlace {
    //private data fields for ParkPlace class
    private int size;
    private Vehicle vehicle;
    //ParkPlace constructor
    public ParkPlace(Vehicle vehicle){
        this.vehicle = vehicle;
    }
    //getter method for size of parkPlace
    public int getSize(){
        return this.size;
    }
    //getter method for vehicle in parkPlace
    public Vehicle getVehicle(){
        return this.vehicle;
    }
}
