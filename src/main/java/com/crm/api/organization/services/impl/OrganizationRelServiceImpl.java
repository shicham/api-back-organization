package com.crm.api.organization.services.impl;

import com.crm.api.organization.domains.OrganizationEntity;
import com.crm.api.organization.domains.OrganizationRelEntity;
import com.crm.api.organization.forms.OrganizationRel;
import com.crm.api.organization.repositories.OrganizationRepository;
import com.crm.api.organization.mappers.OrganizationRelMapper;
import com.crm.api.organization.repositories.OrganizationRelCustomRepository;
import com.crm.api.organization.rules.OrganizationRelRule;
import com.crm.api.organization.services.OrganizationRelService;
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
public class OrganizationRelServiceImpl implements OrganizationRelService {

    @Autowired
    OrganizationRelCustomRepository organizationRelCustomRepository;
    @Autowired
    OrganizationRepository organizationRepository;
    @Autowired
    OrganizationRelMapper organizationRelMapper;
    @Autowired
    OrganizationRelRule organizationRelRule;

    /**
     * find
     *
     * @param filter
     * @return
     * @throws ServiceException
     */
    @Override
    public PaginResponse<OrganizationRel> find(RequestFilter filter) throws ServiceException {
        Page<OrganizationRelEntity> page = organizationRelCustomRepository.find(filter, PageRequest.of(filter.getPage(), filter.getSize()));
        return new PaginResponse<OrganizationRel>(page.getTotalElements(), organizationRelMapper.toForm(page.getContent()));
    }

    /**
     * get
     *
     * @param id
     * @return
     * @throws ServiceException
     */
    @Override
    public OrganizationRel get(Long id) throws ServiceException {
        return organizationRelMapper.toForm(organizationRelCustomRepository.get(id).orElseThrow(ObjectNotFoundException::new));
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
    public OrganizationRel create(OrganizationRel form) throws ServiceException {
        OrganizationRelEntity entity = organizationRelMapper.toDomain(form);
        organizationRelRule.create(entity);
        if(entity.getParentId() != null){
            OrganizationEntity parent = organizationRepository.get(entity.getParentId());
            entity.setHierarchy(parent.getHierarchy());
        }else{
            entity.setHierarchy(parent.getId());
        }
        organizationRelCustomRepository.save(entity);
        return organizationRelMapper.toForm(entity);
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
    public OrganizationRel update(OrganizationRel form, Long id) throws ServiceException {
        OrganizationRelEntity entity = organizationRelCustomRepository.get(id).orElseThrow(ObjectNotFoundException::new);
        organizationRelMapper.toDomain(form, entity);
        organizationRelRule.update(entity);
        organizationRelCustomRepository.save(entity);
        return organizationRelMapper.toForm(entity);
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
        OrganizationRelEntity org = organizationRelCustomRepository.get(id).orElseThrow(ObjectNotFoundException::new);
        organizationRelRule.delete(org);
        organizationRelCustomRepository.delete(org);
    }

    @Override
    @Transactional(readOnly = false)
    public void close(Long childId, Long parentId, Long[] relationTypeId) throws ServiceException {
        List<OrganizationRelEntity> list = organizationRelCustomRepository.findByChildIdAndParentIdAndRelationTypeIds(childId,parentId,relationTypeId);
        for(OrganizationRelEntity rel : list){
            organizationRelCustomRepository.delete(rel);
        }
    }
}
