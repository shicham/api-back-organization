package com.crm.api.organization.forms;

import lombok.Data;

@Data
public class OrganizationFilter {
    private Long id;
    private String internalCode;
    private String externalCode;
    private String name;
    private String description;
    private Long parentId;
}
