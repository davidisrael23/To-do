package com.example.todo.todo.service;
import com.example.todo.todo.domain.ToDo;
import com.example.todo.todo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoServiceImpl implements ToDoService
{
    @Autowired
    ToDoRepository toDoRepository;

    @Override
    public ToDo saveToDo(ToDo todo)
    {
        return toDoRepository.save(todo);
    }

    @Override
    public List<ToDo> saveToDos(List<ToDo> todos)
    {
        return toDoRepository.saveAll(todos);
    }

    @Override
    public ToDo getToDoById(long id)
    {
        Optional<ToDo> toDo = toDoRepository.findById(id);

        ToDo emptyToDo;
        if(toDo.isPresent())
        {
            emptyToDo = toDo.get();
            return emptyToDo;
        }
        else
        {
            throw new RuntimeException("ToDo Not Found");
        }
    }

    @Override
    public List<ToDo> getAllToDos()
    {
        return toDoRepository.findAll();
    }

    @Override
    public ToDo updateToDo(ToDo todo)
    {
        Optional<ToDo> optionalToDo = toDoRepository.findById(todo.getId());
        if (optionalToDo.isPresent())
        {
            ToDo updateToDo = optionalToDo.get();
            updateToDo.setTask(todo.getTask());
            updateToDo.setDueDate(todo.getDueDate());

            toDoRepository.save(updateToDo);
            return updateToDo;
        }
        else
        {
            throw new RuntimeException("todo does not exist");
        }
    }

    @Override
    public void deleteToDo(long id)
    {
        toDoRepository.deleteById(id);
    }

    @Override
    public void deleteToDos()
    {
        toDoRepository.deleteAll();
    }
}

