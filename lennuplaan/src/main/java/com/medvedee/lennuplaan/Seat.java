package com.medvedee.lennuplaan;

public class Seat {
    private String seatNumber;
    private boolean isOccupied;
    private boolean isWindowSeat;
    private boolean hasExtraLegroom;
    private boolean isNearExit;

    public Seat(String seatNumber, boolean isWindowSeat, boolean hasExtraLegroom, boolean isNearExit) {
        this.seatNumber = seatNumber;
        this.isOccupied = false;
        this.isWindowSeat = isWindowSeat;
        this.hasExtraLegroom = hasExtraLegroom;
        this.isNearExit = isNearExit;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void occupy() {
        this.isOccupied = true;
    }

    public void vacate() {
        this.isOccupied = false;
    }

    public boolean isWindowSeat() {
        return isWindowSeat;
    }

    public boolean hasExtraLegroom() {
        return hasExtraLegroom;
    }

    public boolean isNearExit() {
        return isNearExit;
    }
}
