package com.paysera.lib.ext.jackson;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import com.paysera.lib.ext.jackson.math.BigDecimalSerializer;


public class BigDecimalModule extends SimpleModule {

    public BigDecimalModule() {
        super("BigDecimal", new Version(1, 0, 0, null));
    }

    @Override
    public void setupModule(SetupContext context) {
        SimpleSerializers s = new SimpleSerializers();
        s.addSerializer(new BigDecimalSerializer());
        context.addSerializers(s);
    }


}
