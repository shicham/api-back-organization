package com.crm.api.organization.domains;

import commun.domains.Domain;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "org_org")
public class OrganizationEntity extends Domain {
    @Id
    private Long id;
    @Column(unique = true)
    private String internalCode;
    private String externalCode;
    private String name;
    private String description;
    @Column(name = "parent_id")
    private Long parentId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id", foreignKey = @ForeignKey(name = "org_org_parent"))
    private OrganizationEntity parent;
}
