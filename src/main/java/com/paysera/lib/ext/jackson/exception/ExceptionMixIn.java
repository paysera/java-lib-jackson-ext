package com.paysera.lib.ext.jackson.exception;

import com.fasterxml.jackson.annotation.JsonValue;

abstract public class ExceptionMixIn {

    @JsonValue
    abstract public String getMessage();

}
