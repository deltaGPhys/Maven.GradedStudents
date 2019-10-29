package io.zipcoder;


import java.util.*;

public class Classroom {

    private Student[] students;

    public Classroom() {
        this.students = new Student[30];
    }

    public Classroom(int numStudents) {
        this.students = new Student[numStudents];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Student[] getStudents() {
        return students;
    }

    public double getAverageExamScore() {
        double summer = 0.0;
        int counter = 0;
        for (Student student : students) {
            for (double score : student.getRawScores()) {
                summer += score;
            }
            counter += student.getNumberOfExamsTaken();
        }
        return summer/counter;
    }

    public void addStudent(Student student) {
        Student[] studentsNew = Arrays.copyOf(this.students, this.students.length + 1);
        studentsNew[this.students.length] = student;
        this.students = studentsNew;
    }

    public void removeStudent(String firstName, String lastName) {
        for (int i = 0; i<this.students.length; i++){
            if (this.students[i].getFirstName() == firstName && this.students[i].getLastName() == lastName) {
                Student temp = this.students[i];
                for (int j = i; j < this.students.length-1; j++) {
                    this.students[j] = this.students[j+1];
                }
                this.students[this.students.length-1] = null;
                break;
            }
        }
    }

    public Student[] getStudentsByScore() {

        Map<Double, Student> sortedStudents = new TreeMap<>();
        for (Student student: this.students) {
            sortedStudents.put(student.getAverageExamScore(), student);
        }
        Student[] result = sortedStudents.values().toArray(new Student[this.students.length]);
        return result;
    }

    public Map<Student,String> getGradeBook() {

        Student[] sortedStudents = getStudentsByScore();
        int len = sortedStudents.length;
        Map<Student,String> result = new HashMap<>();
        String grade = "";
        double perc;

        for (int i = 0; i<len; i++) {
            perc = (double)i/len;
            if (perc > .9) {
                grade = "A";
            } else if (perc > .7) {
                grade = "B";
            } else if (perc > .5) {
                grade = "C";
            } else if (perc > .1) {
                grade = "D";
            } else {
                grade = "F";
            }
            result.put(sortedStudents[i],grade);
        }

        return result;
    }

}
