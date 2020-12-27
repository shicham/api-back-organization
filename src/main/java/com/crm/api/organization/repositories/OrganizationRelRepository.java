package com.crm.api.organization.repositories;

import com.crm.api.organization.domains.OrganizationEntity;
import com.crm.api.organization.domains.OrganizationRelEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRelRepository extends JpaRepository<OrganizationRelEntity, Long>, JpaSpecificationExecutor {
    @Query("SELECT op.child FROM OrganizationRelEntity op WHERE op.parentId = :parentId and op.relTypeId in (:relTypeId)")
    Page<OrganizationRelEntity> findChildsByParentIdAndRelTypeId(@Param("parentId") Long parentId, @Param("relTypeId") Long[] relTypeId, Pageable pageable);

}
