package PBLJ.Experiments;

import java.util.*;
import static java.util.stream.Collectors.*;
                                                    /*EASY LEVEL*/
class CompanyEmployee {
    String name;
    int age;
    double salary;

    public CompanyEmployee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String toString() {
        return name + " - " + age + " - " + salary;
    }
}

class SortEmployees {
    public static void main(String[] args) {
        List<CompanyEmployee> employees = new ArrayList<>();
        employees.add(new CompanyEmployee("John", 30, 50000));
        employees.add(new CompanyEmployee("Alice", 25, 60000));
        employees.add(new CompanyEmployee("Bob", 28, 75000));

        employees.sort((e1, e2) -> Double.compare(e1.salary, e2.salary));

        System.out.println("Sorted by Salary:");
        employees.forEach(System.out::println);
    }
}

                                                /*MEDIUM LEVEL*/
class SchoolStudent {
    String name;
    int id;
    double marks;

    public SchoolStudent(String name, int id, double marks) {
        this.name = name;
        this.id = id;
        this.marks = marks;
    }
}

class FilterStudents {
    public static void main(String[] args) {
        List<SchoolStudent> students = Arrays.asList(
                new SchoolStudent("Ravi", 1, 80),
                new SchoolStudent("Aditi", 2, 90),
                new SchoolStudent("Kiran", 3, 78),
                new SchoolStudent("Neha", 4, 65)
        );

        System.out.println("Students scoring above 75%:");
        students.stream()
                .filter(s -> s.marks > 75)
                .sorted((s1, s2) -> Double.compare(s1.marks, s2.marks))
                .map(s -> s.name)
                .forEach(System.out::println);
    }
}

                                                /*HARD LEVEL*/

class Products {
    int id;
    String name;
    double price;
    String category;

    public Products(int id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String toString() {
        return name + " (₹" + price + ")";
    }
}

class ProductStreamOperations {
    public static void main(String[] args) {
        List<Products> products = Arrays.asList(
                new Products(1, "Laptop", 80000, "Electronics"),
                new Products(2, "Phone", 20000, "Electronics"),
                new Products(3, "Office Chair", 12000, "Furniture"),
                new Products(4, "Table", 5000, "Furniture")
        );

        Map<String, Optional<Products>> maxByCategory = products.stream()
                .collect(groupingBy(p -> p.category, maxBy(Comparator.comparing(p -> p.price))));

        System.out.println("Most Expensive Product by Category:");
        maxByCategory.forEach((cat, prod) ->
                System.out.println(cat + " → Most Expensive: " + prod.get())
        );

        double avgPrice = products.stream()
                .collect(averagingDouble(p -> p.price));

        System.out.println("\nAverage Price of All Products: ₹" + avgPrice);
    }
}
