package com.wigravy.spring.database.DAO;


import com.wigravy.spring.database.HibernateSessionFactory;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class DaoService<T> {
    Session session = null;
    private Class<T> clazz;


    public DaoService(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T findOneById(Long id) {
        T temp = null;
        try {
            session = HibernateSessionFactory.getSession();
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
            session = HibernateSessionFactory.getSession();
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
            session = HibernateSessionFactory.getSession();
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
            session = HibernateSessionFactory.getSession();
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
            session = HibernateSessionFactory.getSession();
            session.beginTransaction();
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
}
