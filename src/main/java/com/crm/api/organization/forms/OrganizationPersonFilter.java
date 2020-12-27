package com.crm.api.organization.forms;

import com.crm.commun.forms.Form;
import lombok.Data;

import java.util.Date;

@Data
public class OrganizationPersonFilter extends Form {
    private Long id;
    private Long[] relTypeId;
    private Date startAtFrom;
    private Date startAtTo;
    private Date endAtFrom;
    private Date endAtTo;
    private Long personId;
    private Long[] personTypeId;
    private Long organizationId;
    private int page;
    private int size;
}