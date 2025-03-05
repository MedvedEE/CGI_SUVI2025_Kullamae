package com.medvedee.lennuplaan;


class Flight {
    private int id;
    private String origin;
    private String destination;
    private String date;
    private String time;
    private double price;

    public Flight(int id, String origin, String destination, String date, String time, double price) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.price = price;
    }

    public String getDestination() {
        return destination;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public double getPrice() {
        return price;
    }
}