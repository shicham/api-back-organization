package com.crm.api.organization.services;

import com.crm.api.organization.domains.OrganizationEntity;
import com.crm.api.organization.forms.Organization;
import com.crm.api.organization.forms.OrganizationFilter;
import com.crm.commun.domains.searchSpec.SearchCriteria;
import com.crm.commun.exceptions.ServiceException;
import com.crm.commun.results.PaginResponse;
import com.crm.commun.results.RequestFilter;
import org.springframework.data.domain.Page;

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
}
