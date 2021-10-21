package com.example.movie.controller;

import com.example.movie.dto.CreateFolksdevDto;
import com.example.movie.dto.CreateFolksdevRequest;
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
    public ResponseEntity<CreateFolksdevDto> createFolksdev(@RequestBody CreateFolksdevRequest createFolksdevRequest) {
        int birthYear = 2021 - createFolksdevRequest.getAge();
        CreateFolksdevDto createFolksdevDto = new CreateFolksdevDto(createFolksdevRequest.getName(), birthYear);
        return new ResponseEntity<>(createFolksdevDto, HttpStatus.CREATED);
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
