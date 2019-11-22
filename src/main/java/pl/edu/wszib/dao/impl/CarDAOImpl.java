package pl.edu.wszib.dao.impl;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import pl.edu.wszib.dao.ICarDAO;
import pl.edu.wszib.model.Car;

@Component
public class CarDAOImpl implements ICarDAO {
    private static SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void persistCar(Car car) {
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

    public Car getCarById(int id) {
        Session session = factory.openSession();

        Car car = (Car) session.createQuery("FROM pl.edu.wszib.model.Car WHERE id = " + id).uniqueResult();

        session.close();
        return car;
    }

    @Override
    public void updateCar(Car car) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(car);
            //wiecej operacji
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null) tx.rollback();
        } finally {
            session.close();
        }
    }
}
