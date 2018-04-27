package com.macquarie.dimension.domain;

import javax.persistence.AttributeConverter;

/**
 * Created by hopeng on 27/4/18.
 */
public abstract class BaseEnumConverter implements AttributeConverter<Enum, String> {

    private Class<? extends Enum> classType;

    public BaseEnumConverter(Class<? extends Enum> classType) {
        this.classType = classType;
    }

    @Override
    public String convertToDatabaseColumn(Enum attribute) {
        return attribute.toString();
    }

    @Override
    public Enum convertToEntityAttribute(String dbData) {
        for (Enum c : classType.getEnumConstants()) {
            if (c.toString().equals(dbData)) {
                return c;
            }
        }
        System.err.println(dbData + " cannot convert to enum");
        return null;
    }
}
