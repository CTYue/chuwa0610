package com.chuwa.exercise.JavaNewFeature;

import java.time.LocalDate;
import java.util.Optional;

public class Task {
    private String title;
    private String description;
    private String status;
    private Optional<LocalDate> dueDate;
    // usage of optional function: think of if we are fetch some data from our database: such as Cat cat = new cat (name: "Fred", age: 3)
    // but if we try to fetch the data that is not null in the database, probly we will get an error, (null pointer exception), the way we could solve it is to create a if statement to check the null situation,
    // so optional is a way that we could skip the kind of code
    // optionals are a better way to handle a situation where a method like this might not have a value to return
    // when should I need using optional: optionals were only intended to be used as a return type
    // https://www.youtube.com/watch?v=vKVzRbsMnTQ&ab_channel=CodingwithJohn

    //constructor
    public Task(String title, String description, String status, Optional<LocalDate> dueDate) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Optional<LocalDate> getDueDate() {
        return dueDate;
    }

    public void setDueDate(Optional<LocalDate> dueDate) {
        this.dueDate = dueDate;
    }




}

