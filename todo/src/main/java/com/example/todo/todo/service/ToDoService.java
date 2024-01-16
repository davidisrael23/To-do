package com.example.todo.todo.service;

import com.example.todo.todo.domain.ToDo;

import java.util.List;

public interface ToDoService
{
    ToDo saveToDo(ToDo todo);
    List<ToDo> saveToDos(List<ToDo> todos);
    ToDo getToDoById(long id);
    List<ToDo> getAllToDos();
    ToDo updateToDo(ToDo todo);
    void deleteToDo(long id);
    void deleteToDos();
}
