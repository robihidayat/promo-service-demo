package com.robihidayat.promoservice.utils.enums;


import com.robihidayat.promoservice.exception.ValidationException;

/**
 * @author robihidayat
 *
 */
public enum ResponseCode {

    SUCCESS("0000","SUCCESS"),
    INSUFFICIENT_PARAMS("0001", "Paramater Kurang"),
    USER_NOT_FOUND("0002", "User not found"),
    USER_NOT_MODULES("0003", "User not set modules"),

    ENUMS_NOT_FOUND("9991", "Enums not found"),
    UNKNOWN("9999", "tidak diketahui");

    private String value;
    private String message;


    private ResponseCode(String value, String message) {
        this.value = value;
        this.message = message;
    }

    public String message() {
        return message;
    }

    public String value() {
        return  value;
    }


    public static ResponseCode getResponseCode(String data) {
    	for(ResponseCode response : ResponseCode.values()) {
    		if(response.value.contains(data)) {
    			return response;
    		}
    	}
        throw new ValidationException(ResponseCode.ENUMS_NOT_FOUND);
    }
}
