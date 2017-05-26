package com.paysera.lib.ext.jackson;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.paysera.lib.ext.jackson.deserializer.MoneyDeserializer;
import com.paysera.lib.ext.jackson.serializer.BigMoneySerializer;
import com.paysera.lib.ext.jackson.serializer.MoneySerializer;

import org.joda.money.BigMoney;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.math.RoundingMode;

public class JodaMoneyModule extends SimpleModule {
    private RoundingMode moneyDeserializationRoundingMode = RoundingMode.HALF_UP;

    public JodaMoneyModule() {
        super("JodaMoney", new Version(1, 0, 0, null));
    }

    public JodaMoneyModule(RoundingMode moneyDeserializationRoundingMode) {
        this();
        this.moneyDeserializationRoundingMode = moneyDeserializationRoundingMode;
    }

    @Override
    public void setupModule(SetupContext context) {
        this.addDeserializer(Money.class, new MoneyDeserializer(this.moneyDeserializationRoundingMode));
        this.addSerializer(Money.class, new MoneySerializer());
        this.addSerializer(BigMoney.class, new BigMoneySerializer());

        context.addDeserializers(this._deserializers);
        context.addSerializers(this._serializers);

        context.setMixInAnnotations(BigMoney.class, BigMoneyMixIn.class);
        context.setMixInAnnotations(CurrencyUnit.class, CurrencyUnitMixIn.class);
    }

}
