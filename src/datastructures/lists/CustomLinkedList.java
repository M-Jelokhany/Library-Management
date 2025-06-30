package datastructures.lists;

import datastructures.interfaces.LinkedList;

import java.util.NoSuchElementException;

public class CustomLinkedList<T> implements LinkedList<T> {
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head, tail;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(Object t) {
        addLast((T) t);
        return true;
    }


    @Override
    public boolean contains(Object o) {
        if (o == null) {
            throw new NullPointerException("Cannot check for null element");
        }
        Node<T> current = head;
        while (current != null) {
            if (o.equals(current.data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            throw new NullPointerException("Cannot remove null element");
        }
        Node<T> current = head;
        while (current != null) {
            if (o.equals(current.data)) {
                if (current == head) {
                    removeFirst();
                }
                else if (current == tail) {
                    removeLast();
                }
                else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    size--;
                }
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public Object set(int index, Object element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (element == null) {
            throw new NullPointerException("Cannot set null element");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.data = (T) element;
        return element;
    }

    @Override
    public void addFirst(T t) {
        if (t == null) {
            throw new NullPointerException("Cannot add null element");
        }
        Node<T> newNode = new Node<>(t);
        if (isEmpty()) {
            head = tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T t) {
        if (t == null) {
            throw new NullPointerException("Cannot add null element");
        }
        Node<T> newNode = new Node<>(t);
        if (isEmpty()) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        T data = head.data;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        } else {
            head.prev = null;
        }
        return data;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        T data = tail.data;
        tail = tail.prev;
        size--;
        if (isEmpty()) {
            head = null;
        } else {
            tail.next = null;
        }
        return data;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return head.data;
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return tail.data;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }
}