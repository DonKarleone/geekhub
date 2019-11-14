package com.geekhub.hw5.task3;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class CollectionUtils {

    private CollectionUtils() {
    }

    public static <E> List<E> generate(Supplier<E> generator,
                                       Supplier<List<E>> listFactory,
                                       int count) {
        List<E> newList = listFactory.get();
        for (int i = 0; i < count; i++) {
            newList.add(generator.get());
        }
        return newList;
    }

    public static <E> List<E> filter(List<E> elements, Predicate<E> filter) {
        List<E> newList = new ArrayList<>();
        for (E e : elements) {
            if (filter.test(e)) {
                newList.add(e);
            }
        }
        return newList;
    }

    public static <E> boolean anyMatch(List<E> elements, Predicate<E> predicate) {
        for (E e : elements) {
            if (predicate.test(e)) {
                return true;
            }
        }
        return false;
    }

    public static <E> boolean allMatch(List<E> elements, Predicate<E> predicate) {
        for (E e : elements) {
            if (!predicate.test(e)) {
                return false;
            }
        }
        return true;
    }

    public static <E> boolean noneMatch(List<E> elements, Predicate<E> predicate) {
        for (E e : elements) {
            if (predicate.test(e)) {
                return false;
            }
        }
        return true;
    }

    public static <T, R> List<R> map(List<T> elements,
                                     Function<T, R> mappingFunction,
                                     Supplier<List<R>> listFactory) {
        List<R> newList = listFactory.get();
        for (T e : elements) {
            newList.add(mappingFunction.apply(e));
        }
        return newList;
    }

    public static <E> Optional<E> max(List<E> elements, Comparator<E> comparator) {
        if (elements.isEmpty()) {
            return Optional.empty();
        } else {
            Iterator<E> elementsIterator = elements.iterator();
            E maxElement = elementsIterator.next();
            while (elementsIterator.hasNext()) {
                E e = elementsIterator.next();
                if (comparator.compare(maxElement, e) < 0) {
                    maxElement = e;
                }
            }
            return Optional.of(maxElement);
        }
    }

    public static <E> Optional<E> min(List<E> elements, Comparator<E> comparator) {
        if (elements.isEmpty()) {
            return Optional.empty();
        } else {
            Iterator<E> elementsIterator = elements.iterator();
            E minElement = elementsIterator.next();
            while (elementsIterator.hasNext()) {
                E e = elementsIterator.next();
                if (comparator.compare(minElement, e) > 0) {
                    minElement = e;
                }
            }
            return Optional.of(minElement);
        }
    }

    public static <E> List<E> distinct(List<E> elements, Supplier<List<E>> listFactory) {
        List<E> newList = listFactory.get();
        for (E e : elements) {
            if (!newList.contains(e)) {
                newList.add(e);
            }
        }
        return newList;
    }

    public static <E> void forEach(List<E> elements, Consumer<E> consumer) {
        for (E e : elements) {
            consumer.accept(e);
        }
    }

    public static <E> Optional<E> reduce(List<E> elements, BinaryOperator<E> accumulator) {
        if (elements.isEmpty())
            return Optional.empty();
        E result = null;
        for (E e : elements) {
            if (result == null) {
                result = e;
            } else {
                result = accumulator.apply(result, e);
            }
        }
        return Optional.of(result);
    }

    public static <E> E reduce(E seed, List<E> elements, BinaryOperator<E> accumulator) {
        E result = seed;
        for (E e : elements) {
            result = accumulator.apply(result, e);
        }
        return result;
    }

    public static <E> Map<Boolean, List<E>> partitionBy(List<E> elements,
                                                        Predicate<E> predicate,
                                                        Supplier<Map<Boolean, List<E>>> mapFactory,
                                                        Supplier<List<E>> listFactory) {
        Map<Boolean, List<E>> newMap = mapFactory.get();
        newMap.put(true, listFactory.get());
        newMap.put(false, listFactory.get());
        for (E e : elements) {
            newMap.get(predicate.test(e)).add(e);
        }
        return newMap;
    }

    public static <T, K> Map<K, List<T>> groupBy(List<T> elements,
                                                 Function<T, K> classifier,
                                                 Supplier<Map<K, List<T>>> mapFactory,
                                                 Supplier<List<T>> listFactory) {
        Map<K, List<T>> newMap = mapFactory.get();
        for (T e : elements) {
            K key = classifier.apply(e);
            if (!newMap.containsKey(key)) {
                newMap.put(key, listFactory.get());
            }
            newMap.get(key).add(e);
        }
        return newMap;
    }

    public static <T, K, U> Map<K, U> toMap(List<T> elements,
                                            Function<T, K> keyFunction,
                                            Function<T, U> valueFunction,
                                            BinaryOperator<U> mergeFunction,
                                            Supplier<Map<K, U>> mapFactory) {
        Map<K, U> newMap = mapFactory.get();
        for (T e : elements) {
            K key = keyFunction.apply(e);
            U value = valueFunction.apply(e);
            if (newMap.containsKey(key)) {
                value = mergeFunction.apply(value, newMap.get(key));
            }
            newMap.put(key, value);
        }
        return newMap;
    }

    public static <E, T> Map<Boolean, List<T>> partitionByAndMapElement(List<E> elements,
                                                                        Predicate<E> predicate,
                                                                        Supplier<Map<Boolean, List<T>>> mapFactory,
                                                                        Supplier<List<T>> listFactory,
                                                                        Function<E, T> elementMapper) {
        Map<Boolean, List<T>> newMap = mapFactory.get();
        newMap.put(true, listFactory.get());
        newMap.put(false, listFactory.get());
        for (E e : elements) {
            newMap.get(predicate.test(e)).add(elementMapper.apply(e));
        }
        return newMap;
    }

    public static <T, U, K> Map<K, List<U>> groupByAndMapElement(List<T> elements,
                                                                 Function<T, K> classifier,
                                                                 Supplier<Map<K, List<U>>> mapFactory,
                                                                 Supplier<List<U>> listFactory,
                                                                 Function<T, U> elementMapper) {
        Map<K, List<U>> newMap = mapFactory.get();
        for (T e : elements) {
            K key = classifier.apply(e);
            if (!newMap.containsKey(key)) {
                newMap.put(key, listFactory.get());
            }
            newMap.get(key).add(elementMapper.apply(e));
        }
        return newMap;
    }
}
