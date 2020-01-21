package com.company;
//import date class again
import java.util.Date;
//CarPark class
class CarPark {
    //private data fields for car Park class
    private int capacity;
    private ParkPlace [] parkPlaceArray;
    private Ticket[] ticketArray;
    private double hourlyPrice;
    private int count = 0;
    private double totalIncome = 0;

    //overloaded constructor with capacity and hourlyPrice data fields for carPark class
     CarPark(int capacity, double hourlyPrice) {
        this.capacity = capacity;
        this.hourlyPrice = hourlyPrice;
        //declaring two arrays in it to set the length with capacity data field of constructor
        parkPlaceArray = new ParkPlace[this.capacity];
        ticketArray = new Ticket[this.capacity];
    }
    //park vehicle method with vehicle and entryDate arguments
    Ticket parkVehicle(Vehicle vehicle, Date entryDate){
         //declaring a ticket object as null first
        Ticket ticket = null;
         //if(this.isParked)  {System.out.println("Car is already Parked!"); return ticket; }
        //if there are suitable places in the car park;
        if(capacity > 0){
            //create a parkPlace for the entered vehicle
            ParkPlace parkPlace = new ParkPlace(vehicle);
            //decrease the capacity as much as vehicle's size
            capacity -= vehicle.getSize();
            //if there is no suitable place for car, print a warning message with plate number of the car
            if(capacity < 0) System.out.printf("There is no enough Park Place for %s with plate number car! \n",vehicle.getPlateNumber());
            else{
                //create a space in the parkPlace array for the vehicle as much as vehicle's size
                for(int i = 0; i < vehicle.getSize(); i++,count++){
                    parkPlaceArray[count] = parkPlace;
                }
                //all conditions is ok for vehicle to park it to the carpark, print an information message
            System.out.printf("The vehicle with %s plate number is parked.\n",vehicle.getPlateNumber());
            //System.out.println("number of suitable park places : " + capacity);
            }
            //and assign the value of Ticket's object to the ticket
            ticket = new Ticket(vehicle,entryDate);
        } else System.out.println("Car Park is full!"); // if there is no capacity for vehicle, print a message
        //return the ticket object as final
         return ticket;
    }
    //ticketCounter variable to fill ticketArray
    private int ticketCounter = 0;
     //exitVehicle method with ticket and exitDate objects
    Vehicle exitVehicle(Ticket ticket, Date exitDate) {
        //price for the vehicle
        double price = ticket.calculatePrice(this.hourlyPrice,exitDate);
        //total income increases when the method invoked with price value
        this.totalIncome += price;
        //updatind parkPlace array when the car is exit the car Park
        for(int i = 0; i < parkPlaceArray.length; i++) {
            //if parkPlaceArray's elements is not null and parkPlace's car is the same the car in the ticket
            if (parkPlaceArray[i] != null && parkPlaceArray[i].getVehicle().getPlateNumber().equals(ticket.getVehicle().getPlateNumber())) {
                //cause of the vehicle is filled as size of the vehicle in the parkPlace array, decrease it to the same amount in the array
                for (int j = parkPlaceArray[i].getVehicle().getSize(); j > 0; j--,ticketCounter++) {
                    //and add to the ticketArray every time the method invoked
                    ticketArray[ticketCounter] = ticket;
                    //assign null to the exited car's place
                    parkPlaceArray[i] = null;
                    //and remove to the null part to the array with method
                    updateParkPlaceArray();
                }
                //when the car is exit, print the message with price
                System.out.printf("The price for vehicle with %s plate number is %.2f TLs\n", ticket.getVehicle().getPlateNumber(),price);
                //set the ticket's exit date as the entered value exitDate
                ticket.setExitDate(exitDate);
                //return the vehicle of ticket
                return ticket.getVehicle();
            }
          }
        //to increase ticket counter just when the method is invoked
        ticketCounter++;
        //if nothing happened, return the ticket object as null
        return null;
    }
    //method to the remove null places in the parkPlaceArray
    private void updateParkPlaceArray(){
        for(int var = 0; var < parkPlaceArray.length; var++){
            //null situation, invoke the removeElement method
            if(parkPlaceArray[var] == null)
                //update the parkPlaceArray
                parkPlaceArray = removeTheElement(parkPlaceArray,var);
        }
      }
      //remove element method to the remove an element in array
    private ParkPlace [] removeTheElement(ParkPlace[] arr, int index) {
        //new parkPlace array with the length-1 of the parkPlaceArray
        ParkPlace [] temp = new ParkPlace[parkPlaceArray.length -1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            //null situation, continue otherwise add to the new ParkPlaceArray which is temp[]
            if (i == index) {
                continue;
            }
            //copy the content of the array to the parkPlaceArray again
            temp[k++] = parkPlaceArray[i];
        }
        //return the new array instead of parkPlaceArray
        return temp;
    }
    //method for printing the tickets content
    void printTickets(){
        int i = 0;
        while(i < ticketArray.length && ticketArray[i] != null){
            /*to avoid null pointer exception, control the bounds*/
            if(i == ticketArray.length -1){
                if(ticketArray[i] != ticketArray[i-1])
                    System.out.println(ticketArray[i].getTicketInfo());
            }else if(ticketArray[i] != ticketArray[i+1])
            System.out.println(ticketArray[i].getTicketInfo());
            i++;
        }
    }
    //getter method for totalIncome
    double getTotalIncome(){
        return this.totalIncome;
    }
    //for the current vehicle information
    void printVehicleList() {
        int i = 0;
        while(i < parkPlaceArray.length && parkPlaceArray[i] != null){
            //print the vehicle info in the parkPlaceArray
            System.out.println(parkPlaceArray[i].getVehicle().getVehicleInfo());
            //i increased by getSize() because array has getSize() much every car
            i += parkPlaceArray[i].getVehicle().getSize();
        }
    }
}
