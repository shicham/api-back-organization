package com.crm.api.organization.mappers;

import com.crm.api.organization.domains.OrganizationEntity;
import com.crm.api.organization.forms.Organization;
import com.crm.api.organization.forms.OrganizationPerson;
import com.crm.api.organization.forms.PersonCreate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.crm.api.referentiel.repositories.ReferentielRepository;
import com.crm.api.referentiel.domains.ReferentielEntity;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrganizationMapper {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ReferentielRepository referentielRepository;

    public Organization toForm(OrganizationEntity entity) {
        Organization organization = modelMapper.map(entity, Organization.class);
        if(entity.getTypeId() != null){
            ReferentielEntity type = referentielRepository.findById(entity.getTypeId()).get();
            organization.setTypeLabel(type.getLabel());
        }
        if(entity.getStatusId() != null){
            ReferentielEntity status = referentielRepository.findById(entity.getStatusId()).get();
            organization.setStatusLabel(status.getLabel());
            organization.setStatusCode(status.getInternalCode());
        }
        
        //organization.setStatusLabel(entity.getStatus().getLabel());
        //organization.setStatusCode(entity.getStatus().getInternalCode());
        if(entity.getParent() != null){
            organization.setParentName(entity.getParent().getName());
            organization.setParentCode(entity.getParent().getInternalCode());
        }
        
        return organization;
    }

    public List<Organization> toForm(List<OrganizationEntity> list) {
        return list.stream().map(e -> {
            return toForm(e);
        }).collect(Collectors.toList());
    }

    public OrganizationEntity toDomain(Organization form) {
        return modelMapper.map(form, OrganizationEntity.class);
    }

    public List<OrganizationEntity> toDomain(List<Organization> list) {
        return list.stream().map(e -> {
            return toDomain(e);
        }).collect(Collectors.toList());
    }

    public void toDomain(Organization src, OrganizationEntity dest) {
        modelMapper.map(src, dest);
    }


}
