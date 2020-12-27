package com.crm.api.referentiel.services.impl;

import com.crm.api.referentiel.domains.ReferentielEntity;
import com.crm.api.referentiel.forms.Referentiel;
import com.crm.api.referentiel.mappers.ReferentielMapper;
import com.crm.api.referentiel.repositories.ReferentielCustomRepository;
import com.crm.api.referentiel.rules.ReferentielRule;
import com.crm.api.referentiel.services.ReferentielService;
import com.crm.commun.exceptions.ObjectNotFoundException;
import com.crm.commun.exceptions.ServiceException;
import com.crm.commun.results.PaginResponse;
import com.crm.commun.results.RequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ReferentielServiceImpl implements ReferentielService {

    @Autowired
    ReferentielCustomRepository referentielCustomRepository;
    @Autowired
    ReferentielMapper referentielMapper;
    @Autowired
    ReferentielRule referentielRule;

    /**
     * find
     *
     * @param filter
     * @return
     * @throws ServiceException
     */
    @Override
    public PaginResponse<Referentiel> find(RequestFilter filter) throws ServiceException {
        Page<ReferentielEntity> page = referentielCustomRepository.find(filter, PageRequest.of(filter.getPage(), filter.getSize()));
        return new PaginResponse<Referentiel>(page.getTotalElements(), referentielMapper.toForm(page.getContent()));
    }

    /**
     * get
     *
     * @param id
     * @return
     * @throws ServiceException
     */
    @Override
    public Referentiel get(Long id) throws ServiceException {
        return referentielMapper.toForm(referentielCustomRepository.get(id).orElseThrow(ObjectNotFoundException::new));
    }

    /**
     * create
     *
     * @param form
     * @return
     * @throws ServiceException
     */
    @Override
    @Transactional(readOnly = false)
    public Referentiel create(Referentiel form) throws ServiceException {
        ReferentielEntity entity = referentielMapper.toDomain(form);
        referentielRule.create(entity);
        referentielCustomRepository.save(entity);
        return referentielMapper.toForm(entity);
    }

    /**
     * update
     *
     * @param form
     * @return
     * @throws ServiceException
     */
    @Override
    @Transactional(readOnly = false)
    public Referentiel update(Referentiel form, Long id) throws ServiceException {
        ReferentielEntity entity = referentielCustomRepository.get(id).orElseThrow(ObjectNotFoundException::new);
        referentielMapper.toDomain(form, entity);
        referentielRule.update(entity);
        referentielCustomRepository.save(entity);
        return referentielMapper.toForm(entity);
    }

    /**
     * delete
     *
     * @param id
     * @throws ServiceException
     */
    @Override
    @Transactional(readOnly = false)
    public void delete(Long id) throws ServiceException {
        ReferentielEntity org = referentielCustomRepository.get(id).orElseThrow(ObjectNotFoundException::new);
        referentielRule.delete(org);
        referentielCustomRepository.delete(org);
    }
}
