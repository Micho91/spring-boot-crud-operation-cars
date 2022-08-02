package com.cars.springbootcrudoperationcars.API;

import com.cars.springbootcrudoperationcars.Service.CarsService;
import com.cars.springbootcrudoperationcars.model.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarAPI {

    @Autowired
    private CarsService carsService;


    @GetMapping(value = "/{carId}")
    public Cars getCar(@PathVariable ("carId") int carId){
        return carsService.getCarsById(carId);
    }

    @PostMapping(value = "/addcar")
    public void addCar(@RequestBody Cars car){
        carsService.addCar(car);

    }

    @PutMapping("/updatecar/{carId}")
    public void updateCar(@PathVariable ("carId") int carId, @RequestBody Cars car){
        carsService.updateCar(carId, car);
    }

    @DeleteMapping(value = "/deletecar/{carId}")
    public void deleteCar(@PathVariable ("carId") int carId){
        carsService.deleteCar(carId);
    }











}
