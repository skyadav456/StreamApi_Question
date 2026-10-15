package employeeBased;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPractice {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(1, "Amit",   28, "Male",   "IT",      75000, 2018, "Lucknow", List.of("Java", "Spring", "SQL")),
                new Employee(2, "Priya",  32, "Female", "HR",      55000, 2015, "Delhi",   List.of("Recruiting", "Excel")),
                new Employee(3, "Rahul",  45, "Male",   "IT",      120000, 2010, "Pune",   List.of("Java", "AWS", "Kafka")),
                new Employee(4, "Sneha",  26, "Female", "IT",      68000, 2021, "Lucknow", List.of("Python", "SQL")),
                new Employee(5, "Vikram", 38, "Male",   "Finance", 95000, 2012, "Mumbai",  List.of("Excel", "SAP")),
                new Employee(6, "Anjali", 30, "Female", "Finance", 72000, 2017, "Delhi",   List.of("SAP", "Tally")),
                new Employee(7, "Karan",  41, "Male",   "Sales",   88000, 2011, "Pune",    List.of("CRM", "Negotiation")),
                new Employee(8, "Neha",   29, "Female", "Sales",   61000, 2019, "Lucknow", List.of("CRM", "Excel")),
                new Employee(9, "Rohan",  35, "Male",   "HR",      58000, 2016, "Mumbai",  List.of("Recruiting", "Payroll")),
                new Employee(10,"Divya",  27, "Female", "IT",      82000, 2020, "Delhi",   List.of("Java", "React", "SQL"))
        );
        // Sort employees by salary in ascending order.

        employees.stream().sorted(
                Comparator.comparing(Employee::getSalary))
                .toList()
                .forEach(System.out::println);
        System.out.println("=============================");

        //Sort employees by salary in descending order.
        List<Employee> reversedSalary= employees.stream()
                .sorted(Comparator.comparing(
                Employee::getSalary
        ).reversed()).toList();
        reversedSalary.forEach(System.out::println);

        System.out.println("=========================");

        //Sort by department, then by salary descending within each department
        employees.stream().sorted(
                Comparator.comparing(Employee::getDepartment)
                        .thenComparing(Employee::getSalary ,
                                Comparator.reverseOrder())
                ).toList()
                .forEach(System.out::println);

        System.out.println("================");

        // Find the top 3 highest-paid employees.
        employees.stream().sorted(
                Comparator.comparing(
                        Employee::getSalary).reversed()
                )
                .limit(3)
                .toList()
                .forEach(System.out::println);
    }
}

