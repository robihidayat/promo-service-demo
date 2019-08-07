package com.robihidayat.promoservice.service;

import com.robihidayat.promoservice.model.PromoResponse;

/**
 * @author robihidayat
 */

public interface PromoService {

    PromoResponse findPromoByUsers(Integer request);

}
