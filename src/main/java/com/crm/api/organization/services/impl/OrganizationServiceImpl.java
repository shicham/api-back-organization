package com.crm.api.organization.services.impl;

import com.crm.api.organization.domains.OrganizationEntity;
import com.crm.api.organization.forms.*;
import com.crm.api.organization.mappers.OrganizationMapper;
import com.crm.api.organization.repositories.OrganizationCustomRepository;
import com.crm.api.organization.rules.OrganizationPersonRule;
import com.crm.api.organization.rules.OrganizationRelRule;
import com.crm.api.organization.rules.OrganizationRule;
import com.crm.api.organization.services.OrganizationPersonService;
import com.crm.api.organization.services.OrganizationRelService;
import com.crm.api.organization.services.OrganizationService;
import com.crm.api.organization.services.PersonService;
import com.crm.commun.exceptions.ObjectNotFoundException;
import com.crm.commun.exceptions.ServiceException;
import com.crm.commun.results.PaginResponse;
import com.crm.commun.results.RequestFilter;
import com.crm.commun.tools.StringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
@Transactional(readOnly = true)
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationCustomRepository organizationCustomRepository;
    @Autowired
    OrganizationMapper organizationMapper;
    @Autowired
    OrganizationRule organizationRule;
    @Autowired
    PersonService personService;
    @Autowired
    OrganizationPersonService organizationPersonService;
    @Autowired
    OrganizationRelService organizationRelService;
    @Autowired
    OrganizationPersonRule organizationPersonRule;
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
    public PaginResponse<Organization> find(RequestFilter filter) throws ServiceException {
        Page<OrganizationEntity> page = organizationCustomRepository.find(filter, PageRequest.of(filter.getPage(), filter.getSize()));
        return new PaginResponse<>(page.getTotalElements(),organizationMapper.toForm(page.getContent()),filter.getPage(), filter.getSize());
    }

    /**
     * get
     *
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
     *
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
     *
     * @param form
     * @return
     * @throws ServiceException
     */
    @Override
    @Transactional(readOnly = false)
    public Organization update(Organization form, Long id) throws ServiceException {
        OrganizationEntity entity = organizationCustomRepository.get(id).orElseThrow(ObjectNotFoundException::new);
        organizationMapper.toDomain(form, entity);
        organizationRule.update(entity);
        organizationCustomRepository.save(entity);
        return organizationMapper.toForm(entity);
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
        OrganizationEntity org = organizationCustomRepository.get(id).orElseThrow(ObjectNotFoundException::new);
        organizationRule.delete(org);
        organizationCustomRepository.delete(org);
    }

    /**
     * childs
     * @param filter
     * @return
     * @throws ServiceException
     */
    @Override
    public PaginResponse<OrganizationRel> childs(OrganizationRelFilter filter) throws ServiceException {
         organizationCustomRepository.childs(filter, PageRequest.of(filter.getPage(), filter.getSize()));
        return null;
    }

    /**
     * persons
     * @param filter
     * @return
     * @throws ServiceException
     */
    @Override
    public PaginResponse<OrganizationPerson> persons(OrganizationPersonFilter filter) throws ServiceException {
         organizationCustomRepository.persons(filter, PageRequest.of(filter.getPage(), filter.getSize()));
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public PersonCreate addNewPerson(PersonCreate form) throws ServiceException {
        if(StringTools.isNotEmpty(form.getPerson().getId())){
            organizationPersonService.close(form.getPerson().getId(), form.getOrganizationId(),form.getRelationTypeId());
        }
        organizationPersonRule.addPerson(form);
        Person person = personService.create(form.getPerson());
        OrganizationPerson organizationPerson = new OrganizationPerson();
        organizationPerson.setPersonId(person.getId());
        organizationPerson.setStartAt(form.getRelationStartAt());
        organizationPerson.setEndAt(form.getRelationEndAt());

        for(Long relType : form.getRelationTypeId()){
            organizationPerson.setRelTypeId(relType);
            organizationPerson = organizationPersonService.create(organizationPerson);
        }

        return new PersonCreate(person, organizationPerson.getId(),organizationPerson.getOrganizationId(), form.getRelationTypeId(),
                organizationPerson.getStartAt(), organizationPerson.getEndAt());
    }

    @Override
    @Transactional(readOnly = false)
    public OrganizationCreate addNewOrganization(OrganizationCreate form) throws ServiceException {
        if(StringTools.isNotEmpty(form.getOrganization().getId())){
            organizationRelService.close(form.getOrganization().getId(), form.getParentId(),form.getRelationTypeId());
        }
        organizationRelRule.addOrganization(form);
        Organization organization = create(form.getOrganization());
        OrganizationRel organizationRel = new OrganizationRel();
        organizationRel.setChildId(organization.getId());
        organizationRel.setParentId(organization.getId());


        organizationRel.setStartAt(form.getRelationStartAt());
        organizationRel.setEndAt(form.getRelationEndAt());

        for(Long relType : form.getRelationTypeId()){
            organizationRel.setRelTypeId(relType);
            organizationRel = organizationRelService.create(organizationRel);
        }

        return new OrganizationCreate(organization, organizationRel.getId(),organizationRel.getParentId(), form.getRelationTypeId(),
                organizationRel.getStartAt(), organizationRel.getEndAt());
    }

}
