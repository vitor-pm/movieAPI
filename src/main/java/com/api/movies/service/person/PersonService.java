package com.api.movies.service.person;

import com.api.movies.models.person.Person;
import com.api.movies.models.person.PersonDTO;
import com.api.movies.service.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService extends AbstractService<Person, PersonDTO, Long> implements IPersonService {
    @Override
    public Person convertToEntity(PersonDTO dto) {
        return modelMapper.map(dto, Person.class);
    }

    @Override
    public PersonDTO convertToModel(Person entity) {
        return modelMapper.map(entity, PersonDTO.class);
    }

    @Override
    public List<PersonDTO> listAllPerson() {
        return listAll();
    }

    @Override
    public PersonDTO insertNewPerson(PersonDTO person) {
        System.out.println(person);
        return insert(person);
    }

    @Override
    public PersonDTO updatePerson(PersonDTO person) {
        return update(person);
    }

    @Override
    public void deletePerson(Long id) {
        deleteById(id);
    }
}
