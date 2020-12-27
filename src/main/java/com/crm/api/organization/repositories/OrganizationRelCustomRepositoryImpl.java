package com.crm.api.organization.repositories;

import com.crm.api.organization.domains.OrganizationEntity;
import com.crm.api.organization.domains.OrganizationRelEntity;
import com.crm.api.organization.forms.OrganizationRelFilter;
import com.crm.commun.domains.searchSpec.GenericSpesification;
import com.crm.commun.exceptions.DBException;
import com.crm.commun.results.RequestFilter;
import com.crm.commun.tools.StringTools;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
public class OrganizationRelCustomRepositoryImpl implements OrganizationRelCustomRepository {

    @PersistenceContext
    EntityManager em;

    @Autowired
    OrganizationRelRepository organizationRelRepository;

    public Page<OrganizationRelEntity> find(RequestFilter filter, Pageable pageable) throws DBException {
        GenericSpesification genericSpesification = new GenericSpesification<OrganizationRelEntity>();
        genericSpesification.add(filter.getCriteria());
        return organizationRelRepository.findAll(genericSpesification, pageable);
    }

    public Page<OrganizationEntity> find(OrganizationRelFilter filter, Pageable pageable) throws DBException {
        return null;
    }

    @Override
    public Optional<OrganizationRelEntity> get(Long id) throws DBException {
        return organizationRelRepository.findById(id);
    }

    @Override
    public OrganizationRelEntity save(OrganizationRelEntity entity) throws DBException {
        return organizationRelRepository.save(entity);
    }

    @Override
    public void delete(OrganizationRelEntity entity) throws DBException {
        organizationRelRepository.delete(entity);
    }

    @Override
    public Page<OrganizationRelEntity> findChildsByParentIdAndRelTypeId(Long parentId, Long[] relTypeId, Pageable pageable) {
        return organizationRelRepository.findChildsByParentIdAndRelTypeId(parentId, relTypeId, pageable);
    }

    @Override
    public List<OrganizationRelEntity> findByChildIdAndParentIdAndRelationTypeIds(Long childId, Long parentId, Long[] relTypeId) throws DBException {
        Query query = em.createQuery("select r from OrganizationRelEntity r where r.childId = :childId AND r.parentId = :parentId and r.relTypeId in (:relTypeId)  ");
        query.setParameter("childId",childId);
        query.setParameter("parentId",parentId);
        query.setParameter("relTypeId",relTypeId);
        return query.getResultList();
    }
}