package org.example.Sem4_OOP;

import org.example.Sem4_OOP.TaskScheduler.TaskService;
import org.example.Sem4_OOP.TaskScheduler.TaskServiceInterface;

public class Main {
    public static void main(String[] args) {

        TaskServiceInterface taskService = new TaskService();
        taskService.readFromCSVFile("C:\\Users\\zus\\IdeaProjects\\Task3\\src\\main\\java\\org\\example" +
                "\\Sem4_OOP\\TaskScheduler\\Tasks.csv");

        System.out.println(taskService.getAllTasks());
        taskService.writeInCSVFile("C:\\Users\\zus\\IdeaProjects\\Task3\\src\\main\\java\\org\\example" +
                "\\Sem4_OOP\\TaskScheduler\\Tasks_out.csv");
//        Task task1 =new Task(Priority.HIGH, "Petr", LocalDateTime.now().plusDays(3));
//        Task task2 =new Task(Priority.URGENT, "Petr", LocalDateTime.now().plusDays(2));
//        Task task3 =new Task(Priority.HIGH, "Vera", LocalDateTime.now().plusDays(1));
//
//        TaskServiceInterface taskService = new TaskService();
//        taskService.addTask(task1);
//        taskService.addTask(task2);
//        taskService.addTask(task3);
//
//        System.out.println(taskService.getAllTasks());
//
//        System.out.println(taskService.getTaskOfId(2));
//        System.out.println();
//
//        System.out.println(taskService.getTaskOfId(10));
//        System.out.println();
//
//        System.out.println(taskService.getOnePriorityTasks(Priority.HIGH));
//        System.out.println();

//        taskService.deleteTask(task1);
//        System.out.println(taskService.getAllTasks());

    }
}
