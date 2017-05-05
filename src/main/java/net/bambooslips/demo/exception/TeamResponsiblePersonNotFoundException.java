package net.bambooslips.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Administrator on 2017/4/21.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Post Not Found.")
public class TeamResponsiblePersonNotFoundException extends RuntimeException{
    public TeamResponsiblePersonNotFoundException(final String message) {
        super(message);
    }
}
