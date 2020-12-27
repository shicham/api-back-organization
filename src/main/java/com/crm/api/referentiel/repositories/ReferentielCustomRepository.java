package com.crm.api.referentiel.repositories;

import com.crm.api.referentiel.domains.ReferentielEntity;
import com.crm.commun.exceptions.DBException;
import com.crm.commun.results.RequestFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ReferentielCustomRepository {
    public Page<ReferentielEntity> find(RequestFilter filter, Pageable pageable) throws DBException;

    public Optional<ReferentielEntity> get(Long id) throws DBException;

    ReferentielEntity save(ReferentielEntity entity) throws DBException;

    public void delete(ReferentielEntity entity) throws DBException;
}
