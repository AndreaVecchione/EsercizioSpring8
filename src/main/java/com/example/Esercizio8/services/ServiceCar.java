package com.example.Esercizio8.services;

import com.example.Esercizio8.entities.Car;
import com.example.Esercizio8.repositories.RepositoryCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class ServiceCar {
    @Autowired
    private static RepositoryCar repositoryCar;

    public static Car insertCar(Car newCar) {
        return repositoryCar.saveAndFlush(newCar);
    }
    public static List<Car> selectAllCars() {
        return repositoryCar.findAll();
    }
    public static Car selectCarById() {
        boolean checkCar = repositoryCar.existsById(selectCarById().getId());
        if (checkCar) {
            return repositoryCar.findById(selectCarById().getId()).get();

        } else{
            return new Car();
        }
    }
    public Car updateCar (Car car, Long id) {
        boolean checkCar = repositoryCar.existsById(id);
if (checkCar) {
    Car existingCar = repositoryCar.findById(id).get();
    existingCar.setModelName(car.getModelName());
    existingCar.setType(car.getType());
    return repositoryCar.save(existingCar);
} else {
    return new Car();
}

    }
        public Car updateType (String car, Long id) {
        boolean checkCar = repositoryCar.existsById(id);
        if (checkCar) {
            Car existingCar = repositoryCar.findById(id).get();
            existingCar.setType(existingCar.getType());
            return repositoryCar.save(existingCar);
        } else {
            return new Car();
        }
    }

            public boolean deleteAllCars() {
                repositoryCar.deleteAll();

                return false;
            }

}
