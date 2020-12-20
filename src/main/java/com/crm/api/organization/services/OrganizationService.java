package com.crm.api.organization.services;

import com.crm.api.organization.forms.Organization;
import com.crm.api.organization.forms.OrganizationFilter;
import commun.exceptions.ServiceException;
import org.springframework.data.domain.Page;

public interface OrganizationService {
    Page find(OrganizationFilter filter) throws ServiceException;
    Organization get(Long id) throws ServiceException;
    Organization create(Organization form) throws ServiceException;
    Organization update(Organization form) throws ServiceException;
    void delete(Long id) throws ServiceException;
}
