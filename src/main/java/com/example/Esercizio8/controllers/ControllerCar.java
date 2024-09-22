package com.example.Esercizio8.controllers;

import com.example.Esercizio8.entities.Car;
import com.example.Esercizio8.services.ServiceCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class ControllerCar {
    @Autowired
    private ServiceCar serviceCar;
    @PostMapping ("/new")
    public ResponseEntity<Car> insertCar (@RequestBody Car newCar) {
        return ResponseEntity.ok(ServiceCar.insertCar(newCar));

    }
    @GetMapping("/realAll")
    public ResponseEntity<List<Car>> selectAllCars() {
        return ResponseEntity.ok(ServiceCar.selectAllCars());
    }
    @GetMapping("/read/{id}")
    public ResponseEntity<Car> selectCarById(@PathVariable Long id) {
        return ResponseEntity.ok(ServiceCar.selectCarById());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Car> updateCar (@RequestBody Car newCar, @PathVariable Long id) {
        return  ResponseEntity.ok(serviceCar.updateCar(newCar,id));
    }
    @PutMapping("/updateType/{id}")
    public ResponseEntity<Car> updateType(@RequestParam String type, @PathVariable Long id) {
        return ResponseEntity.ok(serviceCar.updateType(type, id));
    }
    @DeleteMapping("/deleteCar/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Long id){
        boolean deleteCheck = serviceCar.deleteAllCars();
        if (deleteCheck){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatusCode.valueOf(409)).build();
        }
    }
    @DeleteMapping("/deleteAll")
    public void deleteAllCars() {
        serviceCar.deleteAllCars();
    }



}
