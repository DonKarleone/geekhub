package com.geekhub.hw7.task4.json;

import org.json.JSONObject;
import com.geekhub.hw7.task4.json.adapter.UseDataAdapter;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * JsonSerializer converts Java objects to JSON representation.
 */
public class JsonSerializer {

    /**
     * simpleTypes contains java classes for which we should not make any deeper serialization and we should return object as is
     * and use toString() method to get it serialized representation
     */
    private static Set<Class> simpleTypes = Set.of(
            String.class,
            Integer.class,
            Short.class,
            Long.class,
            Byte.class,
            Double.class,
            Float.class,
            Character.class,
            Boolean.class,
            int.class,
            short.class,
            long.class,
            byte.class,
            double.class,
            float.class,
            char.class,
            boolean.class
    );

    /**
     * Main method to convert Java object to JSON. If type of the object is part of the simpleTypes object itself will be returned.
     * If object is null String value "null" will be returned.
     *
     * @param o object to serialize.
     * @return JSON representation of the object.
     */
    public static Object serialize(Object o) {
        if (null == o) {
            return "null";
        }
        if (simpleTypes.contains(o.getClass())) {
            return o;
        } else {
            try {
                return toJsonObject(o);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /**
     * Converts Java object to JSON. Uses reflection to access object fields.
     * Uses JsonDataAdapter to serialize complex values. Ignores @Ignore annotated fields.
     *
     * @param o object to serialize to JSON
     * @return JSON object.
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private static JSONObject toJsonObject(Object o) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        JSONObject result = new JSONObject();
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getAnnotation(Ignore.class) != null) {
                continue;
            } else if (field.getAnnotation(UseDataAdapter.class) != null) {
                UseDataAdapter annotation = field.getAnnotation(UseDataAdapter.class);
                result.put(field.getName(), annotation.value().getConstructor().newInstance().toJson(field.get(o)));
            } else {
                result.put(field.getName(), field.get(o));
            }
            field.setAccessible(false);
        }
        return result;
    }
}
