package com.example;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/formData")
public class FormDataController {

    @PostMapping("/string/comments")
    public String postBasicString(@RequestBody String rawBody){
        return rawBody;
    }

    @PostMapping(value = "/hashMap/comments", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String postHashMap(@RequestParam Map<String, String> commentBody){
        return commentBody.toString();
    }

    @PostMapping(value = "/custom/comments", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String postCustom(@RequestParam UserComment comment){
        return comment.toString();
    }
}
