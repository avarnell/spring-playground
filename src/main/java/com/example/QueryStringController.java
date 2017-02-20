package com.example;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/queryStrings")
public class QueryStringController {

    @GetMapping("/individual/vegetable")
    public String getIndividualString(
            @RequestParam String name,
            @RequestParam String color) {

        return String.format("Vegetable name is : %s and color is : %s", name, color);
    }

    @GetMapping("/hashMap/vegetable")
    public String getHashMap(@RequestParam Map queryString){
        return queryString.toString();
    }

    @GetMapping("/custom/vegetable")
    public String getCustom(vegetable vegetable){
        return String.format("Vegetable name is : %s and color is : %s", vegetable.getName(), vegetable.getColor());
    }


}
