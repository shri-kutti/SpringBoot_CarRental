package com.example.webseries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImp implements CarService {

    @Autowired
    private CarRepository carRepo;

    @Override
    public String upsertCar(CarModel car) {
        carRepo.save(car);
        return "Success";
    }

    @Override
    public String editCar(CarModel car) {
        carRepo.save(car);
        return "Success";
    }

    @Override
    public List<CarModel> getAllCar() {
        return carRepo.findAll();
    }

    @Override
    public CarModel getById(String id) {
        Optional<CarModel> findById = carRepo.findById(id);

        if(findById.isPresent())
            return findById.get();
        else
            return null;
    }

    @Override
    public String deleteCar(String id) {
        if(carRepo.existsById(id)){
            carRepo.deleteById(id);
            return "Deleted Successfully";
        } else{
            return "No record found";
        }
    }
}
