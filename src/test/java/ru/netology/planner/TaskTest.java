package ru.netology.planner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void shouldFindSimpleTaskByQueryTrueCase() {
        SimpleTask simpleTask = new SimpleTask(10, "Написать код");

        boolean actual = simpleTask.matches("код");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindSimpleTaskByQueryFalseCase() {
        SimpleTask simpleTask = new SimpleTask(10, "Написать код");

        boolean actual = simpleTask.matches("чушь");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindEpicByQueryTrueCase() {
        String[] subtasks = {"Калина", "Малина", "Ванила"};
        Epic epic = new Epic(115, subtasks);

        boolean actual = epic.matches("Малина");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindEpicByQueryFalseCase() {
        String[] subtasks = {"Калина", "Малина", "Ванила"};
        Epic epic = new Epic(115, subtasks);

        boolean actual = epic.matches("Горилла");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMeetingByQueryTrueTopicCase() {
        Meeting meeting = new Meeting(
                150,
                "Ужин",
                "Бал",
                "Среда, 19-00"
        );

        boolean actual = meeting.matches("Ужин");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMeetingByQueryTrueProjectCase() {
        Meeting meeting = new Meeting(
                150,
                "Ужин",
                "Бал",
                "Среда, 19-00"
        );

        boolean actual = meeting.matches("Бал");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMeetingByQueryFalseCase() {
        Meeting meeting = new Meeting(
                150,
                "Ужин",
                "Бал",
                "Среда, 19-00"
        );

        boolean actual = meeting.matches("Вечеринка");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }
}