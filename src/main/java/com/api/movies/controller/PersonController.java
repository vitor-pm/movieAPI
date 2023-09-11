package com.api.movies.controller;

import com.api.movies.models.person.PersonDTO;
import com.api.movies.service.person.IPersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private IPersonService service;
    @GetMapping
    public List<PersonDTO> listAllPerson(){
        return service.listAllPerson();
    }

    @PostMapping
    public PersonDTO insertNewPerson(@RequestBody @Valid PersonDTO person){
        return service.insertNewPerson(person);
    }

    @PutMapping
    public PersonDTO updatePerson(@RequestBody @Valid PersonDTO person){
        return service.updatePerson(person);
    }

    @DeleteMapping("/{id}")
    public void deletePersonById(@PathVariable("id") Long id){
        service.deletePerson(id);
    }
}
