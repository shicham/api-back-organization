package com.crm.api.organization.services.impl;

import com.crm.api.organization.domains.OrganizationEntity;
import com.crm.api.organization.forms.Organization;
import com.crm.api.organization.mappers.OrganizationMapper;
import com.crm.api.organization.repositories.OrganizationCustomRepository;
import com.crm.api.organization.rules.OrganizationRule;
import com.crm.api.organization.services.OrganizationService;
import com.crm.commun.exceptions.ObjectNotFoundException;
import com.crm.commun.exceptions.ServiceException;
import com.crm.commun.results.PaginResponse;
import com.crm.commun.results.RequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationCustomRepository organizationCustomRepository;
    @Autowired
    OrganizationMapper organizationMapper;
    @Autowired
    OrganizationRule organizationRule;

    /**
     * find
     * @param filter
     * @return
     * @throws ServiceException
     */
    @Override
    public PaginResponse<Organization> find(RequestFilter filter) throws ServiceException {
        Page<OrganizationEntity> page = organizationCustomRepository.find(filter, PageRequest.of(filter.getPage(), filter.getSize()));
        return new PaginResponse<>(page);
    }

    /**
     * get
     * @param id
     * @return
     * @throws ServiceException
     */
    @Override
    public Organization get(Long id) throws ServiceException {
        return organizationMapper.toForm(organizationCustomRepository.get(id).orElseThrow(ObjectNotFoundException::new));
    }

    /**
     * create
     * @param form
     * @return
     * @throws ServiceException
     */
    @Override
    @Transactional(readOnly = false)
    public Organization create(Organization form) throws ServiceException {
        OrganizationEntity entity = organizationMapper.toDomain(form);
        organizationRule.create(entity);
        organizationCustomRepository.save(entity);
        return organizationMapper.toForm(entity);
    }

    /**
     * update
     * @param form
     * @return
     * @throws ServiceException
     */
    @Override
    @Transactional(readOnly = false)
    public Organization update(Organization form, Long id) throws ServiceException {
        OrganizationEntity entity = organizationCustomRepository.get(id).orElseThrow(ObjectNotFoundException::new);
        organizationMapper.toDomain(form,entity);
        organizationRule.update(entity);
        organizationCustomRepository.save(entity);
        return organizationMapper.toForm(entity);
    }

    /**
     * delete
     * @param id
     * @throws ServiceException
     */
    @Override
    @Transactional(readOnly = false)
    public void delete(Long id) throws ServiceException {
        OrganizationEntity org = organizationCustomRepository.get(id).orElseThrow(ObjectNotFoundException::new);
        organizationRule.delete(org);
        organizationCustomRepository.delete(org);
    }
}
