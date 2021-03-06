package net.bambooslips.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Eureka on 2016/5/16.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Post Not Found.")
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(final String message) {
        super(message);
    }
}
