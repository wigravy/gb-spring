package com.wigravy.spring.database.DAO;


import com.wigravy.spring.database.HibernateSessionManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class DaoService<T> {
    SessionFactory sessionFactory = HibernateSessionManager.getInstance();
    Session session = null;
    private Class<T> clazz;


    public DaoService(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T findOneById(Long id) {
        T temp = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            temp = session.get(clazz, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return temp;
    }

    public List<T> findAll() {
        List<T> temp = null;
        try {
            session = sessionFactory.getCurrentSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<T> query = builder.createQuery(clazz);
            query.from(clazz);
            temp = session.createQuery(query).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return temp;
    }

    public T save(T t) {
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.save(t);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return t;
    }

    public void deleteById(Long id) {
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.delete(session.get(clazz, id));
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(T t) {
        try {
            session = sessionFactory.getCurrentSession();
            session.delete(t);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public T update(T t) {
        try {
            session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(t);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return t;
    }

    public void closeSessionFactory() {
        sessionFactory.close();
    }
}
