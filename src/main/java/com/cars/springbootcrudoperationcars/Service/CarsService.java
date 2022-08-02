package com.cars.springbootcrudoperationcars.Service;

import com.cars.springbootcrudoperationcars.model.Cars;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CarsService {

    private int carIdCount = 1;
    private List<Cars> carsList = new CopyOnWriteArrayList<>();


    //take list of all cars
    public List<Cars> getCars(){
        return carsList;
    }

    //take one car from list by car ID
    public Cars getCarsById(int carId){
        return carsList
                .stream()
                .filter(n -> n.getCarId() == carId)
                .findFirst()
                .get();
    }

    //add one car to list - input data - carId and car
        public void addCar(Cars car){
        car.setCarId(carIdCount);
        carsList.add(car);
        carIdCount++;
    }


    // update car data. input data - car and car if

    public void updateCar(int carId, Cars car) {

        carsList
                .stream()
                .forEach(n -> {
                    if (n.getCarId() == carId) {
                        n.setCarId(car.getCarId());
                        n.setCarBrand(car.getCarBrand());
                        n.setCarModel(car.getCarModel());
                        n.setCarYear(car.getCarYear());
                    }
                });
    }

        // delete car from list - input data - car id

        public void deleteCar(int carIdToDelete){
            carsList
                    .stream()
                    .forEach(n -> {
                        if(n.getCarId() == carIdToDelete){
                            carsList.remove(n);
                        }
                    });
        }
    }







