package com.paysera.lib.ext.jackson.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.joda.money.BigMoney;

import java.io.IOException;

public class BigMoneySerializer extends JsonSerializer<BigMoney> {
    @Override
    public void serialize(
        BigMoney money, JsonGenerator jsonGenerator, SerializerProvider serializerProvider
    ) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("amount", money.getAmount().toPlainString());
        jsonGenerator.writeStringField("currency", money.getCurrencyUnit().getCode());
        jsonGenerator.writeEndObject();
    }
}
