package pl.edu.wszib.dao;

import pl.edu.wszib.model.CarHistory;

public interface ICarHistoryDAO {
    void persistCarHistory(CarHistory carHistory);
    CarHistory getCarHistoryByCarId(int id);
}
