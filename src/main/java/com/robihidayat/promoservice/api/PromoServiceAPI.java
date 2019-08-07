package com.robihidayat.promoservice.api;

import com.robihidayat.promoservice.model.PromoResponse;
import com.robihidayat.promoservice.service.PromoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * @author robihidayat
 */
@RestController
@Slf4j
@RequestMapping("/modules")
@Validated
public class PromoServiceAPI {

    @Autowired
    PromoService promoService;

    @GetMapping
    public ResponseEntity<PromoResponse> getPromoModule(@RequestParam
                                                        @NotNull
                                                        Integer userId
                                                        ) {
        log.info("Show profile ...");
        log.info("Form: {} ", userId);
        return ResponseEntity.ok(promoService.findPromoByUsers(userId));
    }
}
