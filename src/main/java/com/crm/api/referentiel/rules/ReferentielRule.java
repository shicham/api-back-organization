package com.crm.api.referentiel.rules;

import com.crm.api.referentiel.domains.ReferentielEntity;
import com.crm.commun.exceptions.ServiceException;
import com.crm.commun.tools.StringTools;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReferentielRule {
    /**
     * create rules
     *
     * @param entity
     * @throws ServiceException
     */
    public void create(ReferentielEntity entity) throws ServiceException {
        List<String> errors = new ArrayList<>(0);
        // required elements
        if (StringTools.isEmpty(entity.getLabel())) {
            errors.add("name.required");
        }

        // generate internal code
        entity.setInternalCode(generateCode("PERSON_INTERNAL_CODE"));

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
    public void update(ReferentielEntity entity) throws ServiceException {
        List<String> errors = new ArrayList<>(0);
        if (StringTools.isEmpty(entity.getLabel())) {
            errors.add("fname.required");
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
    public void delete(ReferentielEntity entity) throws ServiceException {

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
