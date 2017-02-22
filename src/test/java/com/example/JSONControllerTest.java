package com.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(JSONController.class)

public class JSONControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testString() throws Exception{
        MockHttpServletRequestBuilder jsonRequest = post("/jsonData/movieData")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"The Revenant\"," +
                        "\"actors\": [{\"name\": \"Leo\", \"oscarWins\": \"1\"}]}");

        this.mvc.perform(jsonRequest)
                .andExpect(status().isOk())
                .andExpect(content().string("Leo has 1 Oscar Win(s)"));

    }

    @Test
    public void testGSON() throws Exception{

        JsonObject movie = new JsonObject();
        movie.addProperty("title", "The Revenant");
        movie.addProperty("oscarWins", "3");
        Gson builder = new GsonBuilder().create();

        String parsedGson = builder.toJson(movie);


        MockHttpServletRequestBuilder request = post("/jsonData/movieDataReduced")
                .contentType(MediaType.APPLICATION_JSON)
                .content(parsedGson);
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("The Revenant has won 3 oscars!"));
    }


    @Test
    public void textFixture() throws Exception{
        String json = getJSON("/data.json");

        MockHttpServletRequestBuilder request = post("/jsonData/movieData")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Leo has 1 Oscar Win(s)"));

    }

    private String getJSON(String path) throws Exception{
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }

}
