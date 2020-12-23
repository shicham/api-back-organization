package com.crm.commun.results;

import com.crm.commun.forms.Form;
import com.crm.commun.forms.IForm;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class PaginResponse<T> extends Response implements IResponse {

    private long totalElements;

    public PaginResponse(){
        super();
    }

    public PaginResponse(Page page) {
        this.setData(page.getContent());
        this.setTotalElements(page.getTotalElements());
    }
    public PaginResponse(long totalElements,List list) {
        this.setData(list);
        this.setTotalElements(totalElements);
    }
}
