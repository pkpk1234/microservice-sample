package com.example.accountservice;

import com.example.accountservice.model.account.Account;
import com.example.accountservice.model.address.Address;
import com.example.accountservice.model.address.AddressType;
import com.example.accountservice.model.creditcard.CreditCard;
import com.example.accountservice.model.creditcard.CreditCardType;
import com.example.accountservice.model.customer.Customer;
import com.example.accountservice.model.customer.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

import java.time.*;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AccountServiceApplicationTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Before
    public void initSampleData() {
        Address address1 = new Address("jinniu", "yinbingdadao", "sichuan", "chengdu", 610000, AddressType.BILLING);
        Address address2 = new Address("jinniu", "shuyuelu", "sichuan", "chengdu", 610000, AddressType.SHPPING);
        Address address3 = new Address("jinniu", "shuhanlu", "sichuan", "chengdu", 610000, AddressType.BILLING);

        CreditCard masterCard = new CreditCard("123456", CreditCardType.MASTERCARD);
        CreditCard vtsaCard = new CreditCard("321654",CreditCardType.VISA);

        Account account1 = new Account("account1");
        account1.addAddress(address1);
        account1.addAddress(address2);
        account1.addAddress(address3);

        account1.addCreditCard(masterCard);
        account1.addCreditCard(vtsaCard);

        Customer customer1 = new Customer("li","Jiaming","lijiaming1984@gmail.com",account1);

        this.customerRepository.save(customer1);

    }

    @Test
    public void test() {
        List<Customer> customers = this.customerRepository.findAll();
        assertEquals(1,customers.size());
        Customer customer1 = customers.get(0);
        final Long createAt = customer1.getCreateAt();
        assertNotNull(createAt);
        LocalDate createdDateTime =
                Instant.ofEpochMilli(createAt).atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDateTime now = LocalDateTime.now();
        assertEquals(now.getYear(),createdDateTime.getYear());
        assertEquals(now.getMonth().getValue(),createdDateTime.getMonth().getValue());
        assertEquals(now.getDayOfMonth(),createdDateTime.getDayOfMonth());

        assertNotNull(customer1.getLastModifiedAt());
        LocalDate lastModifiedDateTime =
                Instant.ofEpochMilli(createAt).atZone(ZoneId.systemDefault()).toLocalDate();
        assertEquals(now.getYear(),lastModifiedDateTime.getYear());
        assertEquals(now.getMonth().getValue(),lastModifiedDateTime.getMonth().getValue());
        assertEquals(now.getDayOfMonth(),lastModifiedDateTime.getDayOfMonth());

        Account account = customer1.getAccount();
        assertEquals(3,account.getAddresses().size());

        log.info("customer1: {}",customer1);

    }

}
