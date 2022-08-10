package com.example.sql.hibernate_test;


import com.example.sql.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class test2 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            Employee emp = new Employee("Nik", "Josh"
                    , "IT", 500);
            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();

            System.out.println("done!");
            System.out.println(emp);
        }
        finally {
            factory.close();
        }
    }
}
