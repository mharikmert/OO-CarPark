package com.company;
//import Date class to use it for dates
import java.util.Date;
//Ticket class
 public class Ticket {
     //private data fields
    private Vehicle vehicle;
    private Date entryDate;
    private Date exitDate;
    private double totalPrice;
    private int numberOfTickets;
    //parkTime variable to know how many hours the car parked
    private double parkTime = 0;
    //Overloaded constructor with vehicle and entryDate data fields
    public Ticket(Vehicle vehicle, Date entryDate){
        this.vehicle = vehicle;
        this.entryDate = entryDate;
    }
    //method to calculate the fee for vehicle with hourlyPrice and exitDate
    double calculatePrice(double hourlyPrice, Date exitDate){
        //updating exitDate to entered entryDate
        this.exitDate = exitDate;
        //parkTime calculation
        this.parkTime =  this.exitDate.getHours() - this.entryDate.getHours();
        if(this.exitDate.getHours() < this.entryDate.getHours()) parkTime += 24;
        //if not exited the exact minute, then roll it up and increase parkTime
        if(exitDate.getMinutes() - this.entryDate.getMinutes() > 0) parkTime++;
        //total price calculation for vehicle
        this.totalPrice = this.vehicle.getSize() * hourlyPrice * parkTime;
        //return the total price
         return totalPrice;
    }
    //accordig to whether the car exited the carPark, return ticket information
    String getTicketInfo(){
        return this.exitDate == null ? "\nTicket Info\n"
                + "Plate Number: " + this.vehicle.getPlateNumber() + "\n"
                + "Entry :" + this.entryDate :
                        "\nTicketInfo\n"
                + "Plate Number: "+ this.vehicle.getPlateNumber() + "\n"
                + "Entry: "+this.entryDate + "\n"
                + "Exit:"+this.exitDate + "\n"
                + "Hour:"+this.parkTime +"\n"
                + "Fee:" + getPrice() +" TLs\n";
    }
    //getter method for vehicle of ticket
    public Vehicle getVehicle(){
        return this.vehicle;
    }
    //getter method for total price
    private double getPrice(){
        return this.totalPrice;
    }
    //setter method for exitDate depends on the entered date value
    void setExitDate(Date date){
        this.exitDate = date;
    }
    //getter method for numberOfTickets data field
    public int getNumberOfTickets(){
        return this.numberOfTickets;
    }
    public void setNumberOfTickets(int numberOfTickets){
        this.numberOfTickets = numberOfTickets;
    }

}
