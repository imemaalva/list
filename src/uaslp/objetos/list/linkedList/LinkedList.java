package uaslp.objetos.list.linkedList;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;



    public void addAtTail(String data){
        Node node = new Node(data);

        if(size == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
        }
        tail = node;
        size ++;
    }

    public void addAtFront(String data){
        Node node = new Node(data);

        if(size == 0){
            tail = node;
        } else {
            head.previous = node;
        }
        node.next = head;
        head = node;

        size ++;
    }

    public void remove(int index){
        Node node = findNode(index);

        if(node == null){
            return;
        }

        if(size == 1){
            head = null;
            tail = null;
        } else if(node == head){
            head = node.next;
            if(head != null){
                head.previous = null;
            }
        } else if(node == tail){
            tail = node.previous;
            if(tail != null){
                tail.next = null;
            }
        } else {
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }
        size--;
    }

    public void removeAll(){
        head = null;
        tail = null;
        size = 0;

    }
    public void setAt(int index, String data){
        Node node = findNode(index);

        if(node != null){
            node.data = data;
        }
    }

    public String getAt(int index) {
        Node node = findNode(index);

        return node == null ? null : node.data;
    }

    public LinkedListIterator getIterator(){
        return new LinkedListIterator(head);
    }

    public int getSize(){
        return size;
    }

    private Node findNode(int index){

        if(index < 0 || index >= size){
            return null;
        }

        Node node = head;
        int currentIndex = 0;

        while (currentIndex != index){
            currentIndex++;
            node = node.next;
        }
        return node;
    }
}
