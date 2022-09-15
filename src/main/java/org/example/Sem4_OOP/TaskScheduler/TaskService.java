package org.example.Sem4_OOP.TaskScheduler;

import org.example.Sem4_OOP.ImpotrExport.IoCSVFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static org.example.Sem4_OOP.ImpotrExport.IoCSVFile.writeFieldsToFile;

public class TaskService implements TaskServiceInterface {
    private TaskRepository taskRepository;

    public TaskService() {
        this.taskRepository = new TaskRepository();
    }

    @Override
    public void addTask(Task task) {
        taskRepository.addTask(task);
    }

    @Override
    public void deleteTask(Task task) {
        taskRepository.removeTask(task);
    }

    @Override
    public Task getTaskOfId(int id) {
        return taskRepository.getTaskOfId(id);
    }

    @Override
    public List<Task> getOnePriorityTasks(Priority priority) {
        return taskRepository.getOnePriorityTasks(priority);
    }

    @Override
    public Deque<Task> getAllTasks() {
        return taskRepository.getTaskDeque();
    }

    @Override
    public void readFromCSVFile(String path) {
        List<String[]> records = IoCSVFile.getListFields(path);
        for (String[] record : records) {
            Task task = new Task((Priority.valueOf(record[0])), record[1], LocalDate.parse(record[2]));
            taskRepository.addTask(task);
        }

    }

    @Override
    public void writeInCSVFile(String path) {
        ArrayList<Task> arr;
        writeFieldsToFile(path, taskRepository.getTaskDeque().toArray(new Task[0]));
    }

}
