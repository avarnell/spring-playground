package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(PathVariableController.class)

public class PathVariableControllerTest {
    @Autowired MockMvc mvc;
    @Test
    public void testIndividual() throws Exception{
        String name = "Apple";
        String type = "grannySmith";

        RequestBuilder request = MockMvcRequestBuilders.get(String.format("/pathVariable/individual/fruit/%s/type/%s", name, type));

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("You have selected a grannySmith Apple."));

    }

    @Test
    public void testHashMap() throws Exception{
        String name = "Apple";
        String type = "grannySmith";

        RequestBuilder request = MockMvcRequestBuilders.get(String.format("/pathVariable/hashMap/fruit/%s/type/%s", name, type));
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{fruit=Apple, type=grannySmith}"));
    }

    @Test
    public void testCustom() throws Exception{
        String name = "Apple";
        String type = "grannySmith";

        RequestBuilder request = MockMvcRequestBuilders.get(String.format("/pathVariable/custom/fruit/%s/type/%s", name, type));
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("You have selected a grannySmith Apple."));

    }

}
