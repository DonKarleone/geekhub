package com.geekhub.hw7.task4.json.adapter;

import com.geekhub.hw7.task4.json.JsonSerializer;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.Collection;

/**
 * Converts all objects that extends java.util.Collections to JSONArray.
 */
public class CollectionAdapter implements JsonDataAdapter<Collection> {

    @Override
    public Object toJson(Collection c) throws JSONException {
        JSONArray result = new JSONArray();
        for (Object o : c) {
            result.put(JsonSerializer.serialize(o));
        }
        return result;
    }
}
