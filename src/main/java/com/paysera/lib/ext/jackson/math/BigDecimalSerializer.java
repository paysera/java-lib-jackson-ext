package com.paysera.lib.ext.jackson.math;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.math.BigDecimal;

public final class BigDecimalSerializer extends StdSerializer<BigDecimal> {

    public BigDecimalSerializer() {
        super(BigDecimal.class);
    }

    @Override
    public void serialize(BigDecimal number, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {
        jgen.writeString(number.toPlainString());
    }

    @Override
    public JsonNode getSchema(SerializerProvider provider, java.lang.reflect.Type typeHint) {
        return createSchemaNode("string", true);
    }
}