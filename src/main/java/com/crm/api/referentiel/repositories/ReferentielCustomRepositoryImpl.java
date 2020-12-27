package com.crm.api.referentiel.repositories;

import com.crm.api.referentiel.domains.ReferentielEntity;
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
public class ReferentielCustomRepositoryImpl implements ReferentielCustomRepository {

    @PersistenceContext
    EntityManager em;

    @Autowired
    ReferentielRepository personRepository;

    public Page<ReferentielEntity> find(RequestFilter filter, Pageable pageable) throws DBException {
        GenericSpesification genericSpesification = new GenericSpesification<ReferentielEntity>();
        genericSpesification.add(filter.getCriteria());
        return personRepository.findAll(genericSpesification, pageable);
    }

    @Override
    public Optional<ReferentielEntity> get(Long id) throws DBException {
        return personRepository.findById(id);
    }

    @Override
    public ReferentielEntity save(ReferentielEntity entity) throws DBException {
        return personRepository.save(entity);
    }

    @Override
    public void delete(ReferentielEntity entity) throws DBException {
        personRepository.delete(entity);
    }
}
