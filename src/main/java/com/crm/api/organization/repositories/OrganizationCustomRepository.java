package com.crm.api.organization.repositories;

import com.crm.api.organization.domains.OrganizationEntity;
import com.crm.api.organization.domains.OrganizationPersonEntity;
import com.crm.api.organization.domains.OrganizationRelEntity;
import com.crm.api.organization.forms.OrganizationPerson;
import com.crm.api.organization.forms.OrganizationPersonFilter;
import com.crm.api.organization.forms.OrganizationRel;
import com.crm.api.organization.forms.OrganizationRelFilter;
import com.crm.commun.exceptions.DBException;
import com.crm.commun.results.PaginResponse;
import com.crm.commun.results.RequestFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

public interface OrganizationCustomRepository {
    public Page<OrganizationEntity> find(RequestFilter filter, Pageable pageable) throws DBException;

    public Optional<OrganizationEntity> get(Long id) throws DBException;

    public OrganizationEntity save(OrganizationEntity entity) throws DBException;

    public void delete(OrganizationEntity entity) throws DBException;

    public Page<OrganizationRelEntity> childs(OrganizationRelFilter filter, Pageable pageable) throws DBException;

    public Page<OrganizationPersonEntity> persons(OrganizationPersonFilter filter, Pageable pageable) throws DBException;
}
