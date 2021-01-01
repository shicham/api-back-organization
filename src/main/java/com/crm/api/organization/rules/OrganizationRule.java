package com.crm.api.organization.rules;
import com.crm.commun.exceptions.ObjectNotFoundException;
import com.crm.api.organization.domains.OrganizationEntity;
import com.crm.commun.exceptions.ServiceException;
import com.crm.commun.tools.StringTools;
import org.springframework.stereotype.Component;
import com.crm.api.referentiel.repositories.ReferentielRepository;
import com.crm.api.referentiel.domains.ReferentielEntity;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrganizationRule {
    @Autowired
    private ReferentielRepository referentielRepository;
    /**
     * create rules
     *
     * @param entity
     * @throws ServiceException
     */
    public void create(OrganizationEntity entity) throws ServiceException {
        List<String> errors = new ArrayList<>(0);
        // required elements
        if (StringTools.isEmpty(entity.getName())) {
            errors.add("name.required");
        }
        if (StringTools.isEmpty(entity.getTypeId())) {
            errors.add("typeId.required");
        }else {
            ReferentielEntity type = referentielRepository.findById(entity.getTypeId()).orElseThrow(ObjectNotFoundException::new);
            entity.setType(type);   
        }

        // generate internal code
        entity.setInternalCode(generateCode("ORGANIZATION_INTERNAL_CODE"));

        if (!errors.isEmpty()) {
            throw new ServiceException(errors);
        }
    }

    /**
     * update rules
     *
     * @param entity
     * @throws ServiceException
     */
    public void update(OrganizationEntity entity) throws ServiceException {
        List<String> errors = new ArrayList<>(0);
        if (StringTools.isEmpty(entity.getId())) {
            errors.add("id.required");
        }
        if (StringTools.isEmpty(entity.getName())) {
            errors.add("name.required");
        }
        if (!errors.isEmpty()) {
            throw new ServiceException(errors);
        }
    }

    /**
     * delete rules
     *
     * @param entity
     * @throws ServiceException
     */
    public void delete(OrganizationEntity entity) throws ServiceException {
        List<String> errors = new ArrayList<>(0);
        if (StringTools.isEmpty(entity.getId())) {
            errors.add("id.required");
        }
        if (!errors.isEmpty()) {
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
}
