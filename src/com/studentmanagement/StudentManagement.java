package com.studentmanagement;

import java.util.Scanner;

public class StudentManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentDAO dao = new StudentDAO();

        while (true) {

            System.out.println();
            System.out.println("================================");
            System.out.println("    STUDENT MANAGEMENT SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student by ID");
            System.out.println("5. Search Student by Name");
            System.out.println("6. Display All Students");
            System.out.println("7. Show Top Student");
            System.out.println("8. Show Average Percentage");
            System.out.println("9. Show Grade Summary");
            System.out.println("10. Exit");
            System.out.println("================================");
            System.out.print("Enter your choice: ");

            int choice;

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Invalid input! Please enter a number.");
                sc.next();
                continue;
            }

            switch (choice) {
                case 1:
                    addStudent(sc, dao);
                    break;

                case 2:
                    updateStudent(sc, dao);
                    break;

                case 3:
                    deleteStudent(sc, dao);
                    break;

                case 4:
                    searchStudent(sc, dao);
                    break;

                case 5:
                    searchStudentByName(sc, dao);
                    break;

                case 6:
                    dao.displayStudents();
                    break;
                case 7:
                    dao.showTopStudent();
                    break;
                    
                case 8:
                    dao.showAveragePercentage();
                    break;
                    
                case 9:
                    dao.showGradeSummary();
                    break;
                    
                case 10:
                    System.out.println("Thank you for using Student Management System.");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // ADD STUDENT
    public static void addStudent(Scanner sc, StudentDAO dao) {

        System.out.println();
        System.out.println("----- ADD STUDENT -----");

        String name = readName(sc);

        String email = readEmail(sc);

        String phone = readPhone(sc);

        System.out.print("Enter course: ");
        String course = sc.nextLine();


        int mark1 = readMark(sc, "Enter mark 1: ");
        int mark2 = readMark(sc, "Enter mark 2: ");
        int mark3 = readMark(sc, "Enter mark 3: ");

        sc.nextLine();

        Student student = new Student(
                name,
                email,
                phone,
                course,
                mark1,
                mark2,
                mark3
        );

        System.out.printf("New Percentage: %.2f%n", student.getPercentage());
        System.out.println("Grade: " + student.getGrade());

        dao.addStudent(student);
    }

    // UPDATE STUDENT
    public static void updateStudent(Scanner sc, StudentDAO dao) {

        System.out.println();
        System.out.println("----- UPDATE STUDENT -----");

        System.out.print("Enter student ID: ");
        int studentId = sc.nextInt();
        sc.nextLine();

        String name = readName(sc);

        String email = readEmail(sc);

        String phone = readPhone(sc);

        System.out.print("Enter new course: ");
        String course = sc.nextLine();
        
        int mark1 = readMark(sc, "Enter mark 1: ");
        int mark2 = readMark(sc, "Enter mark 2: ");
        int mark3 = readMark(sc, "Enter mark 3: ");

        sc.nextLine();
        

        Student student = new Student(
                name,
                email,
                phone,
                course,
                mark1,
                mark2,
                mark3
        );

        student.setStudentId(studentId);

        System.out.printf("New Percentage: %.2f%n", student.getPercentage());
        System.out.println("New Grade: " + student.getGrade());

        dao.updateStudent(student);
    }

    // DELETE STUDENT
    public static void deleteStudent(Scanner sc, StudentDAO dao) {

        System.out.println();
        System.out.println("----- DELETE STUDENT -----");

        System.out.print("Enter student ID: ");
        int studentId = sc.nextInt();
        sc.nextLine();

        System.out.print("Are you sure you want to delete? (yes/no): ");
        String confirmation = sc.nextLine();

        if (confirmation.equalsIgnoreCase("yes")) {
            dao.deleteStudent(studentId);
        } else {
            System.out.println("Delete operation cancelled.");
        }
    }

    // SEARCH STUDENT
    public static void searchStudent(Scanner sc, StudentDAO dao) {

        System.out.println();
        System.out.println("----- SEARCH STUDENT -----");

        System.out.print("Enter student ID: ");
        int studentId = sc.nextInt();
        sc.nextLine();

        dao.searchStudent(studentId);
    }
    public static void searchStudentByName(Scanner sc, StudentDAO dao) {

        System.out.println();
        System.out.println("----- SEARCH STUDENT BY NAME -----");

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        dao.searchStudentByName(name);
    }
    public static int readMark(Scanner sc, String message) {

        while (true) {

            System.out.print(message);

            if (sc.hasNextInt()) {

                int mark = sc.nextInt();

                if (mark >= 0 && mark <= 100) {
                    return mark;
                }

                System.out.println("Invalid mark! Enter a value between 0 and 100.");

            } else {

                System.out.println("Invalid input! Please enter a number.");
                sc.next();
            }
        }
    }
    public static String readPhone(Scanner sc) {

        while (true) {

            System.out.print("Enter phone: ");
            String phone = sc.nextLine();

            if (phone.matches("[0-9]{10}")) {
                return phone;
            }

            System.out.println("Invalid phone number! Enter exactly 10 digits.");
        }
    }
    public static String readEmail(Scanner sc) {

        while (true) {

            System.out.print("Enter email: ");
            String email = sc.nextLine();

            if (email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                return email;
            }

            System.out.println("Invalid email! Please enter a valid email address.");
        }
    }
    public static String readName(Scanner sc) {

        while (true) {

            System.out.print("Enter name: ");
            String name = sc.nextLine().trim();

            if (!name.isEmpty()) {
                return name;
            }

            System.out.println("Name cannot be empty!");
        }
    }
}