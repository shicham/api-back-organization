package com.crm.api.organization.mappers;

import com.crm.api.organization.domains.OrganizationRelEntity;
import com.crm.api.organization.forms.OrganizationRel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrganizationRelMapper {

    @Autowired
    ModelMapper modelMapper;

    public OrganizationRel toForm(OrganizationRelEntity entity) {
        return modelMapper.map(entity, OrganizationRel.class);
    }

    public List<OrganizationRel> toForm(List<OrganizationRelEntity> list) {
        return list.stream().map(e -> {
            return toForm(e);
        }).collect(Collectors.toList());
    }

    public OrganizationRelEntity toDomain(OrganizationRel form) {
        return modelMapper.map(form, OrganizationRelEntity.class);
    }

    public List<OrganizationRelEntity> toDomain(List<OrganizationRel> list) {
        return list.stream().map(e -> {
            return toDomain(e);
        }).collect(Collectors.toList());
    }

    public void toDomain(OrganizationRel src, OrganizationRelEntity dest) {
        modelMapper.map(src, dest);
    }
}