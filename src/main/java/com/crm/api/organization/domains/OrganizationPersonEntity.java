package com.crm.api.organization.domains;

import com.crm.api.referentiel.domains.ReferentielEntity;
import commun.domains.Domain;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "org_org")
public class OrganizationPersonEntity extends Domain {
    @Id
    private Long id;
    @Column(name = "type_fk")
    private Long typeId;
    private ReferentielEntity type;
    @Column(name = "parent_fk")
    private Long organizationId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_fk", foreignKey = @ForeignKey(name = "org_org_parent"))
    private OrganizationEntity organization;
    @Column(name = "person_fk")
    private Long personId;
    private PersonEntity person;
}
