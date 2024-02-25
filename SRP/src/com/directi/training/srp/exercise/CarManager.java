package com.directi.training.srp.exercise;

import java.util.Arrays;
import java.util.List;

public class CarManager
{
    private CarDAO carDAO = new CarDAO();
    private CarNames carNames = new CarNames();
    private BestCar bestCar = new BestCar() ;


    public  CarManager(){
    }

    public Car getFromDb(final String carId )
    {
        return carDAO.getCarById( carId);
    }

    public String getCarsNames()
    {
        return carNames.getCarsNames(carDAO.getCarsDB());
    }

    public Car getBestCar()
    {
        return bestCar.getBestCar(carDAO.getCarsDB());
    }
}
