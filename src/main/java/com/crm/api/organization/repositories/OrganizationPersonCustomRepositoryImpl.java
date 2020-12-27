package com.crm.api.organization.repositories;

import com.crm.api.organization.domains.OrganizationPersonEntity;
import com.crm.api.organization.domains.OrganizationRelEntity;
import com.crm.api.organization.domains.PersonEntity;
import com.crm.commun.domains.searchSpec.GenericSpesification;
import com.crm.commun.exceptions.DBException;
import com.crm.commun.results.RequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
public class OrganizationPersonCustomRepositoryImpl implements OrganizationPersonCustomRepository {

    @PersistenceContext
    EntityManager em;

    @Autowired
    OrganizationPersonRepository organizationPersonRepository;

    public Page<OrganizationPersonEntity> find(RequestFilter filter, Pageable pageable) throws DBException {
        GenericSpesification genericSpesification = new GenericSpesification<OrganizationPersonEntity>();
        genericSpesification.add(filter.getCriteria());
        return organizationPersonRepository.findAll(genericSpesification, pageable);
    }

    @Override
    public Optional<OrganizationPersonEntity> get(Long id) throws DBException {
        return organizationPersonRepository.findById(id);
    }

    @Override
    public OrganizationPersonEntity save(OrganizationPersonEntity entity) throws DBException {
        return organizationPersonRepository.save(entity);
    }

    @Override
    public void delete(OrganizationPersonEntity entity) throws DBException {
        organizationPersonRepository.delete(entity);
    }

    @Override
    public Page<OrganizationPersonEntity> findPersonsByOrganizationIdAndTypeRelId(@Param("organizationId") Long organizationId, @Param("relTypeId") Long[] relTypeId, Pageable pageable) {
        return organizationPersonRepository.findPersonsByOrganizationIdAndTypeRelId(organizationId, relTypeId, pageable);
    }

    @Override
    public List<OrganizationPersonEntity> findByPersonIdAndOrganizationIdAndRelationTypeIds(Long personId, Long organizationId, Long[] relTypeId) {
            Query query = em.createQuery("select r from OrganizationPersonEntity r where r.personId = :personId AND r.organizationId = :organizationId and r.relTypeId in (:relTypeId)  ");
            query.setParameter("personId",personId);
            query.setParameter("personId",personId);
            query.setParameter("relTypeId",relTypeId);
            return query.getResultList();
    }
}