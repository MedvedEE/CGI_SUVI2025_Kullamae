package com.medvedee.lennuplaan;

public class Reservation {
    private int flightId;
    private String seat;

    public Reservation() {}

    public Reservation(int flightId, String seat) {
        this.flightId = flightId;
        this.seat = seat;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}
