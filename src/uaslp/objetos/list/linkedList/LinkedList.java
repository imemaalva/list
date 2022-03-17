package uaslp.objetos.list.linkedList;
import uaslp.objetos.list.List;

public class LinkedList <T> implements List <T>{
    private Node <T> head;
    private Node <T> tail;
    private int size;

    @Override
    public void addAtTail(T data) {
        Node <T> node = new Node<>(data);

        if (size == 0) {
            head = node;
        } else {
            tail.next = node;
            node.previous = tail;
        }

        tail = node;
        size++;
    }

    @Override
    public void addAtFront(T data) {
        Node <T> node = new Node<>(data);

        if (size == 0) {
            tail = node;
        } else {
            head.previous = node;
        }
        node.next = head;
        head = node;

        size++;
    }

    @Override
    public void remove(int index) {
        Node <T> node = findNode(index);

        if (node == null) {
            return;
        }

        if (size == 1) {
            head = null;
            tail = null;
        } else if (node == head) {
            head = node.next;
            if (head != null) {
                head.previous = null;
            }
        } else if (node == tail) {
            tail = node.previous;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }
        size--;
    }

    @Override
    public void removeAll() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public T getAt(int index) {
        Node <T> node = findNode(index);

        return node == null ? null : node.data;
    }

    @Override
    public void setAt(int index, T data) {
        Node <T> node = findNode(index);

        if (node != null) {
            node.data = data;
        }
    }

    private Node findNode(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node <T> node = head;
        int currentIndex = 0;

        while (currentIndex != index) {
            currentIndex++;
            node = node.next;
        }

        return node;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public LinkedListIterator getIterator() {
        return new LinkedListIterator(head);
    }
}