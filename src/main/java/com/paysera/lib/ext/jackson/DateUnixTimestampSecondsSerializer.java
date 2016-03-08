package com.paysera.lib.ext.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.lang.Override;import java.util.Date;

public class DateUnixTimestampSecondsSerializer extends JsonSerializer<Date> {
    @Override
    public void serialize(
        Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider
    ) throws IOException, JsonProcessingException {
        jsonGenerator.writeNumber(date.getTime() / 1000);
    }
}