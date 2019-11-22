package pl.edu.wszib.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import pl.edu.wszib.dao.ICarHistoryDAO;
import pl.edu.wszib.model.CarHistory;

@Component
public class CarHistoryDAOImpl implements ICarHistoryDAO {
    private static SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void persistCarHistory(CarHistory carHistory) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(carHistory);
            //wiecej operacji
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null) tx.rollback();
        } finally {
            session.close();
        }
    }

    public CarHistory getCarHistoryByCarId(int id) {
        Session session = factory.openSession();
        CarHistory carHistory = (CarHistory) session
                .createQuery("FROM pl.edu.wszib.model.CarHistory WHERE newCarId = " + id).uniqueResult();

        session.close();
        return carHistory;
    }
}
