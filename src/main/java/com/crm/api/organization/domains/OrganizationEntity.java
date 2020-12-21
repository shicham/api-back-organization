package com.crm.api.organization.domains;

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
    @Column(name = "parent_fk")
    private Long parentId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_fk", foreignKey = @ForeignKey(name = "org_org_parent"))
    private OrganizationEntity parent;
}
