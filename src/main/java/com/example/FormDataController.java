package com.example;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/formData")
public class FormDataController {

    @PostMapping("/string/comments")
    public String postBasicString(@RequestBody String rawBody){
        return rawBody;
    }

    @PostMapping(value = "/hashMap/comments", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String postHashMap(@RequestBody Map<String, String> commentBody){
        return commentBody.toString();
    }

    @PostMapping(value = "/custom/comments", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String postCustom(@RequestBody UserComment comment){
        return String.format("%s said %s", comment.getUserName(), comment.getComment());
    }
}
