package net.bambooslips.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Eureka on 2016/5/13.
 */
//@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Parameters Not Valid.")
@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class FileNameExtensionNotSupportedException extends IllegalArgumentException {

    /**
     * Constructs an <code>IllegalArgumentException</code> with the
     * specified detail message.
     *
     * @param s the detail message.
     */
    public FileNameExtensionNotSupportedException(String s) {
        super(s);
    }
}
