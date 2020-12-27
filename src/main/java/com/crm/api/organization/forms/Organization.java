package com.crm.api.organization.forms;

import com.crm.commun.forms.Form;
import lombok.Data;

@Data
public class Organization extends Form {
    private Long id;
    private String internalCode;
    private String externalCode;
    private String name;
    private String description;
    private Long typeId;
    private String typeLabel;
}
