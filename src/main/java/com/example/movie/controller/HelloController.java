package com.example.movie.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(value = "v1/hello")
public class HelloController {


    @GetMapping() // @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> getFolksdev() {
        return ResponseEntity.ok("Hello Folksdev");
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<String> getFolksdevWithId(@PathVariable String id) {
        return ResponseEntity.ok("Hello folksdev with ıd");
    }

    @PostMapping
    public ResponseEntity<String> createFolksdev(@RequestBody String id) {
        return new ResponseEntity<>(id + " : is created" , HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> updateFolksdev(@PathVariable String id, @RequestBody String a) {
        return  ResponseEntity.ok(id + " : is updated" + a);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteFolksdev(@RequestBody String id) {
        return  ResponseEntity.ok(id + " : is deleted");
    }









}
