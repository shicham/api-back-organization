package com.crm.api.organization.domains;

import com.crm.api.referentiel.domains.ReferentielEntity;
import com.crm.commun.domains.Domain;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "org_org")
public class OrganizationEntity extends Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String internalCode;
    private String externalCode;
    private String name;
    private String description;
    private String primaryEmail;
    private String primaryPhone;
    @Column(name = "type_fk")
    private Long typeId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_fk", foreignKey = @ForeignKey(name = "org_org_person_type"), insertable = false, updatable = false, nullable = true)
    private ReferentielEntity type;
    
    @Column(name = "status_fk")
    private Long statusId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_fk", foreignKey = @ForeignKey(name = "org_org_person_status"), insertable = false, updatable = false, nullable = true)
    private ReferentielEntity status;
    
}
