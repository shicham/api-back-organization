package com.crm.api.organization.domains;

import com.crm.api.referentiel.domains.ReferentielEntity;
import com.crm.commun.domains.Domain;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "org_org_person")
public class OrganizationPersonEntity extends Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "type_fk")
    private Long typeId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_fk", foreignKey = @ForeignKey(name = "org_org_person_type"), insertable = false, updatable = false, nullable = true)
    private ReferentielEntity type;

    @Column(nullable = false)
    private Date startAt;
    private Date endAt;

    @Column(name = "person_fk")
    private Long personId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_fk", foreignKey = @ForeignKey(name = "org_org_person_person"), insertable = false, updatable = false, nullable = false)
    private PersonEntity person;

    @Column(name = "organization_fk")
    private Long organizationId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_fk", foreignKey = @ForeignKey(name = "org_org_person_org"), insertable = false, updatable = false, nullable = false)
    private OrganizationEntity organization;
}
