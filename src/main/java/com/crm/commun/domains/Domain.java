package com.crm.commun.domains;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@MappedSuperclass
public class Domain {
    private Date deleteAt;
}
