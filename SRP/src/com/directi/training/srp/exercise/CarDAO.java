package com.directi.training.srp.exercise;

import java.util.Arrays;
import java.util.List;

public class CarDAO {

    private List<Car> _carsDb = Arrays
            .asList(new Car("1", "Golf III", "Volkswagen"), new Car("2", "Multipla", "Fiat"),
                    new Car("3", "Megane", "Renault"));
    public List<Car> getCarsDB(){
        return  _carsDb;

    }
    public Car getCarById(final String carId){
        for (Car car : _carsDb) {
            if (car.getId().equals(carId)) {
                return car;
            }
        }
        return null;

    }
}
