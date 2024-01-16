package com.example.todo.todo.controller.api;

import com.example.todo.todo.domain.ToDo;
import com.example.todo.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoAPIController
{
    @Autowired
    ToDoService toDoService;

    @GetMapping("/getToDo")
    public ResponseEntity<List<ToDo>> getAllToDos()
    {
        return ResponseEntity.ok().body(toDoService.getAllToDos());
    }

    @GetMapping("/getToDo/{id}")
    public ResponseEntity<ToDo> getToDoById(@PathVariable long id)
    {
        return ResponseEntity.ok().body(toDoService.getToDoById(id));
    }

    @PostMapping("/addToDo")
    public ResponseEntity<ToDo> createToDo(@RequestBody ToDo todo)
    {
        return ResponseEntity.ok().body(toDoService.saveToDo(todo));
    }

    @PostMapping("/addToDos")
    public List<ToDo> addToDos(@RequestBody List<ToDo> todos)
    {
        return toDoService.saveToDos(todos);
    }

    @PutMapping("/updateToDo/{id}")
    public ResponseEntity<ToDo> updateToDo(@PathVariable long id, @RequestBody ToDo todo)
    {
        return ResponseEntity.ok().body(toDoService.updateToDo(todo));
    }

    @DeleteMapping("/deleteToDo/{id}")
    public HttpStatus deleteToDo(@PathVariable long id)
    {
        toDoService.deleteToDo(id);
        return HttpStatus.OK;
    }

    @DeleteMapping("/deleteToDos")
    public String deleteToDos()
    {
        toDoService.deleteToDos();
        return "All ToDos Deleted";
    }

}
