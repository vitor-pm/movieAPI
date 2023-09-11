package com.api.movies.service.person;

import com.api.movies.models.person.PersonDTO;

import java.util.List;

public interface IPersonService {
    List<PersonDTO> listAllPerson();

    PersonDTO insertNewPerson(PersonDTO movie);

    PersonDTO updatePerson(PersonDTO movie);

    void deletePerson(Long id);
}
