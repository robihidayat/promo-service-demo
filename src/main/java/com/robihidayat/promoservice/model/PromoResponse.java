package com.robihidayat.promoservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * @author robihidayat
 */
@Setter
@Getter
@ToString
public class PromoResponse extends BaseResponse{

    private Modules[] modules;

}
