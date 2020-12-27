package com.crm.api.organization.forms;

import com.crm.commun.forms.Form;
import lombok.Data;

import java.util.Date;

@Data
public class OrganizationPerson extends Form {
    private Long id;
    private Long relTypeId;
    private String relTypeLabel;
    private Date startAt;
    private Date endAt;

    private Long personId;
    private String personInternalCode;
    private String personExternalCode;
    private String personLabel;

    private Long organizationId;
    private String organizationInternalCode;
    private String organizationExternalCode;
    private String organizationLabel;
}
