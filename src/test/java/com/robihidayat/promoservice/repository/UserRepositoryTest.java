package com.robihidayat.promoservice.repository;

import com.robihidayat.promoservice.entity.Users;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.when;

/**
 * @author robihidayat
 */
@Slf4j
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Mock
    private UserRepository userRepository;

    @Before
    public void init() {
        log.info("startup");
        Users users = new Users();
        users.setId(1L);
        users.setName("robi hidayat");
        users.setEmail("robihidayat122@gmail.com");
        userRepository.save(users);
        when(userRepository.findByName("robi hidayat")).thenReturn(users);
        when(userRepository.findByEmail("robihidayat122@gmail.com")).thenReturn(users);


    }

    @Test
    public void testCreateFindByName(){

        Users userTest = userRepository.findByName("robi hidayat");
        assertNotNull(userTest);
        assertNotNull(userTest.getEmail());
        assertNotNull(userTest.getName());

        assertEquals(userTest.getName(), "robi hidayat");
        assertEquals(userTest.getEmail(), "robihidayat122@gmail.com");

        assertEquals(userTest.getId().longValue(), 1L);

    }


    @Test
    public void testCreateFindByEmail(){

        Users userTest = userRepository.findByEmail("robihidayat122@gmail.com");
        assertNotNull(userTest);
        assertNotNull(userTest.getEmail());
        assertNotNull(userTest.getName());

        assertEquals(userTest.getName(), "robi hidayat");
        assertEquals(userTest.getEmail(), "robihidayat122@gmail.com");

        assertEquals(userTest.getId().longValue(), 1L);

    }





}
