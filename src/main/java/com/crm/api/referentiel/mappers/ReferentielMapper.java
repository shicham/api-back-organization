package com.crm.api.referentiel.mappers;

import com.crm.api.referentiel.domains.ReferentielEntity;
import com.crm.api.referentiel.forms.Referentiel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReferentielMapper {

    @Autowired
    ModelMapper modelMapper;

    public Referentiel toForm(ReferentielEntity entity) {
        return modelMapper.map(entity, Referentiel.class);
    }

    public List<Referentiel> toForm(List<ReferentielEntity> list) {
        return list.stream().map(e -> {
            return toForm(e);
        }).collect(Collectors.toList());
    }

    public ReferentielEntity toDomain(Referentiel form) {
        return modelMapper.map(form, ReferentielEntity.class);
    }

    public List<ReferentielEntity> toDomain(List<Referentiel> list) {
        return list.stream().map(e -> {
            return toDomain(e);
        }).collect(Collectors.toList());
    }

    public void toDomain(Referentiel src, ReferentielEntity dest) {
        modelMapper.map(src, dest);
    }
}
