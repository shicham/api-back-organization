package com.crm.api.organization.forms;

import com.crm.commun.forms.Form;
import lombok.Data;

import java.util.Date;

@Data
public class OrganizationRelUpdate extends Form {
    private Long id;
    private Long relTypeId;
    private Date startAt;
    private Date endAt;
    private Long parentId;
    private Long childId;
}
