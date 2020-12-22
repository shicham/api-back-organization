package com.crm.api.organization.services;

import com.crm.api.organization.domains.OrganizationEntity;
import com.crm.api.organization.forms.Organization;
import com.crm.api.organization.forms.OrganizationFilter;
import com.crm.commun.domains.searchSpec.SearchCriteria;
import com.crm.commun.exceptions.ServiceException;
import com.crm.commun.results.RequestFilter;
import org.springframework.data.domain.Page;

public interface OrganizationService {
    public Page<OrganizationEntity> find(RequestFilter filter) throws ServiceException;
    Organization get(Long id) throws ServiceException;
    Organization create(Organization form) throws ServiceException;
    Organization update(Organization form) throws ServiceException;
    void delete(Long id) throws ServiceException;
}
