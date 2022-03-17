package uaslp.objetos.list.arrayList;
import uaslp.objetos.list.Iterator;

public class ArrayListIterator implements Iterator{

    private final ArrayList arrayList;
    private int currentItem;

    public ArrayListIterator(ArrayList arrayList){
        this.arrayList=arrayList;
    }

    @Override
    public boolean hasNext(){
        return currentItem < arrayList.getSize() ;
    }

    @Override
    public String next(){
        String data=arrayList.getAt(currentItem);
        currentItem++;
        return data;
    }
}

