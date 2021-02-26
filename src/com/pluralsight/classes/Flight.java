package com.pluralsight.classes;

public class Flight {
    private int passengers, flightNumber, totalCheckedBags, seats = 150;
    private char flightClass;
    private boolean[] isSeatAvailable;
    private int maxCarryOns = seats * 2, totalCarryOns;

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
        if(hasSeating())
            passengers +=1;
        else
            handleTooMany();
    }

    public void add1Passenger(int bags){
        if(hasSeating()) {
            add1Passenger();
            totalCheckedBags += bags;
        }
    }

    private boolean hasSeating() {
        return passengers < seats;
    }
    private void handleTooMany() {
        System.out.println("Too many'");
    }

    private boolean hasCarryOnSpace(int carryOns) {
        return totalCarryOns + carryOns <= maxCarryOns;
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
    public void addPassengers(Passenger... list) {
        if(hasSeating(list.length)) {
            passengers += list.length;
            for (Passenger passenger : list)
                totalCheckedBags += passenger.getCheckedBags();
        }
        else
            handleTooMany();
    }
    }

