package com.robihidayat.promoservice.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author robihidayat
 */
@Setter
@Getter
public class BaseResponse {
    private String responseCode = "0000";
    private String responseMessage = "SUCCESS";
}
