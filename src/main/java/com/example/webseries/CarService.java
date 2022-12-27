package com.example.webseries;

import java.util.List;

public interface CarService {
    public String upsertCar(CarModel car);

    public String editCar(CarModel car);

    public List<CarModel> getAllCar();

    public CarModel getById(String id);

    public String deleteCar(String id);


}
