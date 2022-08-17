package com.example.sql.hibernate_one_to_many_bi;



import com.example.sql.hibernate_one_to_many_bi.Entity.Department;
import com.example.sql.hibernate_one_to_many_bi.Entity.Employee;
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
//            Department dep = new Department("IT", 4000,
//                    800);
//            Employee emp1 = new Employee("Maxim", "Holovanov",
//                    800);
//            Employee emp2 = new Employee("Elena", "Smirnova",
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

            session = factory.getCurrentSession();


            session.beginTransaction();
            Department department = session.get(Department.class, 1);
            System.out.println(department);
            System.out.println(department.getEmps());

            session.getTransaction().commit();

            System.out.println("done!");


        }
        finally {
            session.close();
            factory.close();
        }
    }
}
