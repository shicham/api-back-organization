package com.crm.commun.domains;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
public class Domain implements Serializable {
    private Date deleteAt;
}
