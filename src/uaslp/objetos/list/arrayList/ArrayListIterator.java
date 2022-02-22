package uaslp.objetos.list.arrayList;

public class ArrayListIterator {

    private uaslp.objetos.list.arrayList.ArrayList arrayList;
    private int currentItem;

    public  ArrayListIterator(uaslp.objetos.list.arrayList.ArrayList arrayList) {
        this.arrayList = arrayList;
    }

    public boolean hasNext() {
        return currentItem < arrayList.getSize();
    }

    public String next() {
        String data = arrayList.getAt(currentItem);

        currentItem++;

        return data;
    }
}
