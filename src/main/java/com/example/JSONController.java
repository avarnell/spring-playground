package com.example;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



class Actor {
    private String name;
    private String oscarWins;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOscarWins() {
        return oscarWins;
    }

    public void setOscarWins(String oscarWins) {
        this.oscarWins = oscarWins;
    }

    public String getSummary(){
        return String.format("%s has %s Oscar Win(s)", this.getName(), this.getOscarWins());
    }
}

class Movie {
    private String title;
    private Actor[] actors;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Actor[] getActors() {
        return actors;
    }

    public void setActors(Actor[] actors) {
        this.actors = actors;
    }
}

class ReducedMovie {
    private String title;
    private String oscarWins;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOscarWins() {
        return oscarWins;
    }

    public void setOscarWins(String oscarWins) {
        this.oscarWins = oscarWins;
    }

    public String getSummary(){
        return String.format("%s has won %s oscars!", this.title, this.oscarWins);
    }
}

@RestController
@RequestMapping("/jsonData")
public class JSONController {
    @PostMapping("/movieData")
    public String processJson(@RequestBody Movie movie) {
        return movie.getActors()[0].getSummary();
    }

    @PostMapping("/movieDataReduced")
    public String processJson(@RequestBody ReducedMovie movie){
        return movie.getSummary();
    }
}

