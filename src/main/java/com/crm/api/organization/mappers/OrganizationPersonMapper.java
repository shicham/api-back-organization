package com.crm.api.organization.mappers;

import com.crm.api.organization.domains.OrganizationPersonEntity;
import com.crm.api.organization.forms.OrgPerson;
import com.crm.api.organization.forms.OrganizationPerson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrganizationPersonMapper {

    @Autowired
    ModelMapper modelMapper;

    public OrganizationPerson toForm(OrganizationPersonEntity entity) {
        OrganizationPerson organizationPerson = modelMapper.map(entity, OrganizationPerson.class);

        organizationPerson.setOrganizationLabel(entity.getOrganization().getName());
        organizationPerson.setOrganizationExternalCode(entity.getOrganization().getExternalCode());
        organizationPerson.setOrganizationInternalCode(entity.getOrganization().getInternalCode());

        organizationPerson.setPersonLabel(entity.getPerson().getFname()+ " " + entity.getPerson().getLname());
        organizationPerson.setPersonExternalCode(entity.getPerson().getExternalCode());
        organizationPerson.setPersonInternalCode(entity.getPerson().getInternalCode());

        return organizationPerson;
    }

    public List<OrganizationPerson> toForm(List<OrganizationPersonEntity> list) {
        return list.stream().map(e -> {
            return toForm(e);
        }).collect(Collectors.toList());
    }


    public OrganizationPersonEntity toDomain(OrganizationPerson form) {
        return modelMapper.map(form, OrganizationPersonEntity.class);
    }

    public List<OrganizationPersonEntity> toDomain(List<OrganizationPerson> list) {
        return list.stream().map(e -> {
            return toDomain(e);
        }).collect(Collectors.toList());
    }

    public void toDomain(OrganizationPerson src, OrganizationPersonEntity dest) {
        modelMapper.map(src, dest);
    }
}