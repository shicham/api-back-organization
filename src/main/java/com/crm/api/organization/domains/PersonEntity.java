package com.crm.api.organization.domains;

import com.crm.api.referentiel.domains.ReferentielEntity;
import com.crm.commun.domains.Domain;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "org_person")
public class PersonEntity extends Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String internalCode;
    private String externalCode;
    private String fname;
    private String lname;
    @Column(name = "type_fk")
    private Long typeId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_fk", foreignKey = @ForeignKey(name = "org_org_person_type"), insertable = false, updatable = false, nullable = true)
    private ReferentielEntity type;
}
