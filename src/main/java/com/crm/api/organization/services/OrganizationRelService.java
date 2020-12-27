package com.crm.api.organization.services;

import com.crm.api.organization.forms.OrganizationRel;
import com.crm.commun.exceptions.ServiceException;
import com.crm.commun.results.PaginResponse;
import com.crm.commun.results.RequestFilter;

public interface OrganizationRelService {
    PaginResponse<OrganizationRel> find(RequestFilter filter) throws ServiceException;

    OrganizationRel get(Long id) throws ServiceException;

    OrganizationRel create(OrganizationRel form) throws ServiceException;

    OrganizationRel update(OrganizationRel form, Long id) throws ServiceException;

    void delete(Long id) throws ServiceException;

    void close(Long childId, Long parentId, Long[] relationTypeId) throws ServiceException;
}
