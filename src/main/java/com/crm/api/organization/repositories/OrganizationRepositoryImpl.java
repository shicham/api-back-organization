package com.crm.api.organization.repositories;

import com.crm.api.organization.domains.OrganizationEntity;
import com.crm.api.organization.forms.OrganizationFilter;
import com.crm.commun.domains.searchSpec.GenericSpesification;
import com.crm.commun.domains.searchSpec.SearchCriteria;
import com.crm.commun.exceptions.DBException;
import com.crm.commun.exceptions.ServiceException;
import com.crm.commun.results.RequestFilter;
import com.crm.commun.tools.StringTools;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrganizationRepositoryImpl implements OrganizationCustomRepository {

    @PersistenceContext
    EntityManager em;

    @Autowired
    OrganizationRepository organizationRepository;

    public Page<OrganizationEntity> find(RequestFilter filter, Pageable pageable) throws DBException {
        GenericSpesification genericSpesification = new GenericSpesification<OrganizationEntity>();
        genericSpesification.add(filter.getCriteria());
        return organizationRepository.findAll(genericSpesification, pageable);
    }
}
