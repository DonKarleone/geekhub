package com.geekhub.hw7.task4.json.adapter;

import com.geekhub.hw7.task4.json.JsonSerializer;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

/**
 * Converts all objects that extends java.util.Map to JSONObject.
 */
public class MapAdapter implements JsonDataAdapter<Map> {

    @Override
    public Object toJson(Map map) throws JSONException {
        JSONObject result = new JSONObject();
        for (Object o : map.keySet()) {
            result.put(o.toString(), JsonSerializer.serialize(map.get(o)));
        }
        return result;
    }
}
