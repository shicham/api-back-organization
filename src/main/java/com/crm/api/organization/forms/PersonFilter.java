package com.crm.api.organization.forms;

import com.crm.commun.forms.Form;
import com.crm.commun.forms.IForm;
import lombok.Data;

@Data
public class PersonFilter extends Form implements IForm {
    private Long id;
    private String internalCode;
    private String externalCode;
    private String fname;
    private String lname;
    private Long typeId;
    private int page;
    private int size;
}