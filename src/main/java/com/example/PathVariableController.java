package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/pathVariable")
public class PathVariableController {

    @GetMapping("/individual/fruit/{fruit}/type/{type}")
    public String getIndividualParams(@PathVariable String fruit, @PathVariable String type){
        return String.format("You have selected a %s %s.",type, fruit);
    }

    @GetMapping("/hashMap/fruit/{fruit}/type/{type}")
    public String getHashMap(@PathVariable Map pathVariables){
        return pathVariables.toString();
    }

    @GetMapping("/custom/fruit/{fruit}/type/{type}")
    public String getCustom(Fruit fruit){
        return String.format("You have selected a %s %s.", fruit.getType(), fruit.getFruit());
    }

}
