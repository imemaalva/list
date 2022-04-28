package uaslp.objetos.list.hashSet;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.Set;
import uaslp.objetos.list.arrayList.ArrayList;
import uaslp.objetos.list.exception.NotNullValuesAllowedException;
import uaslp.objetos.list.exception.NotSuchElementException;
import uaslp.objetos.list.exception.NotValidIndexException;

public class HashSet<T> implements Set<T> {

    private static final int INITIAL_SIZE = 20;
    private static final int BUCKET_SIZE_THRESHOLD = 5;
    private List<T>[] buckets;

    private boolean disableReorganization;

    private int size;

    public HashSet() {
        this.buckets = new List[INITIAL_SIZE];
    }

    @Override
    public void add(T element) throws NotNullValuesAllowedException, NotValidIndexException {
        int bucketIndex = element.hashCode() % buckets.length;

        if (buckets[bucketIndex] == null) {
            buckets[bucketIndex] = new ArrayList<>();
        } else {
            for (int i = 0; i < buckets[bucketIndex].getSize(); i++) {
                if (buckets[bucketIndex].getAt(i).equals(element)) {
                    return;
                }
            }
        }
        buckets[bucketIndex].addAtTail(element);
        size++;

        if (!disableReorganization && buckets[bucketIndex].getSize() > BUCKET_SIZE_THRESHOLD) {
            reorganize();
        }
    }

    @Override
    public void remove(T element) throws NotValidIndexException {
        int bucketIndex = element.hashCode() % buckets.length;

        if (buckets[bucketIndex] != null) {
            for (int i = 0; i < buckets[bucketIndex].getSize(); i++) {
                if (buckets[bucketIndex].getAt(i).equals(element)) {
                    buckets[bucketIndex].remove(i);
                    size--;
                    return;
                }
            }
        }
    }

    @Override
    public boolean contains(T element) throws NotValidIndexException {
        int bucketIndex = element.hashCode() % buckets.length;

        if (buckets[bucketIndex] != null) {
            for (int i = 0; i < buckets[bucketIndex].getSize(); i++) {
                if (buckets[bucketIndex].getAt(i).equals(element)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new HashSetIterator();
    }

    @Override
    public int size() {
        return size;
    }

    private void reorganize() throws NotValidIndexException, NotNullValuesAllowedException {
        List<T>[] bucketsBkp = buckets;
        disableReorganization = true;

        buckets = new List[bucketsBkp.length * 2];
        size = 0;

        for (List<T> bucket : bucketsBkp) {
            if (bucket != null) {
                for (int i = 0; i < bucket.getSize(); i++) {
                    add(bucket.getAt(i));
                }
            }
        }

        disableReorganization = false;
    }

    private class HashSetIterator implements Iterator<T>{

        private int bucketIndex = -1;
        private int elementIndex;
        private int count;

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public T next() throws NotValidIndexException {
            if(bucketIndex == -1 || buckets[bucketIndex] == null || buckets[bucketIndex].getSize() == elementIndex){
                findNextValidBucket();
            }
            count++;
            return buckets[bucketIndex].getAt(elementIndex++);
        }

        private void findNextValidBucket() {
            elementIndex = 0;
            for(bucketIndex = bucketIndex + 1; bucketIndex < buckets.length; bucketIndex++){
                if(buckets[bucketIndex] != null && buckets[bucketIndex].getSize() > 0){
                    return;
                }
            }
            throw new NotSuchElementException();
        }
    }
}
