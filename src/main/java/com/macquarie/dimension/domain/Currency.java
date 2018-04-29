package com.macquarie.dimension.domain;

import javax.persistence.Converter;

/**
 * Created by hopeng on 27/4/18.
 */
public enum  Currency {
    AUD,
    USD,
    NZD,
    EUR,
    GBP;

    public String description = name().toLowerCase();

    @Override
    public String toString() {
        return description;
    }

    @Converter(autoApply = true)
    public static class CurrencyConverter extends BaseEnumConverter {
        public CurrencyConverter() {
            super(Currency.class);
        }
    }
}
