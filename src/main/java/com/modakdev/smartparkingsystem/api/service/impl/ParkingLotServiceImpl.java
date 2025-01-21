package com.modakdev.smartparkingsystem.api.service.impl;


import com.modakdev.smartparkingsystem.model.ParkingSpot;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingLotServiceImpl {
    private final List<ParkingSpot> spots = new ArrayList<>();

    public ParkingLotServiceImpl() {
        for(int i = 0; i<20; i++)
        {
            spots.add(new ParkingSpot(i, false));
        }
    }

    public List<ParkingSpot> getAllSpots() {
        return spots;
    }

    public void reserveSpot(int id){
        spots.stream()
                .filter(spot -> spot.getId() == id)
                .findFirst()
                .ifPresent(ParkingSpot :: reserve);
    }

    public void releaseSpot(int id){
        spots.stream()
                .filter(spot -> spot.getId() == id)
                .findFirst()
                .ifPresent(ParkingSpot :: release);
    }
}
