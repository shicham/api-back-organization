package com.crm.commun.exceptions;

import java.util.ArrayList;
import java.util.List;

public class WebException extends Exception {
    List<String> errors = new ArrayList<>(0);
    public WebException() {
        super();
    }
    public WebException(List<String> errors) {
        super();
        this.errors = errors;
    }
}
