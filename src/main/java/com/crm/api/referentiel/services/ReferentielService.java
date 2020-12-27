package com.crm.api.referentiel.services;

import com.crm.api.referentiel.forms.Referentiel;
import com.crm.commun.exceptions.ServiceException;
import com.crm.commun.results.PaginResponse;
import com.crm.commun.results.RequestFilter;

public interface ReferentielService {
    PaginResponse<Referentiel> find(RequestFilter filter) throws ServiceException;

    Referentiel get(Long id) throws ServiceException;

    Referentiel create(Referentiel form) throws ServiceException;

    Referentiel update(Referentiel form, Long id) throws ServiceException;

    void delete(Long id) throws ServiceException;
}
