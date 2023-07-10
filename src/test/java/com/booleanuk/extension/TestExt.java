package com.booleanuk.extension;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestExt {

    private TaskManager taskManager = new TaskManager();

    @BeforeEach
    public void setup() {

        taskManager = new TaskManager();

        Task task = new Task(1, "Task 1", false, new Date());
        taskManager.addTask(task);

        Task task2 = new Task(2, "Task 2", false, new Date());
        taskManager.addTask(task2);

        Task task3 = new Task(3, "Task 3", false, new Date());
        taskManager.addTask(task3);
    }

    @Test
    public void testCheckIfExistsByID() {

        Assertions.assertNotNull(taskManager.getTaskByID(1));
    }

    @Test
    public void testIfNameUpdated() {

        Task task = new Task(1, "Task 1", false, new Date());

        taskManager.addTask(task);
        taskManager.updateTaskName(1, "Task 2");

        Assertions.assertEquals("Task 2", taskManager.getTaskByID(1).getTaskName());
    }

    @Test
    public void testIfIDNotFound() {

        Assertions.assertNull(taskManager.getTaskByID(5));
    }

    @Test
    public void testIfNameNotUpdated() {

        taskManager.updateTaskName(1, "Task 24");

        Assertions.assertNotEquals("Task 1", taskManager.getTaskByID(1).getTaskName());
    }

}