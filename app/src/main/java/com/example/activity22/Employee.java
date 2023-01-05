package com.example.activity22;

public class Employee {
    private String name;
    private String Salary;
    private String Time;

    public Employee(String name, String salary,String Time) {
        this.name = name;
        Salary = salary;
        Time = Time;
    }
    public Employee(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
