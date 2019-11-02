package com.geekhub.hw4.list.linked;

import java.util.Iterator;

class LinkedListIterator<E> implements Iterator<E> {

    private Node<E> head;

    LinkedListIterator(Node<E> head) {
        this.head = head;
    }

    @Override
    public boolean hasNext() {
        return head != null;
    }

    @Override
    public E next() {
        Node<E> node = this.head;
        this.head = node.next;
        return node.element;
    }
}
