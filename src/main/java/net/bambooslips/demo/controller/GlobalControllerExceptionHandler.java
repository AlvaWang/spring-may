package net.bambooslips.demo.controller;

import net.bambooslips.demo.exception.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;

import javax.validation.ConstraintViolationException;

/**
 * Created by Eureka on 2016/5/12.
 */
//日常的抛出异常覆写 Exception 改变状态码然后通过CustomErrorController抛出， 特殊的异常才需要handler来执行事务，通过在这里的切面来执行
@ControllerAdvice
class GlobalControllerExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

    @ResponseStatus(HttpStatus.CONFLICT)  // 409
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ErrorResponse handleConflict(DataIntegrityViolationException ex) {
        return new ErrorResponse(HttpStatus.CONFLICT.value(), ex);
    }

    @ResponseStatus(HttpStatus.PAYLOAD_TOO_LARGE)
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseBody
    public ErrorResponse handleFileTooLarge(MaxUploadSizeExceededException ex) {
        return new ErrorResponse(HttpStatus.PAYLOAD_TOO_LARGE.value(), ex);
    }

    @ResponseStatus(HttpStatus.PAYLOAD_TOO_LARGE)
    @ExceptionHandler(MultipartException.class)
    @ResponseBody
    public ErrorResponse handleMultipartException(MultipartException ex) {
        return new ErrorResponse(HttpStatus.PAYLOAD_TOO_LARGE.value(), ex);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public ErrorResponse handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        ErrorResponse er = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex);
        er.setMessage("传入参数格式有误");
        return er;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ErrorResponse handleConstraintViolationException(ConstraintViolationException ex) {
        ErrorResponse er = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex);
        er.setMessage("缺少必要参数");
        return er;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthenticationCredentialsNotFoundException.class)
    @ResponseBody
    public ErrorResponse handleConstraintViolationException(AuthenticationCredentialsNotFoundException ex) {
        ErrorResponse er = new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), ex);
        return er;
    }

}