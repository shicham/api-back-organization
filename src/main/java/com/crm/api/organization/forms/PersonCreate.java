package com.crm.api.organization.forms;

import com.crm.commun.forms.Form;
import com.crm.commun.forms.IForm;
import lombok.Data;

import java.util.Date;

@Data
public class PersonCreate extends Form implements IForm {
    private Person person;
    private Long organizationId;
    private Long relationId;
    private Long relationTypeId[];
    private Date relationStartAt;
    private Date relationEndAt;

    public PersonCreate() {
        super();
    }
    public PersonCreate(Person person, Long relationId,Long organizationId, Long[] relationTypeId,
                        Date relationStartAt, Date relationEndAt) {
        super();
        this.person = person;
        this.relationId = relationId;
        this.organizationId = organizationId;
        this.relationTypeId = relationTypeId;
        this.relationStartAt = relationStartAt;
        this.relationEndAt = relationEndAt;
    }
}