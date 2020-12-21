package com.crm.commun.exceptions;

import java.util.List;

public class ServiceException extends WebException {
    public ServiceException() {
        super();
    }
    public ServiceException(List<String> errors) {
        super();
        this.errors = errors;
    }
    public ServiceException(String error) {
        super();
        this.errors.add(error);
    }
}
