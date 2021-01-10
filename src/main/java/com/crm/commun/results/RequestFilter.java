package com.crm.commun.results;

import com.crm.commun.domains.searchSpec.SearchCriteria;
import lombok.Data;
import org.springframework.data.domain.Sort.Order;
import java.util.ArrayList;
import java.util.List;
import com.crm.commun.domains.searchSpec.Ord;

@Data
public class RequestFilter {
    private List<SearchCriteria> criteria = new ArrayList<>(0);
    private int page;
    private int size;
    private Ord[] sort;
    
    public int getSize(){
        if(size < 1){
            return 10;   
        }else {
            return size;   
        }
    }

}
