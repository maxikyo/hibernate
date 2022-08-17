package com.example.sql.hibernate_one_to_many_uni;



import com.example.sql.hibernate_one_to_many_uni.Entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class test1 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {
//            session = factory.getCurrentSession();
//            Department dep = new Department("HR", 1500,
//                    500);
//            Employee emp1 = new Employee("Oleg", "Ivanov",
//                    800);
//            Employee emp2 = new Employee("Andrey", "Sidorov",
//                    1000);
//
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//
//            session.beginTransaction();
//            session.save(dep);
//
//            session.getTransaction().commit();
//
//            System.out.println("done!");
//***********************************************************************
            session = factory.getCurrentSession();


            session.beginTransaction();
            Department department = session.get(Department.class, 2);
            System.out.println(department);
            System.out.println(department.getEmps());

            session.getTransaction().commit();

            System.out.println("done!");
//***********************************************************************
//            session = factory.getCurrentSession();
//
//
//            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 1);
//            System.out.println(employee);
//            System.out.println(employee.getDepartment());
//
//            session.getTransaction().commit();
//
//            System.out.println("done!");
//***************************************************************
//            session = factory.getCurrentSession();
//
//
//            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 4);
//
//            session.delete(employee);
//            session.getTransaction().commit();
//
//            System.out.println("done!");

        }
        finally {
            session.close();
            factory.close();
        }
    }
}
