package com.paysera.lib.ext.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonContextResolver implements ContextResolver<ObjectMapper> {

    private ObjectMapper objectMapper;

    public JacksonContextResolver(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ObjectMapper getContext(Class<?> type) {
        return objectMapper;
    }
}
