package com.robihidayat.promoservice.exception;

import com.robihidayat.promoservice.utils.enums.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * @author robihidayat
 *
 */
@Getter
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = -4751698956298202548L;

    private String message;
    private ResponseCode responseCode;

    public ValidationException(ResponseCode responseCode){this.responseCode = responseCode;}
    public ValidationException(ResponseCode responseCode, String message){
        this.responseCode = responseCode;
        this.message = message;
    }




}
