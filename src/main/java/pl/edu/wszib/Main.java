package pl.edu.wszib;

import pl.edu.wszib.db.CarRepository;
import pl.edu.wszib.model.Car;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Car car = new Car(20, "BMW", "7", 1999);

        //CarRepository.persistCar(car);

        Car car2 = CarRepository.getCarById(1);

        System.out.println(car2);

        List<Car> bmwCars = CarRepository.getAllBMWCars();
        System.out.println("LISTA:");
        for(Car tempCar : bmwCars) {
            System.out.println(tempCar);
        }
    }
}
