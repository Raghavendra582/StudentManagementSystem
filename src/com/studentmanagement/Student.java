package com.studentmanagement;

public class Student {

    private int studentId;
    private String name;
    private String email;
    private String phone;
    private String course;
    private int mark1;
    private int mark2;
    private int mark3;
    private double percentage;
    private String grade;

    public Student() {
    }

    public Student(String name, String email, String phone, String course,
                   int mark1, int mark2, int mark3) {

        this.name = name;
        this.email = email;
        this.phone = phone;
        this.course = course;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;

        calculateResult();
    }

    public void calculateResult() {

        percentage = (mark1 + mark2 + mark3) / 3.0;

        if (percentage >= 90) {
            grade = "A";
        } else if (percentage >= 80) {
            grade = "B";
        } else if (percentage >= 70) {
            grade = "C";
        } else if (percentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCourse() {
        return course;
    }

    public int getMark1() {
        return mark1;
    }

    public int getMark2() {
        return mark2;
    }

    public int getMark3() {
        return mark3;
    }

    public double getPercentage() {
        return percentage;
    }

    public String getGrade() {
        return grade;
    }
}