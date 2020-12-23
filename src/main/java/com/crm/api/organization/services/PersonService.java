package com.crm.api.organization.services;

import com.crm.api.organization.domains.PersonEntity;
import com.crm.api.organization.forms.Person;
import com.crm.commun.exceptions.ServiceException;
import com.crm.commun.results.PaginResponse;
import com.crm.commun.results.RequestFilter;
import org.springframework.data.domain.Page;

public interface PersonService {
    PaginResponse<Person> find(RequestFilter filter) throws ServiceException;
    Person get(Long id) throws ServiceException;
    Person create(Person form) throws ServiceException;
    Person update(Person form, Long id) throws ServiceException;
    void delete(Long id) throws ServiceException;
}
