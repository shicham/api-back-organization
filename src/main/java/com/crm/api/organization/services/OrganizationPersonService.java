package com.crm.api.organization.services;

import com.crm.api.organization.forms.OrganizationPerson;
import com.crm.api.organization.forms.Person;
import com.crm.api.organization.forms.PersonCreate;
import com.crm.commun.exceptions.ServiceException;
import com.crm.commun.results.PaginResponse;
import com.crm.commun.results.RequestFilter;

public interface OrganizationPersonService {
    PaginResponse<OrganizationPerson> find(RequestFilter filter) throws ServiceException;

    OrganizationPerson get(Long id) throws ServiceException;

    OrganizationPerson create(OrganizationPerson form) throws ServiceException;

    OrganizationPerson update(OrganizationPerson form, Long id) throws ServiceException;

    void delete(Long id) throws ServiceException;

    void close(Long personId, Long organizationId, Long[] relationTypeId) throws ServiceException;
}
