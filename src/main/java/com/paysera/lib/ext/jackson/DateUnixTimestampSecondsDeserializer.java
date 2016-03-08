package com.paysera.lib.ext.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.lang.Long;import java.lang.Override;import java.lang.String;import java.util.Date;

public class DateUnixTimestampSecondsDeserializer extends JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
        throws IOException {
        String timestamp = jsonParser.getText().trim();

        return new Date(Long.valueOf(timestamp + "000"));
    }
}