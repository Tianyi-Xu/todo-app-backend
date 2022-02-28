package com.example.restfulwebservices.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardcodedService {

    private static List<Todo> todos = new ArrayList<>();
    private static long idCounter = 0;

    static {
        todos.add(new Todo(++idCounter, "default","Learn to Dance 2", new Date(), false ));
        todos.add(new Todo(++idCounter, "default","Learn about Microservices 2", new Date(), false ));
        todos.add(new Todo(++idCounter, "default","Learn about Angular", new Date(), false ));
    }

    public List<Todo> findAll() {
        return todos;
    }

    public Todo findById(long id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }
    
    public Todo deleteById(long id) {
        Todo todo = findById(id);
        if (todo == null) return null;
        todos.remove(todo);
        return todo;
    }

    public Todo save(Todo todo) {
        // default todo id is 0 id requestbody dont have it passed in
        if (todo.getId() == 0 || todo.getId() == -1) {
            todo.setId(++idCounter);
        } else {
            deleteById(todo.getId());
        }
        todos.add(todo);
        return todo;
    }



}
