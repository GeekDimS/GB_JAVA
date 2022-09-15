package org.example.Sem4_OOP.TaskScheduler;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task {
    private static int idCount = 0;

    private int id;
    //private String description;
    private Priority priority;
    private String ownerName;

    public String getDateDeadline() {
        return dateDeadline.toString();
    }

    private LocalDate dateDeadline;
    private LocalDateTime dateAdded;


    public String getOwnerName() {
        return ownerName;
    }

    public Task(Priority priority, String ownerName, LocalDate dateDeadline) {
        idCount++;
        this.id = idCount;
        this.priority = priority;
        this.ownerName = ownerName;
        this.dateDeadline = dateDeadline;
        this.dateAdded = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public Priority getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "\nid: " + id + "\npriority " + priority + "\nowner " + ownerName + "\ndeadline " + dateDeadline + "\ndate added " + dateAdded;
    }
}
