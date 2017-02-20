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
@WebMvcTest(QueryStringController.class)

public class QueryStringControllerTest {
    @Autowired MockMvc mvc;

    @Test
    public void testIndividual() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/queryStrings/individual/vegetable?name=peas&color=green");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Vegetable name is : peas and color is : green"));
    }

    @Test
    public void testHashMap() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/queryStrings/hashMap/vegetable?name=peas&color=green");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{name=peas, color=green}"));
    }

    @Test
    public void testCustom() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/queryStrings/custom/vegetable?name=peas&color=green");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Vegetable name is : peas and color is : green"));
    }

}
