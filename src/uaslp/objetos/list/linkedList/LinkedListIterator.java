package uaslp.objetos.list.linkedList;

public class LinkedListIterator {

    private Node currentNode;

    LinkedListIterator(Node startNode){
        currentNode = startNode;
    }

    public boolean hasNext(){
        return currentNode != null;
    }

    public String next(){
        String data = currentNode.data;

        currentNode = currentNode.next;

        return data;
    }
}

