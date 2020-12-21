package com.crm.api.organization.services.impl;

import com.crm.api.organization.forms.Organization;
import com.crm.api.organization.forms.OrganizationFilter;
import com.crm.api.organization.services.OrganizationService;
import com.crm.commun.exceptions.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Override
    public Page find(OrganizationFilter filter) throws ServiceException {
        return null;
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
