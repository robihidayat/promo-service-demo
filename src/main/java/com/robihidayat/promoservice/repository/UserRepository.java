package com.robihidayat.promoservice.repository;

import com.robihidayat.promoservice.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author robihidayat
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByName(String name);

    Users findByEmail(String email);

}
