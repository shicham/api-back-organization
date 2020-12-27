package com.crm.api.organization.repositories;

import com.crm.api.organization.domains.OrganizationPersonEntity;
import com.crm.api.organization.domains.PersonEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationPersonRepository extends JpaRepository<OrganizationPersonEntity, Long>, JpaSpecificationExecutor {

    @Query("SELECT op FROM OrganizationPersonEntity op WHERE op.organizationId = :organizationId and op.relTypeId in (:relTypeId)")
    Page<OrganizationPersonEntity> findPersonsByOrganizationIdAndTypeRelId(@Param("organizationId") Long organizationId, @Param("relTypeId") Long[] relTypeId, Pageable pageable);

}
