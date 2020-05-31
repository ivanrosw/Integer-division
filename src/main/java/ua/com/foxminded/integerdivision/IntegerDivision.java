package ua.com.foxminded.integerdivision;

import ua.com.foxminded.integerdivision.logic.IntegerDivider;

public class IntegerDivision {

    public static void main(String[] args) throws InterruptedException {
        IntegerDivider divider = new IntegerDivider();
        System.out.println(divider.printDivision(513,2));
        System.out.println();
        System.out.println(divider.printDivision(-513,2));
        System.out.println();
        System.out.println(divider.printDivision(513,-2));
        System.out.println();
        System.out.println(divider.printDivision(-513,-2));
        System.out.println();
        System.out.println(divider.printDivision(-513,22));
        System.out.println();
        System.out.println(divider.printDivision(-513,-22));
        System.out.println();
        System.out.println(divider.printDivision(513,22));
        System.out.println();
        System.out.println(divider.printDivision(513,222));
        System.out.println();
        System.out.println(divider.printDivision(-513,222));
        System.out.println();
        System.out.println(divider.printDivision(513,-222));
        System.out.println();
        System.out.println(divider.printDivision(Integer.MAX_VALUE,Integer.MAX_VALUE));
        System.out.println();
        System.out.println(divider.printDivision(Integer.MAX_VALUE,1));
        System.out.println();
        Thread.sleep(100);
        System.out.println();
        System.out.println(divider.printDivision(513,-2222));
        System.out.println();
        System.out.println(divider.printDivision(-513,-2222));
        System.out.println();
        System.out.println(divider.printDivision(0,2));
        System.out.println();
        System.out.println(divider.printDivision(0,0));
    }
}
