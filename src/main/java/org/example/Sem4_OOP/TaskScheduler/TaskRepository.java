package org.example.Sem4_OOP.TaskScheduler;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TaskRepository {
    Deque<Task> taskDeque;

    public TaskRepository() {
        taskDeque = new ArrayDeque<>();
    }

    public void addTask(Task task) {
        taskDeque.addLast(task);
    }

    public void removeTask(Task task) {
        taskDeque.remove(task);
    }

    public Task getTaskOfId(int id) {
        for (Task task : taskDeque) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public Deque<Task> getTaskDeque() {
        return taskDeque;
    }

    public List<Task> getOnePriorityTasks(Priority priority) {
        List<Task> resultTaskList = new ArrayList<>();
        for (Task task : taskDeque) {
            if (task.getPriority() == priority) {
                resultTaskList.add(task);
            }
        }
        return resultTaskList;
    }
}
