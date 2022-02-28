package com.example.restfulwebservices.helloworld;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HelloWorldController {

    @GetMapping(path="/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("hello world bean");
    }
    
    @GetMapping(path="/hello-world/{name}")
    public HelloWorldBean HellowWorldName(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello world, %s", name));
    }


}
