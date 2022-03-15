package uaslp.objetos.list;

import uaslp.objetos.list.linkedList.LinkedList;
import uaslp.objetos.list.linkedList.LinkedListIterator;
import uaslp.objetos.list.arrayList.ArrayList;
import uaslp.objetos.list.arrayList.ArrayListIterator;

public class Main {

    public static void main(String[] args) {
        List<String> team1 = new ArrayList<>();
        List<String> team2 = new ArrayList<>();
        List<String> team3 = new ArrayList<>();

        List<String> team4 = new LinkedList<>();
        List<String> team5 = new LinkedList<>();
        List<String> team6 = new LinkedList<>();

        function(team1,team2,team3, 0);
        function(team4,team5,team6, 1);
    }

    public static void function(List<String> team1, List<String> team2, List<String> team3, int controller) {
        controller*=3;
        team1.addAtTail("Jesús");
        team1.addAtTail("Salomón");
        team1.addAtTail("Yael");

        team2.addAtFront("Cristian");
        team2.addAtFront("Daniel");
        team2.addAtFront("Diego");

        team3.addAtFront("Imelda");

        Iterator<String> iterator;

        iterator = team1.getIterator();

        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }

        // Debió haber impreso
        // Jesús
        // Salomón
        // Yael
        System.out.println();
        iterator = team2.getIterator();

        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }

        // Debió haber impreso
        // Diego
        // Daniel
        // Cristian

        System.out.println();
        team1.remove(0);
        team1.addAtFront("Rebeca");
        controller++;
        System.out.println("Team "+ controller + " tiene: " + team1.getSize() + " integrantes"); // debe imprimir "Team 1 tiene 3 integrantes"

        iterator = team1.getIterator();

        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }

        // Debió haber impreso
        // Rebeca
        // Salomón
        // Yael
        System.out.println();
        team2.remove(2);
        team2.addAtTail("Rita");
        controller++;
        System.out.println("Team " + controller + " tiene: " + team2.getSize() + " integrantes"); // debe imprimir "Team 2 tiene 3 integrantes"

        iterator = team2.getIterator();

        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }

        // Debió haber impreso
        // Diego
        // Daniel
        // Rita

        System.out.println();
        team3.remove(0);
        team3.remove(0); // El elemento no existe pero el programa no debe cerrarse por algún error

        team3.addAtTail("Tadeo");
        team3.addAtFront("Isai");

        controller++;
        System.out.println("Team " + controller + " tiene: " + team3.getSize() + " integrantes"); // debe imprimir "Team 3 tiene 2 integrantes"

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

        System.out.println();
        controller-=2;
        System.out.println("Team " + controller + " tiene: " + team1.getSize() + " integrantes"); // debe imprimir "Team 1 tiene 3 integrantes"

        iterator = team1.getIterator();

        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }
    }
}