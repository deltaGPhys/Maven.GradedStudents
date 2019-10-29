package io.zipcoder;

import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class StudentTest {

    private Student student1;

    @Before
    public void setUp() throws Exception {
        student1 = new Student("Jimmy", "John", new Double[] {45.0, 15.8, 92.4});

    }

    @Test
    public void getFirstNameTest() {
        String expected = "Jimmy";
        String actual = student1.getFirstName();

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void getFirstNameTest2() {
        String expected = "Joey";
        String actual = student1.getFirstName();

        Assert.assertNotEquals(expected,actual);
    }

    @Test
    public void setFirstNameTest() {
        String expected = "Bingo";
        student1.setFirstName("Bingo");
        String actual = student1.getFirstName();

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void setFirstNameTest2() {
        String expected = "Jimmy";
        student1.setFirstName("Bingo");
        String actual = student1.getFirstName();

        Assert.assertNotEquals(expected,actual);
    }

    @Test
    public void getLastNameTest() {
        String expected = "John";
        String actual = student1.getLastName();

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void getLastNameTest2() {
        String expected = "Joey";
        String actual = student1.getLastName();

        Assert.assertNotEquals(expected,actual);
    }

    @Test
    public void setLastNameTest() {
        String expected = "Bingo";
        student1.setLastName("Bingo");
        String actual = student1.getLastName();

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void setLastNameTest2() {
        String expected = "John";
        student1.setLastName("Bingo");
        String actual = student1.getLastName();

        Assert.assertNotEquals(expected,actual);
    }

    @Test
    public void getScoresTest() {
        String expected = "Exam Scores:\n     Exam 1 -> 45\n     Exam 2 -> 16\n     Exam 3 -> 92\n";
        String actual = student1.getExamScores();

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void getScoresTest2() {
        String expected = "Joey";
        String actual = student1.getExamScores();

        Assert.assertNotEquals(expected,actual);
    }
    @Test
    public void getScoresTest3() {
        String expected = "Exam Scores:\n     Exam 1 -> 45\n     Exam 2 -> 16\n     Exam 3 -> 92\n     Exam 4 -> 100\n";
        student1.addExamScore(100.0);
        String actual = student1.getExamScores();

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void getScoresTest4() {
        String expected = "Exam Scores:\n     Exam 1 -> 45\n     Exam 2 -> 16\n     Exam 3 -> 92\n";
        student1.addExamScore(100.0);
        String actual = student1.getExamScores();

        Assert.assertNotEquals(expected,actual);
    }

    @Test
    public void setExamScoreTest() {
        String expected = "Exam Scores:\n     Exam 1 -> 45\n     Exam 2 -> 17\n     Exam 3 -> 92\n";
        student1.setExamScore(2,17.0);
        String actual = student1.getExamScores();

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void setExamScoreTest2() {
        String expected = "Exam Scores:\n     Exam 1 -> 45\n     Exam 2 -> 16\n     Exam 3 -> 92\n";
        student1.setExamScore(3,100.0);
        String actual = student1.getExamScores();

        Assert.assertNotEquals(expected,actual);
    }


    @Test
    public void getNumberOfExamsTest() {
        int expected = 3;
        int actual = student1.getNumberOfExamsTaken();

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void getNumberOfExamsTest2() {
        int expected = 4;
        student1.addExamScore(100.0);
        int actual = student1.getNumberOfExamsTaken();

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void getNumberOfExamsTest3() {
        int expected = 3;
        student1.addExamScore(100.0);
        int actual = student1.getNumberOfExamsTaken();

        Assert.assertNotEquals(expected,actual);
    }

    @Test
    public void getAverageTest() {
        double expected = (45.0+15.8+92.4)/3.0;
        double actual = student1.getAverageExamScore();

        Assert.assertEquals(expected,actual,.01);
    }
    @Test
    public void getAverageTest2() {
        student1.addExamScore(100.0);
        double expected = (45.0+15.8+92.4+100.0)/4.0;
        double actual = student1.getAverageExamScore();

        Assert.assertEquals(expected,actual,.01);
    }

    @Test
    public void toStringTest() {
        String expected = "Student Name: Jimmy John\n> Average Score: 51\n> Exam Scores:\n     Exam 1 -> 45\n     Exam 2 -> 16\n     Exam 3 -> 92\n";;
        String actual = student1.toString();

        Assert.assertEquals(expected,actual);
    }

}