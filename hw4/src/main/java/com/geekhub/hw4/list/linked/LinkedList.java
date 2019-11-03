package com.geekhub.hw4.list.linked;

import com.geekhub.hw4.list.List;

import java.util.Iterator;

public class LinkedList<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;

    private int size = 0;

    @Override
    public boolean add(E element) {
        Node<E> node = new Node<>(element, null);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(int index, E element) {
        if (index >= 0 && index <= size) {
            if (size == 0) {
                add(element);
                return true;
            }
            Node<E> node = new Node<>(element, null);
            if (head == tail) {
                if (index == 0) {
                    head = node;
                    head.next = tail;
                } else {
                    add(element);
                    return true;
                }
            } else {
                Node<E> prevNode = head;
                Node<E> currNode = head.next;
                int counter = 1;
                while (counter < index) {
                    prevNode = currNode;
                    currNode = currNode.next;
                    counter++;
                }
                if (index == size) {
                    tail.next = node;
                    tail = node;
                } else if (index == 0) {
                    head = node;
                    node.next = prevNode;
                } else {
                    prevNode.next = node;
                    node.next = currNode;
                }
            }
            size++;
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(List<E> elements) {
        for (E element : elements) {
            add(element);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, List<E> elements) {
        if (elements.size() == 0)
            return false;
        if (index >= 0 && index <= size) {
            if (size == 0) {
                addAll(elements);
                return true;
            }
            for (int i = 0; i < elements.size(); i++) {
                add(index, elements.get(i));
                index++;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean clear() {
        for (Node<E> node = head; node != null; ) {
            Node<E> next = node.next;
            node.next = null;
            node = next;
        }
        head = tail = null;
        size = 0;
        return false;
    }

    @Override
    public E remove(int index) {
        E removedElement = null;
        if (index >= 0 && index <= size) {
            if (index == 0) {
                if (head == tail) {
                    removedElement = head.element;
                    tail = null;
                }
                head = head.next;
            } else {
                Node<E> prevNode = head;
                Node<E> currNode = head.next;
                int counter = 1;
                while (counter < index) {
                    prevNode = currNode;
                    currNode = currNode.next;
                    counter++;
                }
                if (currNode == tail) {
                    tail = prevNode;
                }
                removedElement = currNode.element;
                prevNode.next = currNode.next;
            }
        }
        size--;
        return removedElement;
    }

    @Override
    public E remove(E element) {
        if (head == null) {
            return null;
        }
        if (head.element.equals(element)) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
            }
            size--;
            return element;
        }
        Node<E> prevNode = head;
        Node<E> currNode = head.next;
        while (currNode != null) {
            if (currNode.element.equals(element)) {
                if (currNode == tail) {
                    tail = prevNode;
                }
                prevNode.next = currNode.next;
                size--;
                return element;
            }
            prevNode = currNode;
            currNode = currNode.next;
        }
        return null;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = head;
        int counter = 0;
        while (counter < index) {
            node = node.next;
            counter++;
        }
        return node.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int indexOf(E element) {
        int index = 0;
        Node<E> currNode = head;
        while (currNode != null) {
            if (element.equals(currNode.element)) {
                return index;
            }
            index++;
            currNode = currNode.next;
        }
        return -1;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator<>(head);
    }

    public void print() {
        Node node = head;
        while (node != null) {
            System.out.print(node.element + " ");
            node = node.next;
        }
    }
}
