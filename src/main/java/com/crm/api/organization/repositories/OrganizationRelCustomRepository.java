package com.crm.api.organization.repositories;

import com.crm.api.organization.domains.OrganizationEntity;
import com.crm.api.organization.domains.OrganizationRelEntity;
import com.crm.commun.exceptions.DBException;
import com.crm.commun.results.RequestFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrganizationRelCustomRepository {
    public Page<OrganizationRelEntity> find(RequestFilter filter, Pageable pageable) throws DBException;

    public Optional<OrganizationRelEntity> get(Long id) throws DBException;

    public OrganizationRelEntity save(OrganizationRelEntity entity) throws DBException;

    public void delete(OrganizationRelEntity entity) throws DBException;

    public Page<OrganizationRelEntity> findChildsByParentIdAndRelTypeId(@Param("parentId") Long parentId, @Param("relTypeId") Long[] relTypeId, Pageable pageable);

    List<OrganizationRelEntity> findByChildIdAndParentIdAndRelationTypeIds(Long childId, Long parentId, Long[] relationTypeId) throws DBException;
}
