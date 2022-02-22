package uaslp.objetos.list.arrayList;


public class ArrayList {

    private static final int DEFAULT_SIZE = 2;
    private String[] array;
    private int size;

    public ArrayList(){
        array = new String[DEFAULT_SIZE];
    }

    public ArrayList(int size){
        array = new String[size];
    }

    public void addAtTail(String data){

        if(size == array.length){
            increaseArraySize();
        }

        this.array[size] = data;
        size++;
    }

    public void addAtFront(String data){

        if(size == array.length){
            increaseArraySize();
        }

        if(size >= 0) {
            System.arraycopy(array, 0, array, 1, size);
        }
        array[0] = data;
        size++;
    }

    public void remove(int index){

        if(index < 0 || index >= size){
            return;
        }
        if (size - 1 - index >= 0){
            System.arraycopy(array, index + 1, array, index, size - 1 - index);
        }
        array[size - 1] = null;
        size--;

    }

    public void removeAll(){
        for(int i = 0; i < size; i++){
            array[i] = null;
        }
        size = 0;

    }

    public void setAt(int index, String data){
        if(index >= 0 && index < size){
            array[index] = data;
        }

    }

    public String getAt(int index) {
        return index >= 0 && index < size ? array[index] : null;
    }

    public ArrayListIterator getIterator(){
        return new ArrayListIterator(this);
    }

    public int getSize(){
        return size;
    }

    private void increaseArraySize(){
        String []newArray = new String[array.length * 2];

        for(int i = 0; i < size; i++){
            newArray[i] = array[i];
        }

        array = newArray;
    }

}
