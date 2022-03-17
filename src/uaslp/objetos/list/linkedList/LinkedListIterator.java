package uaslp.objetos.list.linkedList;
import uaslp.objetos.list.Iterator;

public class LinkedListIterator <T> implements Iterator <T> {

    private Node<T> currentNode;

    LinkedListIterator(Node startNode){
        currentNode=startNode;
    }

    public boolean hasNext(){
        return currentNode != null;
    }

    public T next(){
        T data= currentNode.data;

        currentNode=currentNode.next;

        return data;
    }
}