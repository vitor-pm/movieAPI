package com.api.movies.converters;

import com.api.movies.enums.GenderEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<GenderEnum, Character> {
    @Override
    public Character convertToDatabaseColumn(GenderEnum attribute) {
        return attribute.getShortName();
    }

    @Override
    public GenderEnum convertToEntityAttribute(Character dbData) {
        return GenderEnum.fromValue(dbData.toString());
    }
}
