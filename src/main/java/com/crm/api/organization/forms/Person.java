package com.crm.api.organization.forms;

import com.crm.commun.forms.Form;
import com.crm.commun.forms.IForm;
import lombok.Data;

import javax.persistence.*;

@Data
public class Person extends Form implements IForm {
    private Long id;
    private String internalCode;
    private String externalCode;
    private String fname;
    private String lname;
}