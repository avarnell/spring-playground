package com.example;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String getHelloWorld() {
        return "Hello from Spring!";
    }

    @PatchMapping("/")
    public String patchHelloWorld() {
        return "You have patched!";
    }

    @DeleteMapping("/")
    public String deleteHelloWorld(){
        return "you have deleted!";
    }

}
