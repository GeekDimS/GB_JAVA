package org.example.Sem4_OOP.TaskScheduler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class ReadTasksFromFile {
    TaskServiceInterface taskService;

    public ReadTasksFromFile(TaskServiceInterface taskService) {
        this.taskService = taskService;
    }

    public List<Task> readTasksfromFile(String path) {
        try {
            File file = new File(path);
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                List<String> stringParam = Arrays.stream(line.split(",")).toList();
                Task task = new Task(parseStringToPriority(stringParam.get(0)), stringParam.get(1), parseStringToData(stringParam.get(2)));
                taskService.addTask(task);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Priority parseStringToPriority(String priorityString) {
        return Priority.valueOf(priorityString);
    }

    private LocalDate parseStringToData(String dataString) {

        return LocalDate.parse(dataString);
    }
}
