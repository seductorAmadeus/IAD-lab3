package com.amadeus.IAD.Lab3;
// variant 30103

import java.util.*;

public class Lab3 {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        boolean actionWasSuccessfully = false;
        while (!actionWasSuccessfully) {
            printMenuItems();
            switch (in.nextLine()) {
                case "1": {
                    startChecking(getRadius());
                    actionWasSuccessfully = true;
                }
                case "2":
                    Runtime.getRuntime().exit(0);
                    break;
                default:
                    System.out.println("Re-enter menu item, please\n");
            }
        }
    }

    private static void printMenuItems() {
        System.out.println("1. Enter new radius \n" +
                "2. Exit\n");
    }

    private static double getRadius() {
        double R;
        while (true) {
            try {
                System.out.println("Enter radius, please: ");
                R = Double.valueOf(in.nextLine());
                if (R < 0) throw new NumberFormatException();
                break;
            } catch (NumberFormatException exp) {
                System.out.println("Format error, re-enter radius ");
            }
        }
        return R;
    }

    private static void startChecking(double R) {

        PriorityQueue<Nokta> priorityQueue = new PriorityQueue<Nokta>();
        Nokta[] noktas = new Nokta[]{new Nokta(3, 1), new Nokta(0, 0), new Nokta(-1, -2), new Nokta(-2, 1), new Nokta(4, -3),
                new Nokta(5, 5), new Nokta(-2, 1), new Nokta(-3, 4), new Nokta(-5, 5)};

        for (Nokta nokta : noktas) {
            priorityQueue.offer(nokta);
        }

        Iterator<Nokta> iterator = priorityQueue.iterator();

        Outline outline = new Outline(R);
        do {
            Nokta nokta = iterator.next();
            if (outline.checkValue(nokta)) {
                System.out.println(nokta.toString());
            }
        } while (iterator.hasNext());

    }
}
