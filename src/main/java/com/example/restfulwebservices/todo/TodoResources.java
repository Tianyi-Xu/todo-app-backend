package com.example.restfulwebservices.todo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController

// allows you to make requests from one website to another website in the browser
@CrossOrigin(origins = "http://localhost:4200")
public class TodoResources {
    // hardcoded to do data
    @Autowired
    private TodoHardcodedService todoService;

    @GetMapping("users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        return todoService.findAll();
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id) {
        return todoService.findById(id);
    }


    @DeleteMapping("users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username,
                                           @PathVariable long id) {
        Todo todo = todoService.deleteById(id);
        if (todo != null) {
            return ResponseEntity.noContent().build(); // status of no content if success
        }
        return ResponseEntity.notFound().build();
    }


    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> uodateTodo(@PathVariable String username,
                                           @PathVariable long id,
                                           @RequestBody Todo todo) {

        Todo todoUpdate = todoService.save(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/todos/")
    public ResponseEntity<Void> createTodo(@PathVariable String username,
                                           @RequestBody Todo todo) {

        Todo createdTodo = todoService.save(todo);
        // get current uri, pass in the id
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdTodo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }






}
