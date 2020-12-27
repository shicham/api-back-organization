package com.crm.api.organization.forms;

import com.crm.commun.forms.Form;
import lombok.Data;

import java.util.Date;

@Data
public class OrganizationRel extends Form {
    private Long id;
    private Long relTypeId;
    private String relTypeLabel;
    private Date startAt;
    private Date endAt;
    private Long parentId;
    private String parentLabel;
    private Long childId;
    private String childLabel;
}
