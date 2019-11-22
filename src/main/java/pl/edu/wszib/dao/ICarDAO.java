package pl.edu.wszib.dao;

import pl.edu.wszib.model.Car;

public interface ICarDAO {
    void persistCar(Car car);
    Car getCarById(int id);
    void updateCar(Car car);
}
