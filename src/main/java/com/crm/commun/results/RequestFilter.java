package com.crm.commun.results;

import com.crm.commun.domains.searchSpec.SearchCriteria;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RequestFilter {
    private List<SearchCriteria> criteria = new ArrayList<>(0);
    private int page;
    private int size;

}
