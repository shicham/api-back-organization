package com.crm.api.organization.domains;

import commun.domains.Domain;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "org_person")
public class PersonEntity extends Domain {
    @Id
    private Long id;
    @Column(unique = true)
    private String internalCode;
    private String externalCode;
    private String fname;
    private String lname;
}
