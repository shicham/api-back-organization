package com.crm.api.organization.rules;

import com.crm.api.organization.domains.OrganizationPersonEntity;
import com.crm.api.organization.forms.PersonCreate;
import com.crm.commun.exceptions.ServiceException;
import com.crm.commun.tools.StringTools;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrganizationPersonRule {
    /**
     * create rules
     *
     * @param entity
     * @throws ServiceException
     */
    public void create(OrganizationPersonEntity entity) throws ServiceException {
        List<String> errors = new ArrayList<>(0);
        // required elements
        if (StringTools.isEmpty(entity.getRelTypeId())) {
            errors.add("relTypeId.required");
        }
        if (StringTools.isEmpty(entity.getOrganizationId())) {
            errors.add("organizationId.required");
        }
        if (StringTools.isEmpty(entity.getPersonId())) {
            errors.add("personId.required");
        }
        if (errors.isEmpty()) {
            throw new ServiceException(errors);
        }
    }

    /**
     * update rules
     *
     * @param entity
     * @throws ServiceException
     */
    public void update(OrganizationPersonEntity entity) throws ServiceException {
        List<String> errors = new ArrayList<>(0);
        if (StringTools.isEmpty(entity.getId())) {
            errors.add("id.required");
        }
        if (StringTools.isEmpty(entity.getRelTypeId())) {
            errors.add("relTypeId.required");
        }
        if (StringTools.isEmpty(entity.getOrganizationId())) {
            errors.add("organizationId.required");
        }
        if (StringTools.isEmpty(entity.getPersonId())) {
            errors.add("personId.required");
        }
        if (errors.isEmpty()) {
            throw new ServiceException(errors);
        }
    }

    /**
     * delete rules
     *
     * @param entity
     * @throws ServiceException
     */
    public void delete(OrganizationPersonEntity entity) throws ServiceException {
        List<String> errors = new ArrayList<>(0);
        if (StringTools.isEmpty(entity.getId())) {
            errors.add("id.required");
        }
        if (errors.isEmpty()) {
            throw new ServiceException(errors);
        }
    }

    /**
     * generate code
     *
     * @param type
     * @return
     */
    public String generateCode(String type) {
        return null;
    }

    public void addPerson(PersonCreate form) throws ServiceException {
        List<String> errors = new ArrayList<>(0);
        if (StringTools.isEmpty(form.getOrganizationId())) {
            errors.add("id.organizationId");
        }
        if (StringTools.isEmpty(form.getRelationTypeId())) {
            errors.add("relationTypeId.required");
        }
        if (errors.isEmpty()) {
            throw new ServiceException(errors);
        }
    }
}
