import uaslp.objetos.list.arrayList.ArrayList;
import uaslp.objetos.list.arrayList.ArrayListIterator;
import uaslp.objetos.list.linkedList.LinkedList;
import uaslp.objetos.list.linkedList.LinkedListIterator;

public class Main {

    public static void main(String[] args) {
        ArrayList team1 = new ArrayList();
        ArrayList team2 = new ArrayList();
        ArrayList team3 = new ArrayList();

        team1.addAtTail("Jesús");
        team1.addAtTail("Salomón");
        team1.addAtTail("Yael");

        team2.addAtFront("Christian");
        team2.addAtFront("Daniel");
        team2.addAtFront("Diego");

        team3.addAtFront("Imelda");

        ArrayListIterator iterator;

        iterator = team1.getIterator();

        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }

        // Debió haber impreso
        // Jesús
        // Salomón
        // Yael

        iterator = team2.getIterator();

        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }

        // Debió haber impreso
        // Diego
        // Daniel
        // Cristian
        team1.remove(0);
        team1.addAtFront("Rebeca");
        System.out.println("Team 1 tiene: " + team1.getSize() + " integrantes"); // debe imprimir "Team 1 tiene 3 integrantes"

        iterator = team1.getIterator();

        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }

        // Debió haber impreso
        // Rebeca
        // Salomón
        // Yael

        team2.remove(2);
        team2.addAtTail("Rita");
        System.out.println("Team 2 tiene: " + team2.getSize() + " integrantes"); // debe imprimir "Team 2 tiene 3 integrantes"

        iterator = team2.getIterator();

        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }

        // Debió haber impreso
        // Diego
        // Daniel
        // Rita
        team3.remove(0);
        team3.remove(0); // El elemento no existe pero el programa no debe cerrarse por algún error

        team3.addAtTail("Tadeo");
        team3.addAtFront("Isai");

        System.out.println("Team 3 tiene: " + team3.getSize() + " integrantes"); // debe imprimir "Team 3 tiene 2 integrantes"

        iterator = team3.getIterator();

        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }

        // Debió haber impreso
        // Tadeo
        // Isai

        if(team1.getAt(1).equals("Salomón")){
            team1.setAt(1, "Luis");
        }

        System.out.println("Team 1 tiene: " + team1.getSize() + " integrantes"); // debe imprimir "Team 1 tiene 3 integrantes"

        iterator = team1.getIterator();

        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }

        // Debió haber impreso
        // Rebeca
        // Luis
        // Yael
    }
}
