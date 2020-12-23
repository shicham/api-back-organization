package com.crm.api.organization.repositories;

import com.crm.api.organization.domains.OrganizationEntity;
import com.crm.commun.domains.searchSpec.SearchCriteria;
import com.crm.commun.exceptions.DBException;
import com.crm.commun.results.RequestFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface OrganizationCustomRepository {
    public Page<OrganizationEntity> find(RequestFilter filter, Pageable pageable) throws DBException;
    public Optional<OrganizationEntity> get(Long id) throws DBException;
    OrganizationEntity save(OrganizationEntity entity) throws DBException;
    public void delete(OrganizationEntity entity) throws DBException;
}
