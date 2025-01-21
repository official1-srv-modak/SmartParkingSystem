package com.modakdev.smartparkingsystem.model;

public class ParkingSpot {
    int id;
    boolean isReserved;

    public ParkingSpot(int id, boolean isReserved) {
        this.id = id;
        this.isReserved = isReserved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public void reserve()
    {
        this.isReserved = true;
    }
    public void release()
    {
        this.isReserved = false;
    }
}
