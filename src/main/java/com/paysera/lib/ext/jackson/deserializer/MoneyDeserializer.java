package com.paysera.lib.ext.jackson.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class MoneyDeserializer extends JsonDeserializer<Money> {
    private RoundingMode roundingMode;

    public MoneyDeserializer(RoundingMode roundingMode) {
        this.roundingMode = roundingMode;
    }

    @Override
    public Money deserialize(
        JsonParser jsonParser, DeserializationContext deserializationContext
    ) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = jsonParser.getCodec();
        JsonNode node = objectCodec.readTree(jsonParser);

        String currency = node.get("currency").asText();
        String amount = node.get("amount").asText();

        return Money.of(
            CurrencyUnit.of(currency),
            new BigDecimal(amount),
            this.roundingMode
        );
    }
}
