package com.studentmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {

    // ADD STUDENT
    public void addStudent(Student student) {

        String sql = "INSERT INTO students " +
                     "(name, email, phone, course, mark1, mark2, mark3, percentage, grade) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getPhone());
            ps.setString(4, student.getCourse());
            ps.setInt(5, student.getMark1());
            ps.setInt(6, student.getMark2());
            ps.setInt(7, student.getMark3());
            ps.setDouble(8, student.getPercentage());
            ps.setString(9, student.getGrade());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student added successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Error adding student.");
            e.printStackTrace();
        }
    }

    // DISPLAY ALL STUDENTS
    public void displayStudents() {

        String sql = "SELECT * FROM students";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println();
            System.out.println("--------------------------------------------------------------------------------");
            System.out.printf("%-5s %-15s %-12s %-12s %-10s %-10s%n",
                    "ID", "NAME", "COURSE", "PERCENTAGE", "GRADE", "PHONE");
            System.out.println("--------------------------------------------------------------------------------");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.printf("%-5d %-15s %-12s %-12.2f %-10s %-10s%n",
                        rs.getInt("student_id"),
                        rs.getString("name"),
                        rs.getString("course"),
                        rs.getDouble("percentage"),
                        rs.getString("grade"),
                        rs.getString("phone"));
            }

            if (!found) {
                System.out.println("No students found.");
            }

            System.out.println("--------------------------------------------------------------------------------");

        } catch (SQLException e) {
            System.out.println("Error displaying students.");
            e.printStackTrace();
        }
    }
    // SEARCH STUDENT
    public void searchStudent(int studentId) {

        String sql = "SELECT * FROM students WHERE student_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("--------------------------------");
                System.out.println("Student ID : " + rs.getInt("student_id"));
                System.out.println("Name       : " + rs.getString("name"));
                System.out.println("Email      : " + rs.getString("email"));
                System.out.println("Phone      : " + rs.getString("phone"));
                System.out.println("Course     : " + rs.getString("course"));
                System.out.println("Percentage : " + rs.getDouble("percentage"));
                System.out.println("Grade      : " + rs.getString("grade"));

            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error searching student.");
            e.printStackTrace();
        }
    }
    public void searchStudentByName(String name) {

        String sql = "SELECT * FROM students WHERE name LIKE ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + name + "%");

            ResultSet rs = ps.executeQuery();

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println("--------------------------------");
                System.out.println("Student ID : " + rs.getInt("student_id"));
                System.out.println("Name       : " + rs.getString("name"));
                System.out.println("Email      : " + rs.getString("email"));
                System.out.println("Phone      : " + rs.getString("phone"));
                System.out.println("Course     : " + rs.getString("course"));
                System.out.printf("Percentage : %.2f%n",
                        rs.getDouble("percentage"));
                System.out.println("Grade      : " + rs.getString("grade"));
            }

            if (!found) {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error searching student by name.");
            e.printStackTrace();
        }
    } 

    // DELETE STUDENT
    public void deleteStudent(int studentId) {

        String sql = "DELETE FROM students WHERE student_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting student.");
            e.printStackTrace();
        }
    }

    // UPDATE STUDENT
    public void updateStudent(Student student) {

        String sql = "UPDATE students SET name=?, email=?, phone=?, course=?, " +
                     "mark1=?, mark2=?, mark3=?, percentage=?, grade=? " +
                     "WHERE student_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getPhone());
            ps.setString(4, student.getCourse());
            ps.setInt(5, student.getMark1());
            ps.setInt(6, student.getMark2());
            ps.setInt(7, student.getMark3());
            ps.setDouble(8, student.getPercentage());
            ps.setString(9, student.getGrade());
            ps.setInt(10, student.getStudentId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error updating student.");
            e.printStackTrace();
        }
    }
    public void showTopStudent() {

        String sql = "SELECT * FROM students " +
                     "ORDER BY percentage DESC LIMIT 1";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {

                System.out.println();
                System.out.println("----- TOP STUDENT -----");

                System.out.println("Student ID : " + rs.getInt("student_id"));
                System.out.println("Name       : " + rs.getString("name"));
                System.out.println("Course     : " + rs.getString("course"));

                System.out.printf("Percentage : %.2f%n",
                        rs.getDouble("percentage"));

                System.out.println("Grade      : " + rs.getString("grade"));

            } else {
                System.out.println("No students found.");
            }

        } catch (SQLException e) {
            System.out.println("Error finding top student.");
            e.printStackTrace();
        }
    }
    public void showAveragePercentage() {

        String sql = "SELECT AVG(percentage) AS average_percentage FROM students";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {

                double average = rs.getDouble("average_percentage");

                System.out.println();
                System.out.println("----- AVERAGE PERCENTAGE -----");
                System.out.printf("Average Percentage: %.2f%n", average);

            }

        } catch (SQLException e) {
            System.out.println("Error calculating average percentage.");
            e.printStackTrace();
        }
    }
    public void showGradeSummary() {

        String sql = "SELECT grade, COUNT(*) AS total_students " +
                     "FROM students " +
                     "GROUP BY grade " +
                     "ORDER BY grade";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println();
            System.out.println("----- GRADE SUMMARY -----");

            System.out.println("-------------------------");
            System.out.printf("%-10s %-15s%n", "GRADE", "STUDENTS");
            System.out.println("-------------------------");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.printf("%-10s %-15d%n",
                        rs.getString("grade"),
                        rs.getInt("total_students"));
            }

            if (!found) {
                System.out.println("No students found.");
            }

            System.out.println("-------------------------");

        } catch (SQLException e) {
            System.out.println("Error displaying grade summary.");
            e.printStackTrace();
        }
    }
}