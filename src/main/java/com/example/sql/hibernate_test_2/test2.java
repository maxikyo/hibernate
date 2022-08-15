package com.example.sql.hibernate_test_2;


import com.example.sql.hibernate_test_2.entity.Detail;
import com.example.sql.hibernate_test_2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class test2 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;
        try {
//          session = factory.getCurrentSession();
//            Employee employee = new Employee("Nikolay", "Ivanov", "HR"
//                    ,850);
//            Detail detail = new Detail("New-York", "33324243231"
//                    ,"nikolay@gmail.com");
//
//            employee.setEmpDetail(detail);
//            detail.setEmployee(employee);
//            session.beginTransaction();
//
//            session.save(detail);
//
//            session.getTransaction().commit();
//
//            System.out.println("done!");

//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Detail detail = session.get(Detail.class, 4);
//            System.out.println(detail.getEmployee());
//
//            session.getTransaction().commit();
//
//            System.out.println("done!");

            session = factory.getCurrentSession();

            session.beginTransaction();
            Detail detail = session.get(Detail.class, 4);
            session.delete(detail);

            session.getTransaction().commit();

            System.out.println("done!");

        }
        finally {
            session.close();
            factory.close();
        }
    }
}
