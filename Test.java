package com.company;
import java.util.Calendar;
import java.util.Date;
//Test class
public class Test {
    static int var = 4;
    public static void main(String[]args){
        //Creating a car Park object with 10 capacity and 5 hourlyPrice
        CarPark carPark = new CarPark(10,5);
        //creating 5 vehicle objects with the size of 4, 2, 1, 2, 4
        Vehicle vehicle1 = new Vehicle("34CSE1141",4);
        Vehicle vehicle2 = new Vehicle("34CSE1142",2);
        Vehicle vehicle3 = new Vehicle("34CSE1143",1);
        Vehicle vehicle4 = new Vehicle("34CSE1144",2);
        Vehicle vehicle5 = new Vehicle("34CSE1145",4);
        Date date = new Date(); // current time
        // i am sure there is a too short way but i gotta be quick :)
        Date date1 = new Date(date.getYear(),date.getMonth(),date.getDate(),date.getHours() + 1,date.getMinutes(),date.getSeconds());
        Date date2 = new Date(date.getYear(),date.getMonth(),date.getDate(),date.getHours() + 2,date.getMinutes(),date.getSeconds());
        Date date3 = new Date(date.getYear(),date.getMonth(),date.getDate(),date.getHours() + 3,date.getMinutes(),date.getSeconds());
        Date date4 = new Date(date.getYear(),date.getMonth(),date.getDate(),date.getHours() + 4,date.getMinutes(),date.getSeconds());
        /*cars enter the car Park */
        carPark.parkVehicle(vehicle1,date);
        carPark.parkVehicle(vehicle2,date1);
        carPark.parkVehicle(vehicle3,date2);
        carPark.parkVehicle(vehicle4,date3);
        carPark.parkVehicle(vehicle5,date4);
        //printing vehicles info with method
        carPark.printVehicleList();
        //creating the tickets after parking the vehicles to exit them
        Ticket ticket1 = new Ticket(vehicle1,date);
        Ticket ticket2 = new Ticket(vehicle2,date1);
        Ticket ticket3 = new Ticket(vehicle3,date2);
        Ticket ticket4 = new Ticket(vehicle4,date3);
        Ticket ticket5 = new Ticket(vehicle5,date4);
        //exit to of them
        carPark.exitVehicle(ticket1,date4);
        carPark.exitVehicle(ticket2,date4);
        //print the remaining vehicles info
        carPark.printVehicleList();
        //exit the remaining vehicles
        carPark.exitVehicle(ticket3,date4);
        carPark.exitVehicle(ticket4,date4);
        carPark.exitVehicle(ticket5,date4);
        //print the list as final
        carPark.printVehicleList();
        //print the total income with car Park object
        System.out.println("total income by now " + carPark.getTotalIncome() +"TLs");
        //print the content of the tickets
        carPark.printTickets();

    }
}
