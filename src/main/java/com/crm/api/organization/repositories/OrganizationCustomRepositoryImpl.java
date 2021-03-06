package com.crm.api.organization.repositories;

import com.crm.api.organization.domains.OrganizationEntity;
import com.crm.api.organization.domains.OrganizationPersonEntity;
import com.crm.api.organization.domains.OrganizationRelEntity;
import com.crm.api.organization.forms.OrganizationPerson;
import com.crm.api.organization.forms.OrganizationPersonFilter;
import com.crm.api.organization.forms.OrganizationRel;
import com.crm.api.organization.forms.OrganizationRelFilter;
import com.crm.commun.domains.searchSpec.GenericSpesification;
import com.crm.commun.exceptions.DBException;
import com.crm.commun.results.PaginResponse;
import com.crm.commun.results.RequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import com.crm.commun.domains.searchSpec.Ord;

@Repository
public class OrganizationCustomRepositoryImpl implements OrganizationCustomRepository {

    @PersistenceContext
    EntityManager em;

    @Autowired
    OrganizationRepository organizationRepository;
    @Autowired
    OrganizationRelRepository organizationRelRepository;
    @Autowired
    OrganizationPersonRepository organizationPersonRepository;

    public Page<OrganizationEntity> find(RequestFilter filter, Pageable pageable) throws DBException {
        GenericSpesification genericSpesification = new GenericSpesification<OrganizationEntity>();
        genericSpesification.add(filter.getCriteria());
        if(filter.getSort() != null){
            System.out.println("999");
            genericSpesification.addOrder(Arrays.asList(filter.getSort()));
        }
        
        return organizationRepository.findAll(genericSpesification, pageable);
    }
    
    
  private Sort.Direction getSortDirection(String direction) {
    if (direction.equals("asc")) {
      return Sort.Direction.ASC;
    } else if (direction.equals("desc")) {
      return Sort.Direction.DESC;
    }

    return Sort.Direction.ASC;
  }
    
    @Override
    public Optional<OrganizationEntity> get(Long id) throws DBException {
        return organizationRepository.findById(id);
    }

    @Override
    public OrganizationEntity save(OrganizationEntity entity) throws DBException {
        return organizationRepository.save(entity);
    }

    @Override
    public void delete(OrganizationEntity entity) throws DBException {
        organizationRepository.delete(entity);
    }

    @Override
    public Page<OrganizationRelEntity> childs(OrganizationRelFilter filter, Pageable pageable) throws DBException {
        return organizationRelRepository.findChildsByParentIdAndRelTypeId(filter.getParentId(),filter.getRelTypeId(), pageable);
    }

    @Override
    public Page<OrganizationPersonEntity> persons(OrganizationPersonFilter filter, Pageable pageable) throws DBException {
        return organizationPersonRepository.findPersonsByOrganizationIdAndTypeRelId(filter.getOrganizationId(), filter.getRelTypeId(),pageable);
    }
}
