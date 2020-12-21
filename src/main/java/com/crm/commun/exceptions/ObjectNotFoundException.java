package com.crm.commun.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        code = HttpStatus.NOT_FOUND,
        reason = "Resource not found with the given identifier",value = HttpStatus.NOT_FOUND)
public class ObjectNotFoundException extends RuntimeException {
}
