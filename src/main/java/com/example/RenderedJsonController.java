package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

class Song{
    private String name;
    private Artist[] artists;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Artist[] getArtists() {
        return artists;
    }

    public void setArtists(Artist[] artists) {
        this.artists = artists;
    }

    public Song(String name) {
        this.name = name;
    }

    public void addArtist(int index,Artist artist){
        this.artists[index] = artist;
    }
}

class Artist{
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Artist(String fullName) {
        this.fullName = fullName;
    }
}

@RestController
@RequestMapping("/renderedJson")
public class RenderedJsonController {

    @GetMapping("")
    public Song getSong(){
        Song thePeopleTree = new Song("The People Tree");
        return thePeopleTree;
    }

    @GetMapping("/array")
    public Artist[] getArtists(){
        Artist[] davidByrne = new Artist[]{
                new Artist("David Byrne")
        };
        return davidByrne;
    }
}
