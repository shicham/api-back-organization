package com.crm.commun.exceptions;

import java.util.List;

public class DBException extends ServiceException {
    public DBException() {
        super();
    }
    public DBException(List<String> errors) {
        super();
        this.errors = errors;
    }
    public DBException(String error) {
        super();
        this.errors.add(error);
    }
}
