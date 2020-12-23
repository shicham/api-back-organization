package com.crm.api.organization.services.impl;

import com.crm.api.organization.domains.PersonEntity;
import com.crm.api.organization.forms.Person;
import com.crm.api.organization.mappers.PersonMapper;
import com.crm.api.organization.repositories.PersonCustomRepository;
import com.crm.api.organization.rules.PersonRule;
import com.crm.api.organization.services.PersonService;
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
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonCustomRepository personCustomRepository;
    @Autowired
    PersonMapper personMapper;
    @Autowired
    PersonRule personRule;

    /**
     * find
     * @param filter
     * @return
     * @throws ServiceException
     */
    @Override
    public PaginResponse<Person> find(RequestFilter filter) throws ServiceException {
        Page<PersonEntity> page = personCustomRepository.find(filter, PageRequest.of(filter.getPage(), filter.getSize()));
        return new PaginResponse<Person>(page.getTotalElements(), personMapper.toForm(page.getContent()));
    }

    /**
     * get
     * @param id
     * @return
     * @throws ServiceException
     */
    @Override
    public Person get(Long id) throws ServiceException {
        return personMapper.toForm(personCustomRepository.get(id).orElseThrow(ObjectNotFoundException::new));
    }

    /**
     * create
     * @param form
     * @return
     * @throws ServiceException
     */
    @Override
    @Transactional(readOnly = false)
    public Person create(Person form) throws ServiceException {
        PersonEntity entity = personMapper.toDomain(form);
        personRule.create(entity);
        personCustomRepository.save(entity);
        return personMapper.toForm(entity);
    }

    /**
     * update
     * @param form
     * @return
     * @throws ServiceException
     */
    @Override
    @Transactional(readOnly = false)
    public Person update(Person form, Long id) throws ServiceException {
        PersonEntity entity = personCustomRepository.get(id).orElseThrow(ObjectNotFoundException::new);
        personMapper.toDomain(form,entity);
        personRule.update(entity);
        personCustomRepository.save(entity);
        return personMapper.toForm(entity);
    }

    /**
     * delete
     * @param id
     * @throws ServiceException
     */
    @Override
    @Transactional(readOnly = false)
    public void delete(Long id) throws ServiceException {
        PersonEntity org = personCustomRepository.get(id).orElseThrow(ObjectNotFoundException::new);
        personRule.delete(org);
        personCustomRepository.delete(org);
    }
}
