package com.example;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/album")
public class AlbumController {

    private final AlbumRepository repository;

    public AlbumController(AlbumRepository repository){
        this.repository = repository;
    }

    @PostMapping("")
    public Album create(@RequestBody Album album){
        this.repository.save(album);
        return album;
    }

    @GetMapping("")
    public Iterable<Album> getAll(){
        return this.repository.findAll();
    }

}
