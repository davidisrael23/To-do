package com.example.todo.todo.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "todo")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String task;
    private LocalDateTime dueDate;

    public Long getId()
    {
        return id;
    }

    public String getTask()
    {
        return task;
    }

    public void setTask(String task)
    {
        this.task = task;
    }

    public LocalDateTime getDueDate()
    {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate)
    {
        this.dueDate = dueDate;
    }

    public ToDo()
    {

    }

    public ToDo(Long id,String task, LocalDateTime dueDate)
    {
        this.id = id;
        this.task = task;
        this.dueDate = dueDate;
    }


}

