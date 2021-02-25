package com.pluralsight.classes;

public class Flight {
    private int passengers, flightNumber, seats = 150;
    private char flightClass;
    private boolean[] isSeatAvailable;

    {
        isSeatAvailable = new boolean[seats];
        for (int i = 0; i < seats; i++)
            isSeatAvailable[i] = true;
    }
    public Flight() {}
    public Flight(int flightNumber) {

        this.flightNumber = flightNumber;
    }
    public Flight(char flightClass) {

        this.flightClass = flightClass;
    }

    public void add1Passenger() {
        if(passengers < seats)
            passengers +=1;
        else
            handleTooMany();
    }
    private void handleTooMany() {
        System.out.println("Too many'");
    }

    public boolean hasRoom(Flight f2) {
        int total = this.passengers + f2.passengers;
        return total <= seats;
        }

    public Flight createNewWithBoth(Flight f2) {
        Flight newFlight = new Flight();
        newFlight.seats = seats;
        newFlight.passengers = passengers + f2.passengers;
        return newFlight;
        }

    public int getSeats() {
        return seats;
    }
    public void setSeats(int seats) {
        this.seats = seats;
    }
    }

