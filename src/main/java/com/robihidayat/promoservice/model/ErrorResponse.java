package com.robihidayat.promoservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

/**
 * @author robihidayat
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse<T> {
    private List<T> errors = new ArrayList<>(1);

    public ErrorResponse(List<T> errors) {
        this.errors = errors;
    }

    public List<T> getErrors() {
        return errors;
    }
}