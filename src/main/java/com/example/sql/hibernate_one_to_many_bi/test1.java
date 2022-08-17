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
//            Department dep = new Department("Sales", 1500,
//                    800);
//            Employee emp1 = new Employee("Maxim", "Holovanov",
//                    800);
//            Employee emp2 = new Employee("Elena", "Smirnova",
//                    1000);
//            Employee emp3 = new Employee("Anton", "Sidorov",
//                    1200);
//
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            dep.addEmployeeToDepartment(emp3);
//
//            session.beginTransaction();
//            session.save(dep);
//
//            session.getTransaction().commit();
//
//            System.out.println("done!");
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
//****************************************************************
            session = factory.getCurrentSession();

            session.beginTransaction();
            System.out.println("Get department");
            Department department = session.get(Department.class, 4);
            System.out.println("Show department");
            System.out.println(department);

            System.out.println("Loading our emps");
            department.getEmps().get(0);

            session.getTransaction().commit();
            System.out.println("Show emp of the dep");
            System.out.println(department.getEmps());
            System.out.println("done!");
//***********************************************************************
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
