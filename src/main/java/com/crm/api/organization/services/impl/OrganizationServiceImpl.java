package com.crm.api.organization.services.impl;

import com.crm.api.organization.domains.OrganizationEntity;
import com.crm.api.organization.forms.Organization;
import com.crm.api.organization.forms.OrganizationFilter;
import com.crm.api.organization.repositories.OrganizationCustomRepository;
import com.crm.api.organization.repositories.OrganizationRepositoryImpl;
import com.crm.api.organization.services.OrganizationService;
import com.crm.commun.domains.searchSpec.SearchCriteria;
import com.crm.commun.exceptions.ServiceException;
import com.crm.commun.results.RequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationCustomRepository organizationCustomRepository;

    @Override
    public Page<OrganizationEntity> find(RequestFilter filter) throws ServiceException {
        return organizationCustomRepository.find(filter, PageRequest.of(filter.getPage(), filter.getSize()));
    }

    @Override
    public Organization get(Long id) throws ServiceException {
        return null;
    }

    @Override
    public Organization create(Organization form) throws ServiceException {
        return null;
    }

    @Override
    public Organization update(Organization form) throws ServiceException {
        return null;
    }

    @Override
    public void delete(Long id) throws ServiceException {

    }
}
