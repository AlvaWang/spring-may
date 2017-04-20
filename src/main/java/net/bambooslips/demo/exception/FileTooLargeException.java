package net.bambooslips.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartException;

@ResponseStatus(value= HttpStatus.PAYLOAD_TOO_LARGE, reason="Uploaded File is too large.")
public class FileTooLargeException extends MultipartException {

    private static final long serialVersionUID = 1L;

    public FileTooLargeException(final String message) {
        super(message);
    }

}
