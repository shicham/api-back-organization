package com.crm.api.referentiel.domains;

import commun.domains.Domain;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "ref_referentiel")
public class ReferentielEntity extends Domain {
    @Id
    private Long id;
    @Column(unique = true)
    private String internalCode;
    private String externalCode;
    private String name;
    private String description;
    private Long parentId;
    private ReferentielEntity parent;
}
