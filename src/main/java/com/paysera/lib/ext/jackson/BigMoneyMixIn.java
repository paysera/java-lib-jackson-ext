package com.paysera.lib.ext.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.joda.money.BigMoney;
import org.joda.money.CurrencyUnit;

import java.math.BigDecimal;

@JsonPropertyOrder({"amount", "currency"})
@JsonIgnoreProperties({
    "zero",
    "negative",
    "scale",
    "amountMajor", "amount_major",
    "amountMajorLong", "amount_major_long",
    "amountMajorInt", "amount_major_int",
    "amountMinor", "amount_minor",
    "amountMinorLong", "amount_minor_long",
    "amountMinorInt", "amount_minor_int",
    "minorPart", "minor_part",
    "positive",
    "positiveOrZero", "positive_or_zero",
    "negativeOrZero", "negative_or_zero",
    "currencyScale", "currency_scale"
})
public abstract class BigMoneyMixIn {

    @JsonProperty("amount")
    abstract BigDecimal getAmount();

    @JsonProperty("currency")
    abstract CurrencyUnit getCurrencyUnit();

    @JsonCreator
    static public BigMoney of(@JsonProperty("currency") CurrencyUnit currencyUnit, @JsonProperty("amount") BigDecimal amount) {
        return BigMoney.of(currencyUnit, amount);
    }

}
