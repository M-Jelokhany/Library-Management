package datastructures.queues;

import datastructures.interfaces.Queue;
import datastructures.lists.CustomLinkedList;

public class CustomQueue<T> implements Queue<T> {
    private CustomLinkedList<T> list;

    public CustomQueue() {
        list = new CustomLinkedList<>();
    }

    @Override
    public boolean add(Object t) {
        if (t == null) {
            throw new NullPointerException("Cannot add null element");
        }
        try {
            list.addLast((T) t);
            return true;
        } catch (IllegalStateException e) {
            throw new IllegalStateException("Queue is full");
        }
    }

    @Override
    public boolean offer(Object t) {
        if (t == null) {
            return false;
        }
        try {
            list.addLast((T) t);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public T remove() {
        try {
            return list.removeFirst();
        }
        catch (java.util.NoSuchElementException e) {
            throw new java.util.NoSuchElementException("Queue is empty");
        }
    }

    @Override
    public T poll() {
        if (list.isEmpty()) {
            return null;
        }
        return list.removeFirst();
    }

    @Override
    public T element() {
        try {
            return list.getFirst();
        }
        catch (java.util.NoSuchElementException e) {
            throw new java.util.NoSuchElementException("Queue is empty");
        }
    }

    @Override
    public T peek() {
        if (list.isEmpty()) {
            return null;
        }
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }
}