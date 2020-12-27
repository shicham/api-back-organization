package com.crm.api.organization.forms;

import com.crm.commun.forms.Form;
import lombok.Data;

import java.util.Date;

@Data
public class OrgPerson extends Form {
    private Long id;
    private Long typeId;
    private String typeLabel;
    private Date startAt;
    private Date endAt;
    private Person person;
}
