package br.com.rnrafa.entity.utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class BooleanToStringConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        return (attribute != null && attribute) ? "S" : "N";
    }

    @Override
    public Boolean convertToEntityAttribute(String string) {
        return "S".equals(string);
    }
}
