package com.paysera.lib.ext.jackson.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.joda.money.Money;

import java.io.IOException;

public class MoneySerializer extends JsonSerializer<Money> {
    @Override
    public void serialize(
        Money money, JsonGenerator jsonGenerator, SerializerProvider serializerProvider
    ) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("amount", money.getAmount().toPlainString());
        jsonGenerator.writeStringField("currency", money.getCurrencyUnit().getCode());
        jsonGenerator.writeEndObject();
    }
}
