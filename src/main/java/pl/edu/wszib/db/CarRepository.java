package pl.edu.wszib.db;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import pl.edu.wszib.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private static SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public static void persistCar(Car car) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(car);
            //wiecej operacji
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null) tx.rollback();
        } finally {
            session.close();
        }
    }

    public static Car getCarById(int id) {
        Session session = factory.openSession();

        Car car = (Car) session.createQuery("FROM pl.edu.wszib.model.Car WHERE id = " + id).uniqueResult();

        session.close();
        return car;
    }

    public static List<Car> getAllBMWCars() {
        Session session = factory.openSession();

        List<Car> bmwCars = session.createQuery("FROM pl.edu.wszib.model.Car WHERE brand = 'BMW'").list();

        return bmwCars;
    }
}
