package com.crm.api.organization.services.impl;

import com.crm.api.organization.domains.OrganizationPersonEntity;
import com.crm.api.organization.domains.OrganizationRelEntity;
import com.crm.api.organization.forms.OrganizationPerson;
import com.crm.api.organization.mappers.OrganizationPersonMapper;
import com.crm.api.organization.repositories.OrganizationPersonCustomRepository;
import com.crm.api.organization.rules.OrganizationPersonRule;
import com.crm.api.organization.services.OrganizationPersonService;
import com.crm.commun.exceptions.ObjectNotFoundException;
import com.crm.commun.exceptions.ServiceException;
import com.crm.commun.results.PaginResponse;
import com.crm.commun.results.RequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class OrganizationPersonServiceImpl implements OrganizationPersonService {

    @Autowired
    OrganizationPersonCustomRepository organizationPersonCustomRepository;
    @Autowired
    OrganizationPersonMapper organizationPersonMapper;
    @Autowired
    OrganizationPersonRule organizationPersonRule;

    /**
     * find
     *
     * @param filter
     * @return
     * @throws ServiceException
     */
    @Override
    public PaginResponse<OrganizationPerson> find(RequestFilter filter) throws ServiceException {
        Page<OrganizationPersonEntity> page = organizationPersonCustomRepository.find(filter, PageRequest.of(filter.getPage(), filter.getSize()));
        return new PaginResponse<OrganizationPerson>(page.getTotalElements(), organizationPersonMapper.toForm(page.getContent()));
    }

    /**
     * get
     *
     * @param id
     * @return
     * @throws ServiceException
     */
    @Override
    public OrganizationPerson get(Long id) throws ServiceException {
        return organizationPersonMapper.toForm(organizationPersonCustomRepository.get(id).orElseThrow(ObjectNotFoundException::new));
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
    public OrganizationPerson create(OrganizationPerson form) throws ServiceException {
        OrganizationPersonEntity entity = organizationPersonMapper.toDomain(form);
        organizationPersonRule.create(entity);
        organizationPersonCustomRepository.save(entity);
        return organizationPersonMapper.toForm(entity);
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
    public OrganizationPerson update(OrganizationPerson form, Long id) throws ServiceException {
        OrganizationPersonEntity entity = organizationPersonCustomRepository.get(id).orElseThrow(ObjectNotFoundException::new);
        organizationPersonMapper.toDomain(form, entity);
        organizationPersonRule.update(entity);
        organizationPersonCustomRepository.save(entity);
        return organizationPersonMapper.toForm(entity);
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
        OrganizationPersonEntity org = organizationPersonCustomRepository.get(id).orElseThrow(ObjectNotFoundException::new);
        organizationPersonRule.delete(org);
        organizationPersonCustomRepository.delete(org);
    }

    @Override
    @Transactional(readOnly = false)
    public void close(Long personId, Long organizationId, Long[] relationTypeId) throws ServiceException {
        List<OrganizationPersonEntity> list = organizationPersonCustomRepository.findByPersonIdAndOrganizationIdAndRelationTypeIds(personId,organizationId,relationTypeId);
        for(OrganizationPersonEntity rel : list){
            organizationPersonCustomRepository.delete(rel);
        }
    }
}
