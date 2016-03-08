package com.paysera.lib.ext.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.joda.money.CurrencyUnit;

public abstract class CurrencyUnitMixIn {

    @JsonValue
    abstract String getCode();

    @JsonCreator
    static public CurrencyUnit getInstance(String code) {
        return CurrencyUnit.getInstance(code);
    }

}
