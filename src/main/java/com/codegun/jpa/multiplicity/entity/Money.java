package com.codegun.jpa.multiplicity.entity;

import com.codegun.jpa.multiplicity.enumType.Currency;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;


@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class Money {
    private int amount;
    private Currency currency;

    public Money(int amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public int amount(){
        return this.amount;
    }

    public Currency currency(){
        return this.currency;
    }
}
