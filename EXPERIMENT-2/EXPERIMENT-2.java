                               /*EASY LEVEL*/
class Product {
 int id;
 String name;
 double price;


 public Product(int id, String name, double price) {
  this.id = id;
  this.name = name;
  this.price = price;
 }


 public void displayDetails() {
  System.out.println("Product Details:");
  System.out.println("ID: " + id);
  System.out.println("Name: " + name);
  System.out.println("Price: " + price);
 }
}

class ProductDemo {
 public static void main(String[] args) {
  // Sample input (hardcoded)
  Product p1 = new Product(101, "Laptop", 75000);

  // Display product details
  p1.displayDetails();
 }
}

                             /*MEDIUM LEVEL*/

class Book {
 String title;
 String author;
 double price;

 public Book(String title, String author, double price) {
  this.title = title;
  this.author = author;
  this.price = price;
 }

 public void displayDetails() {
  System.out.println("Book Details:");
  System.out.println("Title: " + title);
  System.out.println("Author: " + author);
  System.out.println("Price: " + price);
 }
}

class Fiction extends Book {
 public Fiction(String title, String author, double price) {
  super(title, author, price);
 }

 @Override
 public void displayDetails() {
  System.out.println("Fiction Book Details:");
  System.out.println("Title: " + title);
  System.out.println("Author: " + author);
  System.out.println("Price: " + price);
 }
}

class NonFiction extends Book {
 public NonFiction(String title, String author, double price) {
  super(title, author, price);
 }

 @Override
 public void displayDetails() {
  System.out.println("Non-Fiction Book Details:");
  System.out.println("Title: " + title);
  System.out.println("Author: " + author);
  System.out.println("Price: " + price);
 }
}

class LibraryManagement {
 public static void main(String[] args) {
  // Sample input
  Book b1 = new Fiction("Harry Potter", "J.K. Rowling", 500);
  Book b2 = new NonFiction("Sapiens", "Yuval Noah Harari", 700);
  b1.displayDetails();
  System.out.println();
  b2.displayDetails();
 }
}

                               /*HARD LEVEL*/

abstract class Person {
 String name;
 int age;

 public Person(String name, int age) {
  this.name = name;
  this.age = age;
 }

 public abstract void displayDetails();
}

class Student extends Person {
 int rollNumber;

 public Student(String name, int age, int rollNumber) {
  super(name, age);
  this.rollNumber = rollNumber;
 }

 @Override
 public void displayDetails() {
  System.out.println("Student Details:");
  System.out.println("Name: " + name);
  System.out.println("Age: " + age);
  System.out.println("Roll Number: " + rollNumber);
 }
}

class Teacher extends Person {
 String subject;

 public Teacher(String name, int age, String subject) {
  super(name, age);
  this.subject = subject;
 }

 @Override
 public void displayDetails() {
  System.out.println("Teacher Details:");
  System.out.println("Name: " + name);
  System.out.println("Age: " + age);
  System.out.println("Subject: " + subject);
 }
}

class StudentInformationSystem {
 public static void main(String[] args) {

  Student s1 = new Student("Alice", 20, 101);
  Teacher t1 = new Teacher("Mr. Smith", 40, "Mathematics");

  Person p1 = s1;
  Person p2 = t1;

  p1.displayDetails();
  System.out.println();
  p2.displayDetails();
 }
}