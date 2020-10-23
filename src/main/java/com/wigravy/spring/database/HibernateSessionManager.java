package com.wigravy.spring.database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionManager {
    private static final SessionFactory instance = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

    private HibernateSessionManager() {
    }

    public static SessionFactory getInstance() {
      return instance;
    }

    public static void closeSessionFactory() {
        instance.close();
    }
}
