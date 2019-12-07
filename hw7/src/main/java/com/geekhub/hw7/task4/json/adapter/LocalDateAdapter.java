package com.geekhub.hw7.task4.json.adapter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Converts object of type java.time.LocalDate to String by using ISO 8601 format
 */
public class LocalDateAdapter implements JsonDataAdapter<LocalDate> {

    @Override
    public Object toJson(LocalDate date) {
        return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
