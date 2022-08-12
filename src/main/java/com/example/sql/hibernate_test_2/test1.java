package com.example.sql.hibernate_test_2;



import com.example.sql.hibernate_test_2.entity.Employee;
import com.example.sql.hibernate_test_2.entity.Detail;
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

        try {
//            Session session = factory.getCurrentSession();
//            Employee employee = new Employee("Max", "Holovanov", "IT"
//                    ,800);
//            Detail detail = new Detail("Prague", "601530777"
//                    ,"holovanovmax@gmail.com");
//
//            employee.setEmpDetail(detail);
//            session.beginTransaction();
//
//            session.save(employee);
//
//            session.getTransaction().commit();
//
//            System.out.println("done!");

            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Oleg", "Smirnov", "Sales"
                    ,800);
            Detail detail = new Detail("Moscow", "771530777"
                    ,"olejka@gmail.com");

            employee.setEmpDetail(detail);
            session.beginTransaction();

            session.save(employee);

            session.getTransaction().commit();

            System.out.println("done!");

        }
        finally {
            factory.close();
        }
    }
}
