package com.example.todo.todo.controller;

import com.example.todo.todo.domain.ToDo;
import com.example.todo.todo.repository.ToDoRepository;
import com.example.todo.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ToDoController {

    @Autowired
    private ToDoRepository toDoRepository;

    @Autowired
    private ToDoService toDoService;

    @GetMapping("/todos")
    public String getAllToDos(Model model)
    {
        List<ToDo> todos = toDoRepository.findAll();
        model.addAttribute("todos", todos);
        return "todo list";
    }

    @GetMapping("/addForm")
    public String addToDoForm(Model model)
    {
        ToDo toDo = new ToDo();
        model.addAttribute("todo",toDo);
        return "add todo";
    }

    @PostMapping("/save")
    public String saveToDo(@ModelAttribute("todo") ToDo toDo)
    {
        toDoRepository.save(toDo);
        return "redirect:/todos";
    }

    @GetMapping("/updateForm/{id}")
    public String updateToDoForm(@PathVariable Long id, Model model) {
        Optional<ToDo> optionalToDo = toDoRepository.findById(id);
        if (optionalToDo.isPresent()) {
            model.addAttribute("todo", optionalToDo.get());
            return "update todo";
        } else {
            return "redirect:/todos";
        }
    }

    @PostMapping("/update/{id}")
    public String updateToDo(@PathVariable Long id, @ModelAttribute("todo") ToDo updatedToDo) {
        Optional<ToDo> optionalToDo = toDoRepository.findById(id);
        if (optionalToDo.isPresent()) {
            ToDo existingToDo = optionalToDo.get();
            existingToDo.setTask(updatedToDo.getTask());
            existingToDo.setDueDate(updatedToDo.getDueDate());

            toDoRepository.save(existingToDo);
        }
        return "redirect:/todos";
    }

    @GetMapping("/deleteForm/{id}")
    public String deleteToDoForm(@PathVariable Long id, Model model) {
        Optional<ToDo> optionalToDo = toDoRepository.findById(id);
        if (optionalToDo.isPresent()) {
            model.addAttribute("todo", optionalToDo.get());
            return "delete todo";
        } else {
            return "redirect:/todos";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteToDo(@PathVariable Long id) {
        Optional<ToDo> optionalToDo = toDoRepository.findById(id);
        if (optionalToDo.isPresent()) {
            toDoRepository.deleteById(id);
        }
        return "redirect:/todos";
    }
}

