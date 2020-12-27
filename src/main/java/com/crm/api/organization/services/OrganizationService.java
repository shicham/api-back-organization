package com.crm.api.organization.services;

import com.crm.api.organization.forms.*;
import com.crm.commun.exceptions.ServiceException;
import com.crm.commun.results.PaginResponse;
import com.crm.commun.results.RequestFilter;

public interface OrganizationService {

    /**
     * find
     * @param filter
     * @return
     * @throws ServiceException
     */
    PaginResponse<Organization> find(RequestFilter filter) throws ServiceException;

    /**
     * get
     * @param id
     * @return
     * @throws ServiceException
     */
    Organization get(Long id) throws ServiceException;

    /**
     * create
     * @param form
     * @return
     * @throws ServiceException
     */
    Organization create(Organization form) throws ServiceException;

    /**
     * update
     * @param form
     * @param id
     * @return
     * @throws ServiceException
     */
    Organization update(Organization form, Long id) throws ServiceException;

    /**
     * delete
     * @param id
     * @throws ServiceException
     */
    void delete(Long id) throws ServiceException;

    PaginResponse<OrganizationRel> childs(OrganizationRelFilter filter) throws ServiceException;

    PaginResponse<OrganizationPerson> persons(OrganizationPersonFilter filter) throws ServiceException;

    PersonCreate addNewPerson(PersonCreate form)  throws ServiceException;

    OrganizationCreate addNewOrganization(OrganizationCreate form)  throws ServiceException;
}
