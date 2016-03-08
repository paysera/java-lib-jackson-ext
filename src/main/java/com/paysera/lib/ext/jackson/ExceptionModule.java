package com.paysera.lib.ext.jackson;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.paysera.lib.ext.jackson.exception.ExceptionMixIn;

public class ExceptionModule extends SimpleModule {

    public ExceptionModule() {
        super("Exception", new Version(1, 0, 0, null));
    }

    @Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(Exception.class, ExceptionMixIn.class);
    }

}
