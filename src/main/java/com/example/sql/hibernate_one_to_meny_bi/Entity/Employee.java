package com.example.sql.hibernate_one_to_meny_bi.Entity;


import com.example.sql.hibernate_one_to_one.entity.Detail;

import javax.persistence.*;

@Entity
@Table(name = "employees")

public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //стратегия генерации значений(может быть auto)
    @Column(name="id")
    private int id;

    @Column(name = "name")
    private String firstname;

    @Column(name = "surname")
    private String surname;

    @Column(name = "department")
    private String department;

    @Column(name = "salary")
    private int salary;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id") //связь с другой таблицей
    private Detail empDetail;


    public Employee() {
    }

    public Employee(String name, String surname, String department, int salary) {
        this.firstname = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String name) {
        this.firstname = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Detail getEmpDetail() {
        return empDetail;
    }

    public void setEmpDetail(Detail empDetail) {
        this.empDetail = empDetail;
    }
}
