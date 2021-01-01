package com.crm.commun.results;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class PaginResponse<T> extends Response implements IResponse {

    private long totalElements;
    private int size;
    private int page;
    public PaginResponse() {
        super();
    }

    public PaginResponse(Page page) {
        this.setData(page.getContent());
        this.setTotalElements(page.getTotalElements());
    }

    public PaginResponse(long totalElements, List list) {
        this.setData(list);
        this.setTotalElements(totalElements);
    }
    public PaginResponse(long totalElements, List list, int page, int size) {
        this.setData(list);
        this.setTotalElements(totalElements);
        this.page = page;
        this.size=size;
    }
}
