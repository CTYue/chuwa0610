package com.chuwa.exercise.JavaNewFeature;

public interface TaskOperations {
    void createTask(Task task);
    void updateTask(Task task);
    void deleteTask(Task task);
    void viewTask(Task task);

    // Default method for creating a task
    default void defaultCreateTask(Task task) {
        System.out.println("Default create task: " + task.getTitle());
    }

    // Default method for deleting a task
    default void defaultDeleteTask(Task task) {
        System.out.println("Default delete task: " + task.getTitle());
    }

}
