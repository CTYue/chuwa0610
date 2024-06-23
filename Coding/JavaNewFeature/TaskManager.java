package com.chuwa.exercise.JavaNewFeature;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class TaskManager {

    // Method to perform a TaskAction on a Task
    public void performTaskAction(TaskAction action, Task task) {
        action.execute(task);
    }

    public static void main(String[] args) {
        // Create a Task instance
        Task task = new Task("Title", "Description", "Incomplete", Optional.empty());

        // Create an instance of TaskManager
        TaskManager manager = new TaskManager();

        // Lambda expression to mark the task as completed
        TaskAction markAsCompleted = t -> t.setStatus("Completed");

        // Lambda expression to print task details
        TaskAction printDetails = t -> System.out.println(t.getTitle() + ": " + t.getDescription());

        // Perform the 'markAsCompleted' action on the task
        manager.performTaskAction(markAsCompleted, task);

        // Perform the 'printDetails' action on the task
        manager.performTaskAction(printDetails, task);

        // Example of handling Optional due date
        Optional<LocalDate> dueDate = task.getDueDate();

        // ifPresent: Print the due date if it is present
        dueDate.ifPresent(date -> System.out.println("Due date is: " + date));

        // orElse: Provide a default date if due date is not present
        LocalDate dateOrDefault = dueDate.orElse(LocalDate.now());
        System.out.println("Due date or default: " + dateOrDefault);

        // map: Transform the date to a formatted string if it is present
        Optional<String> formattedDate = dueDate.map(date -> date.format(DateTimeFormatter.ISO_LOCAL_DATE));
        formattedDate.ifPresent(dateStr -> System.out.println("Formatted due date: " + dateStr));
    }
}
