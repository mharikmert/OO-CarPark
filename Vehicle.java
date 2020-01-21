package com.company;
/*Vehicle class*/
public class Vehicle {
    /*Vehicle class's data fields plate number and size*/
    private String plateNumber;
    private int size;
    //Vehicle constructor
    public Vehicle(String plateNumber, int size){
        this.plateNumber = plateNumber;
        this.size = size;
    }
    //method to return information about vehicle
    String getVehicleInfo(){
        return "\nVehicle Info \nPlate number: " + this.getPlateNumber() + "\nSize: "+ this.getSize() + "\n";
    }
    //getter method for plate number
    String getPlateNumber(){
        return this.plateNumber;
    }
    //getter method for size
    int getSize(){
        return this.size;
    }

}
