package com.api.movies.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum GenderEnum {
    MAN("M", "MAN"),
    WOMAN("W", "WOMAN"),
    OTHER("O", "OTHER");

    private final String longName;
    private final String shortName;

    GenderEnum(String shortName, String longName) {
        this.shortName = shortName;
        this.longName = longName;
    }

    public char getShortName() {
        return shortName.charAt(0);
    }

    @JsonCreator
    public static GenderEnum fromValue(String value) {
        for (GenderEnum gender : values()) {
            if (gender.longName.equalsIgnoreCase(value) || gender.shortName.equalsIgnoreCase(value)) {
                return gender;
            }
        }
        throw new IllegalArgumentException("Invalid gender: " + value);
    }
}
