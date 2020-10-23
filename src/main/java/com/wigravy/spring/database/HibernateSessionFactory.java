package com.wigravy.spring.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
    private static final SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

    private HibernateSessionFactory() {
    }

    public static Session getSession() {
      return factory.getCurrentSession();
    }
}
