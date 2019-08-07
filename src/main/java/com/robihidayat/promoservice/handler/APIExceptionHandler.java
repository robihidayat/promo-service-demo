package com.robihidayat.promoservice.handler;

import com.robihidayat.promoservice.exception.ValidationException;
import com.robihidayat.promoservice.model.BaseResponse;
import com.robihidayat.promoservice.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author robihidayat
 *
 */
@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class APIExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<BaseResponse> handleValidationException(ValidationException ex) {
        log.warn("Validation API exception caught: {}", ex.getMessage());
        BaseResponse response = new BaseResponse();
        response.setResponseCode(ex.getResponseCode().value());
        response.setResponseMessage(ex.getResponseCode().message());
        if (null != ex.getMessage() && !ex.getMessage().isEmpty()){
            response.setResponseMessage(ex.getMessage());
        }
        log.warn("Response : {} ", response);
        MDC.clear();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers,
                                                                             HttpStatus status, WebRequest request) {
        String error = ex.getParameterName() + " parameter is missing.";
        return new ResponseEntity<Object>(new ErrorResponse<>(Arrays.asList(error)), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException ex, HttpServletRequest request) {
        try {
            List<String> messages = ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
            return new ResponseEntity<>(new ErrorResponse<>(messages), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse<>(Arrays.asList(ex.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
