package uaslp.objetos.list.arrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uaslp.objetos.list.Iterator;

public class ArrayListTest {

    @Test
    public void givenASizeOfNewArrayList_whenGetSize_thenResultIsZero() {
        //Given:
        ArrayList<String> array=new ArrayList<>(0);

        //When:

        int sizeOfList = array.getSize();

        //Then:
        Assertions.assertEquals(0, sizeOfList, "Size of list after creation must be zero."); //Valida que el tamaño sea 1
    }


    @Test
    public void givenANewArrayList_whenGetSize_thenResultIsZero() {
        //Given:
        ArrayList<String> array = new ArrayList<>();

        //When:
        int sizeOfList = array.getSize();

        //Then:
        Assertions.assertEquals(0, sizeOfList, "Size of list after creation must be zero."); //Valida que el tamaño sea 1
    }

    @Test
    public void givenANewArrayList_whenAddAtFront_thenSizeIsOne() {
        //Given:
        ArrayList<String> array = new ArrayList<>();

        array.addAtFront("Hola");

        //When:
        int sizeOfList = array.getSize();

        //Then:
        Assertions.assertEquals(1, sizeOfList);
        Assertions.assertEquals("Hola", array.getAt(0));
    }

    @Test
    public void givenAnArrayListWithOneElement_whenAddAtFront_thenSizeIsTwo() {
        //Given:
        ArrayList<String> array = new ArrayList<>();

        array.addAtFront("Hola");

        //When:
        array.addAtFront("Mundo");

        //Then:
        int sizeOfList = array.getSize();

        Assertions.assertEquals(2, sizeOfList);
        Assertions.assertEquals("Mundo", array.getAt(0));
        Assertions.assertEquals("Hola", array.getAt(1));
    }

    @Test
    public void givenANewArrayList_whenAddAtTail_thenSizeIsOne() {
        //Given:
        ArrayList<String> array = new ArrayList<>();

        array.addAtTail("Hola");

        //When:
        int sizeOfList = array.getSize();

        //Then:
        Assertions.assertEquals(1, sizeOfList);
        Assertions.assertEquals("Hola", array.getAt(0));
    }

    @Test
    public void givenAnArrayListWithOneElement_whenAddAtTail_thenSizeIsTwo() {
        //Given:
        ArrayList<String> array = new ArrayList<>();

        array.addAtTail("Hola");

        //When:
        array.addAtTail("Mundo");

        //Then:
        int sizeOfList = array.getSize();

        Assertions.assertEquals(2, sizeOfList);
        Assertions.assertEquals("Hola", array.getAt(0));
        Assertions.assertEquals("Mundo", array.getAt(1));
    }

    @Test
    public void givenAnArrayListWithOneElement_whenRemove_thenSizeIsZero(){
        //Given:
        ArrayList<String> array = new ArrayList<>();
        array.addAtFront("Hola");

        //When:
        array.remove(0);

        //Then:
        int sizeOfList = array.getSize();

        Assertions.assertEquals(0,sizeOfList);
    }

    @Test
    public void givenAnArrayListWithTwoElements_whenRemove_thenSizeIsOne(){
        //Given:
        ArrayList<String> array = new ArrayList<>();
        array.addAtFront("Hola");
        array.addAtTail("Mundo");

        //When:
        array.remove(0);

        //Then:
        int sizeOfList = array.getSize();

        Assertions.assertEquals(1,sizeOfList);
        Assertions.assertEquals("Mundo",array.getAt(0));
    }


    @Test
    public void givenAnArrayListWithTwoElements_whenRemoveIndex1_thenSizeIsOne(){
        //Given:
        ArrayList<String> array = new ArrayList<>();
        array.addAtFront("Hola");
        array.addAtTail("Mundo");

        //When:
        array.remove(1);

        //Then:
        int sizeOfList = array.getSize();

        Assertions.assertEquals(1,sizeOfList);
        Assertions.assertEquals("Hola",array.getAt(0));
    }

    @Test
    public void givenAnArrayListWithThreeElements_whenRemoveIndex1_thenSizeIsTwo(){
        //Given:
        ArrayList<String> array = new ArrayList<>();

        array.addAtTail("Mundo");
        array.addAtTail("Cruel");
        array.addAtFront("Adiós");

        //When:
        array.remove(1);

        //Then:
        int sizeOfList = array.getSize();

        Assertions.assertEquals(2,sizeOfList);
        Assertions.assertEquals("Adiós",array.getAt(0));
        Assertions.assertEquals("Cruel",array.getAt(1));
    }

    @Test
    public void givenAnArrayListWithThreeElements_whenRemoveElementAtTail_thenSizeIsTwo(){
        //Given:
        ArrayList<String> array = new ArrayList<>(); //Crea un objeto de la lista

        array.addAtFront("Adiós");
        array.addAtTail("Mundo");
        array.addAtTail("Cruel");

        //When:
        array.remove(2);

        //Then:
        int sizeOfList = array.getSize();

        Assertions.assertEquals(2,sizeOfList);
        Assertions.assertEquals("Adiós",array.getAt(0));
        Assertions.assertEquals("Mundo",array.getAt(1));
    }

    @Test
    public void givenAnArrayListWithThreeElements_whenRemoveAll_thenSizeIsZero(){
        //Given:
        ArrayList<String> array = new ArrayList<>(); //Crea un objeto de la lista
        array.addAtFront("Adiós");
        array.addAtTail("Mundo");
        array.addAtTail("Cruel");
        //When:
        array.removeAll();
        //Then:
        int sizeOfList = array.getSize();
        Assertions.assertEquals(0,sizeOfList);
    }

    @Test
    public void givenAnArrayListWithTwoElements_whenSetAt_thenElementIsModified(){
        //Given:
        ArrayList<String> array = new ArrayList<>(); //Crea un objeto de la lista
        array.addAtTail("Mundo");
        array.addAtFront("Adiós");
        //When:
        array.setAt(0,"Hola");
        //Then:
        int sizeOfList = array.getSize();
        Assertions.assertEquals(2,sizeOfList);
        Assertions.assertEquals("Hola",array.getAt(0));
        Assertions.assertEquals("Mundo",array.getAt(1));
    }
    @Test
    public void givenAnArrayListWithThreeElements_whenGetIterator_thenIteratorWorksOverThreeElements(){
        //Given:
        ArrayList<String> array = new ArrayList<>(); //Crea un objeto de la lista
        array.addAtFront("Adiós");
        array.addAtTail("Mundo");
        array.addAtTail("Cruel");
        //When:
        Iterator<String> iterator = array.getIterator();
        //Then:
        int sizeOfList = array.getSize();
        Assertions.assertEquals(3,sizeOfList);
        Assertions.assertNotNull(iterator);
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Adiós",iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Mundo",iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Cruel",iterator.next());
        Assertions.assertFalse(iterator.hasNext());
    }
}

