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
    private String label;
    private String description;
    @Column(name = "parent_fk")
    private Long parentId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_fk", foreignKey = @ForeignKey(name = "ref_referentiel_parent"), insertable = false, updatable = false, nullable = true)
    private ReferentielEntity parent;
}