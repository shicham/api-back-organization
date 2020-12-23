package com.crm.api.organization.domains;

import com.crm.api.referentiel.domains.ReferentielEntity;
import com.crm.commun.domains.Domain;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "org_org_rel")
public class OrganizationRelEntity extends Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "type_fk")
    private Long typeId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_fk", foreignKey = @ForeignKey(name = "org_org_rel_type"), insertable = false, updatable = false, nullable = true)
    private ReferentielEntity type;

    @Column(nullable = false)
    private Date startAt;
    private Date endAt;

    @Column(name = "parent_fk")
    private Long parentId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_fk", foreignKey = @ForeignKey(name = "org_org_rel_parent"), insertable = false, updatable = false, nullable = false)
    private OrganizationEntity parent;

    @Column(name = "child_fk")
    private Long childId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "child_fk", foreignKey = @ForeignKey(name = "org_org_rel_child"), insertable = false, updatable = false, nullable = false)
    private OrganizationEntity child;
}
