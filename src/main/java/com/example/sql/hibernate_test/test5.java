package com.example.sql.hibernate_test;


import com.example.sql.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class test5 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
//            Employee emp = session.get(Employee.class, 1);
//            emp.setSalary(10000);
            session.createQuery("update Employee set salary = 1000 " +
                    "where firstname = 'Nik'").executeUpdate();

            session.getTransaction().commit();

            System.out.println("done!");
        }
        finally {
            factory.close();
        }
    }
}
