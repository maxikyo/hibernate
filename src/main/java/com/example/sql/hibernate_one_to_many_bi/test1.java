package com.example.sql.hibernate_one_to_many_bi;


import com.example.sql.hibernate_one_to_one.entity.Detail;
import com.example.sql.hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class test1 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();


            session.getTransaction().commit();

            System.out.println("done!");


        }
        finally {
            session.close();
            factory.close();
        }
    }
}
