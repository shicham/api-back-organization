package com.crm.api.organization.forms;

import lombok.Data;

@Data
public class OrganizationFilter {
    private Long id;
    private Long[] typeId;
    private String internalCode;
    private String externalCode;
    private String name;
    private int page;
    private int size;
}
