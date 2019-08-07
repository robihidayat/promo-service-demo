package com.robihidayat.promoservice.repository;

import com.robihidayat.promoservice.entity.Group;
import com.robihidayat.promoservice.entity.Users;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * @author robihidayat
 */
@Slf4j
@RunWith(SpringRunner.class)
public class GroupRepositoryTest {

    @Mock
    private UserRepository userRepository;


    @Mock
    private GroupRepository groupRepository;

    @Before
    public void setUp() throws Exception {

        log.info("startup");
        Users usersOne = new Users();
        usersOne.setId(1L);
        usersOne.setName("user one");
        usersOne.setEmail("userone@gmail.com");

        Users usersTwo = new Users();
        usersTwo.setId(2L);
        usersTwo.setName("user two");
        usersTwo.setEmail("usertwo@gmail.com");


        Group group = new Group();
        group.setModules("modules");
        group.setGroupName("groupOne");
        List<Users> listUser = new LinkedList<>();
        listUser.add(usersOne);
        listUser.add(usersTwo);


//        group.setUsers(listUser);

        usersOne.setGroups(group);
        usersTwo.setGroups(group);
        userRepository.save(usersOne);
        userRepository.save(usersTwo);
        groupRepository.save(group);



        when(userRepository.findByName("user two")).thenReturn(usersOne);
        when(userRepository.findByEmail("usertwo@gmail.com")).thenReturn(usersOne);

        when(userRepository.findByName("user one")).thenReturn(usersOne);
        when(userRepository.findByEmail("userone@gmail.com")).thenReturn(usersOne);

        when(groupRepository.findByGroupName("groupOne")).thenReturn(group);

    }


    @Test
    public void findGroupByUsers() {
       Group group =  groupRepository.findByGroupName("groupOne");
       assertNotNull(group);
//       assertNotNull(group.getUsers());

//        for (Users user: group.getUsers()) {
//            assertNotNull(user);
//        }
    }
}