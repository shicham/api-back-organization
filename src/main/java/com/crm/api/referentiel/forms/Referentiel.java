package com.crm.api.referentiel.forms;

import com.crm.commun.forms.Form;
import lombok.Data;

@Data
public class Referentiel extends Form {
    private Long id;
    private String internalCode;
    private String externalCode;
    private String label;
    private String description;
    private Long parentId;
    private Referentiel parent;
}