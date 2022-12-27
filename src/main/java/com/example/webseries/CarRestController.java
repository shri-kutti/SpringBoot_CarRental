package com.example.webseries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarRestController {

    @Autowired
    private CarService carService;

    @PostMapping("/saveCar")
    public ResponseEntity<String> addCar(@RequestBody CarModel car){
        return new ResponseEntity<>(carService.upsertCar(car), HttpStatus.ACCEPTED);
    }

    @PostMapping("/editCar")
    public ResponseEntity<String> editCar(@RequestBody CarModel car,@RequestParam(name="id") String id){
        car.setCarId(id);
        return new ResponseEntity<>(carService.upsertCar(car), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getCars")
    public ResponseEntity<List<CarModel>> getAllCars(){
        return new ResponseEntity<>(carService.getAllCar(),HttpStatus.OK);
    }

    @GetMapping("/getCar")
    public ResponseEntity<CarModel> getByID(@RequestParam(name = "id") String id){
        return new ResponseEntity<>(carService.getById(id),HttpStatus.OK);
    }

    @DeleteMapping("/deleteCar")
    public ResponseEntity<String> deleteCar(@RequestParam(name = "id") String id){
        return new ResponseEntity<>(carService.deleteCar(id),HttpStatus.OK);
    }

}
