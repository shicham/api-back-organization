package com.crm.api.organization.rules;

import com.crm.api.organization.domains.OrganizationRelEntity;
import com.crm.api.organization.forms.OrganizationCreate;
import com.crm.commun.exceptions.ServiceException;
import com.crm.commun.tools.StringTools;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrganizationRelRule {
    /**
     * create rules
     *
     * @param entity
     * @throws ServiceException
     */
    public void create(OrganizationRelEntity entity) throws ServiceException {
        List<String> errors = new ArrayList<>(0);
        // required elements
        if (StringTools.isEmpty(entity.getRelTypeId())) {
            errors.add("relTypeId.required");
        }
        if (StringTools.isEmpty(entity.getParentId())) {
            errors.add("parentId.required");
        }
        if (StringTools.isEmpty(entity.getChildId())) {
            errors.add("childId.required");
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
    public void update(OrganizationRelEntity entity) throws ServiceException {
        List<String> errors = new ArrayList<>(0);
        if (StringTools.isEmpty(entity.getId())) {
            errors.add("id.required");
        }
        if (StringTools.isEmpty(entity.getRelTypeId())) {
            errors.add("relTypeId.required");
        }
        if (StringTools.isEmpty(entity.getParentId())) {
            errors.add("parentId.required");
        }
        if (StringTools.isEmpty(entity.getChildId())) {
            errors.add("childId.required");
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
    public void delete(OrganizationRelEntity entity) throws ServiceException {
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

    public void addOrganization(OrganizationCreate form) throws ServiceException{
        List<String> errors = new ArrayList<>(0);
        if (StringTools.isEmpty(form.getParentId())) {
            errors.add("id.parentId");
        }
        if (StringTools.isEmpty(form.getRelationTypeId())) {
            errors.add("relationTypeId.required");
        }
        if (errors.isEmpty()) {
            throw new ServiceException(errors);
        }
    }
}
