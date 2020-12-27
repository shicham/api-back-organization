package com.crm.api.referentiel.repositories;

import com.crm.api.referentiel.domains.ReferentielEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferentielRepository extends JpaRepository<ReferentielEntity, Long>, JpaSpecificationExecutor {
}
