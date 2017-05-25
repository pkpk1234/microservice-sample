package com.example.accountservice.model;

import com.example.accountservice.model.account.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
/**
 * Created by pkpk1234 on 2017/5/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(profiles = {"development"})
public class TestAccountRepository {
    @Autowired
    AccountRepository accountRepository;

    @Test
    public void testConfigSuccess() {
        assertTrue(this.accountRepository.count() == 0);
    }
}
