package com.crm.api.organization.forms;

import com.crm.commun.forms.Form;
import com.crm.commun.forms.IForm;
import lombok.Data;

import java.util.Date;

@Data
public class OrganizationCreate extends Form implements IForm {

    private Organization organization;
    private Long parentId;
    private Long relationId;
    private Long[] relationTypeId;
    private Date relationStartAt;
    private Date relationEndAt;

    public OrganizationCreate() {
        super();
    }
    public OrganizationCreate(Organization organization, Long relationId,Long parentId, Long[] relationTypeId,
                        Date relationStartAt, Date relationEndAt) {
        super();
        this.organization = organization;
        this.relationId = relationId;
        this.parentId = parentId;
        this.relationTypeId = relationTypeId;
        this.relationStartAt = relationStartAt;
        this.relationEndAt = relationEndAt;
    }
}