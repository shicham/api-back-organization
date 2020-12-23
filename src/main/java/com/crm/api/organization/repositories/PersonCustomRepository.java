package com.crm.api.organization.repositories;

import com.crm.api.organization.domains.PersonEntity;
import com.crm.commun.exceptions.DBException;
import com.crm.commun.results.RequestFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PersonCustomRepository {
    public Page<PersonEntity> find(RequestFilter filter, Pageable pageable) throws DBException;
    public Optional<PersonEntity> get(Long id) throws DBException;
    PersonEntity save(PersonEntity entity) throws DBException;
    public void delete(PersonEntity entity) throws DBException;
}
