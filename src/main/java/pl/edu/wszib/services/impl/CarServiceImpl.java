package pl.edu.wszib.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wszib.dao.ICarDAO;
import pl.edu.wszib.dao.ICarHistoryDAO;
import pl.edu.wszib.dao.impl.CarHistoryDAOImpl;
import pl.edu.wszib.dao.impl.CarDAOImpl;
import pl.edu.wszib.model.Car;
import pl.edu.wszib.model.CarHistory;
import pl.edu.wszib.services.ICarService;

import java.util.Date;

@Component
public class CarServiceImpl implements ICarService {

    @Autowired
    ICarDAO carDAO;
    @Autowired
    ICarHistoryDAO carHistoryDAO;

    public void saveCar(Car car) {
        carDAO.persistCar(car);
        CarHistory carHistory = new CarHistory();
        carHistory.setDate(new Date());
        carHistory.setNewCarId(car.getId());

        carHistoryDAO.persistCarHistory(carHistory);
    }
}
