package com.example.parkingcontrol.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.parkingcontrol.models.ParkingSpotModel;

public interface ParkingSpotRepository  extends JpaRepository<ParkingSpotModel, UUID>{
    
    boolean existsByLicensePlateCar(String licensePlateCar);
    boolean existsByParkingSpotNumber(String parkingSpotNumber);
    boolean existsByApartmentAndBlock(String apartment, String block);

}
