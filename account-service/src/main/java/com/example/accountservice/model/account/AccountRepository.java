package com.example.accountservice.model.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pkpk1234 on 2017/5/18.
 */

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
}
