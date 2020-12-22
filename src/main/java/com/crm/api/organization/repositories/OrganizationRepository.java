package com.crm.api.organization.repositories;

import com.crm.api.organization.domains.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<OrganizationEntity, Long>, JpaSpecificationExecutor {
}
