package com.crm.api.organization.repositories;

import com.crm.api.organization.domains.OrganizationPersonEntity;
import com.crm.api.organization.domains.PersonEntity;
import com.crm.commun.exceptions.DBException;
import com.crm.commun.results.RequestFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrganizationPersonCustomRepository {
    public Page<OrganizationPersonEntity> find(RequestFilter filter, Pageable pageable) throws DBException;

    public Optional<OrganizationPersonEntity> get(Long id) throws DBException;

    public OrganizationPersonEntity save(OrganizationPersonEntity entity) throws DBException;

    public void delete(OrganizationPersonEntity entity) throws DBException;

    public Page<OrganizationPersonEntity> findPersonsByOrganizationIdAndTypeRelId(@Param("organizationId") Long organizationId, @Param("relTypeId") Long[] relTypeId, Pageable pageable);

    List<OrganizationPersonEntity> findByPersonIdAndOrganizationIdAndRelationTypeIds(Long personId, Long organizationId, Long[] relationTypeId);
}
