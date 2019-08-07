package com.robihidayat.promoservice.service.implement;

import com.google.gson.Gson;
import com.robihidayat.promoservice.entity.Users;
import com.robihidayat.promoservice.exception.ValidationException;
import com.robihidayat.promoservice.model.Modules;
import com.robihidayat.promoservice.model.PromoResponse;
import com.robihidayat.promoservice.repository.UserRepository;
import com.robihidayat.promoservice.service.PromoService;
import com.robihidayat.promoservice.utils.enums.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author robihidayat
 */
@Service
@Slf4j
public class PromoServiceImplement implements PromoService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Gson gson;

    @Override
    public PromoResponse findPromoByUsers(Integer request) {

        Optional<Users> usersOptional = userRepository.findById(new Long(request));

        if (!usersOptional.isPresent()){
            throw new ValidationException(ResponseCode.USER_NOT_FOUND);

        }
        PromoResponse response = new PromoResponse();
        usersOptional.ifPresent(users -> {
            if(!users.getGroups().getModules().isEmpty()){
                response.setModules(gson.fromJson(users.getGroups().getModules(), Modules[].class));
            } else {
                throw new ValidationException(ResponseCode.USER_NOT_MODULES);
            }
        });

        return response;
    }
}
