package io.zipcoder;

import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Map;

@RunWith(JUnitParamsRunner.class)
public class ClassroomTest {

    private Classroom classroom1;
    private Student student1;
    private Student student2;
    private Student student3;
    private Student student4;


    @Before
    public void setUp() throws Exception {
        student1 = new Student("Jimmy", "John", new Double[] {45.0, 50.0, 55.0});
        student2 = new Student("Tammy", "Tohn", new Double[] {60.0, 65.0});
        student3 = new Student("Tmy", "Thn", new Double[] {10.0, 65.0});
        student4 = new Student("Tmy", "Thn", new Double[] {100.0, 65.0});
    }

    @Test
    public void getStudentsTest() {
        Classroom classroom = new Classroom();
        Student[] students = classroom.getStudents();

        int expected = 30;
        int actual = students.length;

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getStudentsTest2() {
        Classroom classroom = new Classroom(15);
        Student[] students = classroom.getStudents();

        int expected = 15;
        int actual = students.length;

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getStudentsTest3() {
        Classroom classroom = new Classroom(new Student[] {student1,student2});
        Student[] students = classroom.getStudents();

        int expected = 2;
        int actual = students.length;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAverageExamScoreTest() {
        Classroom classroom = new Classroom(new Student[] {student1,student2});
        Student[] students = classroom.getStudents();

        double expected = 55.0;
        double actual = classroom.getAverageExamScore();

        Assert.assertEquals(expected, actual, .01);
    }
    @Test
    public void getAverageExamScoreTest2() {
        Classroom classroom = new Classroom(new Student[] {student1});
        Student[] students = classroom.getStudents();

        double expected = 50.0;
        double actual = classroom.getAverageExamScore();

        Assert.assertEquals(expected, actual, .01);
    }

    @Test
    public void addStudentTest() {
        Classroom classroom = new Classroom();
        classroom.addStudent(student1);
        classroom.addStudent(student2);

        int expected = 32;
        int actual = classroom.getStudents().length;

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void addStudentTest2() {
        Classroom classroom = new Classroom(5);
        classroom.addStudent(student1);
        classroom.addStudent(student2);

        int expected = 5;
        int actual = classroom.getStudents().length;

        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void removeStudentTest() {
        Classroom classroom = new Classroom(new Student[] {student1});
        classroom.removeStudent(student1.getFirstName(), student1.getLastName());

        int expected = 1;
        int actual = classroom.getStudents().length;

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void removeStudentTest2() {
        Classroom classroom = new Classroom(new Student[] {student1});
        classroom.removeStudent(student1.getFirstName(), student1.getLastName());

        Student expected = null;
        Student actual = classroom.getStudents()[0];

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void removeStudentTest3() {
        Classroom classroom = new Classroom(new Student[] {student1, student2});
        classroom.removeStudent(student1.getFirstName(), student1.getLastName());

        int expected = 2;
        int actual = classroom.getStudents().length;

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void removeStudentTest4() {
        Classroom classroom = new Classroom(new Student[] {student1, student2});
        classroom.removeStudent(student1.getFirstName(), student1.getLastName());

        Student expected = null;
        Student actual = classroom.getStudents()[1];

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void removeStudentTest5() {
        Classroom classroom = new Classroom(new Student[] {student1, student2});
        classroom.removeStudent(student1.getFirstName(), student1.getLastName());

        Student expected = student2;
        Student actual = classroom.getStudents()[0];

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getStudentsByScoreTest() {
        Classroom classroom = new Classroom(new Student[] {student1, student2});

        Student[] expected = new Student[] {student1,student2};
        Student[] actual = classroom.getStudentsByScore();

        Assert.assertArrayEquals(expected, actual);
    }
    @Test
    public void getStudentsByScoreTest2() {
        Classroom classroom = new Classroom(new Student[] {student1, student2, student4, student3});

        Student[] expected = new Student[] {student3,student1,student2,student4};
        Student[] actual = classroom.getStudentsByScore();

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void getGradebookTest() {
        int n = 20;
        Student[] students = new Student[n];
        for (int i = 1; i<=n; i++) {
            students[i-1] = new Student("","",new Double[] {100.0,5.0*i});
        }

        Classroom classroom = new Classroom(students);
        Map<Student,String> result = classroom.getGradeBook();

        Assert.assertEquals(result.get(students[0]),"F");
        Assert.assertEquals(result.get(students[19]),"A");
        Assert.assertEquals(result.get(students[15]),"B");
        Assert.assertEquals(result.get(students[7]),"D");
        Assert.assertNotEquals(result.get(students[2]),"A");

    }

}
