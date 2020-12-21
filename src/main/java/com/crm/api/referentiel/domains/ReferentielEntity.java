package com.crm.api.referentiel.domains;

import com.crm.commun.domains.Domain;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ref_referentiel")
public class ReferentielEntity extends Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String internalCode;
    private String externalCode;
    private String name;
    private String description;
}
