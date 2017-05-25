package com.example.accountservice.model.creditcard;

import com.example.accountservice.model.BaseEntity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by pkpk1234 on 2017/5/18.
 */

@Entity
public class CreditCard extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String number;

    @Enumerated(EnumType.STRING)
    private CreditCardType creditCardType;

    public CreditCard() {
    }

    public CreditCard(String number, CreditCardType creditCardType) {
        this.number = number;
        this.creditCardType = creditCardType;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", creditCardType=" + creditCardType +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public CreditCardType getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(CreditCardType creditCardType) {
        this.creditCardType = creditCardType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard that = (CreditCard) o;
        return Objects.equals(number, that.number) &&
                creditCardType == that.creditCardType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, creditCardType);
    }
}
