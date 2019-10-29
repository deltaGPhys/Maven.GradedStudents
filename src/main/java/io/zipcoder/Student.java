package io.zipcoder;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Student{

    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student (String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<Double>(Arrays.asList(testScores));
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumberOfExamsTaken() {
        return this.examScores.size();
    }

    public ArrayList<Double> getRawScores() {
        return this.examScores;
    }

    public String getExamScores() {
        String output = "Exam Scores:\n";

        for (int i = 0; i < this.examScores.size(); i++) {
            output += String.format("     Exam %d -> %d\n", i+1, (int)Math.rint(this.examScores.get(i)));
        }

        return output;
    }

    public void addExamScore(double examScore) {
        this.examScores.add(examScore);
    }

    public void setExamScore(int examNum, double score) {
        this.examScores.set(examNum-1,score);
    }

    public double getAverageExamScore() {
        double sum = 0.0;
        for (double score : this.examScores) {
            sum += score;
        }
        return sum/this.examScores.size();
    }

    public String toString() {
        return String.format("Student Name: %s %s\n> Average Score: %d\n> ",this.firstName, this.lastName, (int)Math.rint(this.getAverageExamScore())) + this.getExamScores();
    }

}
