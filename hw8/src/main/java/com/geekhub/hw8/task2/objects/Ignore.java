package com.geekhub.hw8.task2.objects;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation is used by any {@link com.geekhub.hw8.task2.storage.Storage} implementation to identify fields
 * of {@link Entity} that need to be avoided from being stored
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Ignore {
}
