package com.geekhub.hw4.list;

public interface List<E> extends Iterable<E> {

    boolean add(E element);

    boolean add(int index, E element);

    boolean addAll(List<E> elements);

    boolean addAll(int index, List<E> elements);

    boolean clear();

    E remove(int index);

    E remove(E element);

    E get(int index);

    int size();

    boolean isEmpty();

    int indexOf(E element);

    boolean contains(E element);
}
