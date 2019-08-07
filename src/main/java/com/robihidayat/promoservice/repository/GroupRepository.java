package com.robihidayat.promoservice.repository;

import com.robihidayat.promoservice.entity.Group;
import com.robihidayat.promoservice.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author robihidayat
 */
@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    Group findGroupByUsers(Users users);

    Group findByGroupName(String name);



}
