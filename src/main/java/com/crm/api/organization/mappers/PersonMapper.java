package com.crm.api.organization.mappers;

import com.crm.api.organization.domains.PersonEntity;
import com.crm.api.organization.forms.Person;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonMapper {

    @Autowired
    ModelMapper modelMapper;

    public Person toForm(PersonEntity entity) {
        return modelMapper.map(entity, Person.class);
    }
    public List<Person> toForm(List<PersonEntity> list) {
        return list.stream().map(e -> {
            return toForm(e);
        }).collect(Collectors.toList());
    }

    public PersonEntity toDomain(Person form) {
        return modelMapper.map(form, PersonEntity.class);
    }
    public List<PersonEntity> toDomain(List<Person> list) {
        return list.stream().map(e -> {
            return toDomain(e);
        }).collect(Collectors.toList());
    }

    public void toDomain(Person src, PersonEntity dest) {
        modelMapper.map(src, dest);
    }
}
