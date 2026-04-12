package org.yhc.programming.java21.streamapi;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamApiPractise {
    public static void main(String[] args) {
        Employee e1 = new Employee("Salman", 1000.0, "Acting");
        Employee e2 = new Employee("Yogesh", 500.0, "IT");
        Employee e3 = new Employee("Shahrukh", 2500.0, "Acting");
        Employee e4 = new Employee("Akshay", 1000.0, "Acting");
        Employee e5 = new Employee("Amir", 2000.0, "Acting");
        Employee e6 = new Employee("Malinga", 900.0, "Sports");
        List<Employee> employees = List.of(e1, e2, e3, e4, e5, e6);

        //TODO - filter-map
        //Given a list of employees, return names of employees earning more than 500 per month in uppercase.
        List<String> employeeNames = employees.stream()
                .filter(employee -> employee.getSalary() > 500)
                .map(emp -> emp.getName().toUpperCase())
                .toList();
        System.out.println("employeeNames :" + employeeNames);

        //TODO - Group by
        //Group employees by department.
        Map<String, List<Employee>> employeesGrpByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("employeesGrpByDept :" + employeesGrpByDept);

        //count employees per department
        Map<String, Long> empDeptCount = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("empDeptCount :" + empDeptCount);



        Order o1 = new Order(List.of("oil", "soap", "toothbrush", "dates", "toothpaste"));
        Order o2 = new Order(List.of("salt", "flour", "jaggery", "tea", "oil"));
        Order o3 = new Order(List.of("cashew", "raisins", "dates", "pistachio"));
        List<Order> orders = List.of(o1, o2, o3);

        //TODO - flatmap and distinct
        //Given list of orders, each order has list of items. Get unique item names.
        List<String> uniqueItems = orders.stream()
                .flatMap(order -> order.getItems().stream())
                .distinct()
                .toList();
        System.out.println("uniqueItems :" + uniqueItems);

        //Complexity - O(n log n)
        List<Integer> nums = List.of(10, 5, 20, 8, 25);
        int maxTwo = nums.stream()
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Max two numbers sum: " + maxTwo);

    }
}

class Order {
    List<String> items;

    public Order(List<String> items) {
        this.items = items;
    }

    public List<String> getItems() {
        return items;
    }
}

class Employee {
    String name;
    double salary;
    String department;

    public Employee(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }
}

