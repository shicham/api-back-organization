package com.crm.api.organization.repositories;

import com.crm.api.organization.domains.PersonEntity;
import com.crm.commun.domains.searchSpec.GenericSpesification;
import com.crm.commun.exceptions.DBException;
import com.crm.commun.results.RequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class PersonCustomRepositoryImpl implements PersonCustomRepository {

    @PersistenceContext
    EntityManager em;

    @Autowired
    PersonRepository personRepository;

    public Page<PersonEntity> find(RequestFilter filter, Pageable pageable) throws DBException {
        GenericSpesification genericSpesification = new GenericSpesification<PersonEntity>();
        genericSpesification.add(filter.getCriteria());
        return personRepository.findAll(genericSpesification, pageable);
    }

    @Override
    public Optional<PersonEntity> get(Long id) throws DBException {
        return personRepository.findById(id);
    }

    @Override
    public PersonEntity save(PersonEntity entity) throws DBException{
        return personRepository.save(entity);
    }

    @Override
    public void delete(PersonEntity entity) throws DBException{
        personRepository.delete(entity);
    }
}
