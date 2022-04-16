package uaslp.objetos.list.linkedList;

class Node <T> {
    T data;
    Node<T> next;
    Node <T> previous;

    Node(T data)
    {
        this.data = data;
    }
}