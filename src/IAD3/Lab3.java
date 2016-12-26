package IAD3;

import java.util.*;

public class Lab3 {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        boolean actionWasSuccessfully = false;
        int menuNumber;
        while (!actionWasSuccessfully) {
            printMenuItems();
            try {
                menuNumber = Integer.valueOf(in.nextLine());
            } catch (NumberFormatException exp) {
                System.out.println("Re-enter menu item (1 or 2), please\n");
                continue;
            }
            switch (menuNumber) {
                case 1:
                    startChecking(getRadius());
                    actionWasSuccessfully = true;
                    break;
                case 2:
                    actionWasSuccessfully = true;
                    break;
                default:
                    System.out.println("Re-enter menu item (1 or 2), please\n");
            }
        }
    }

    private static void printMenuItems() {
        System.out.println("1. Enter new radius \n" +
                "2. Exit\n");
    }

    private static double getRadius() {
        double radius;
        while (true) {
            try {
                System.out.println("Enter radius, please: ");
                radius = Double.valueOf(in.nextLine().replace(",", "."));
                if (radius < 0) throw new IllegalArgumentException();
                break;
            } catch (NumberFormatException exp) {
                System.out.println("Format error, re-enter double value ( >=0 )");
            } catch (IllegalArgumentException exp) {
                System.out.println("Format error, re-enter radius ( >= 0)");
            }
        }
        return radius;
    }

    private static void startChecking(double radius) {
        PriorityQueue<Nokta> priorityQueue = new PriorityQueue<Nokta>();
        Nokta[] noktas = new Nokta[]{new Nokta(3, 1), new Nokta(0, 0), new Nokta(-1, -2), new Nokta(-2, 1), new Nokta(4, -3),
                new Nokta(5, 5), new Nokta(-2, 1), new Nokta(-3, -4), new Nokta(-5, 5)};
        for (Nokta nokta : noktas) {
            priorityQueue.offer(nokta);
        }
        Iterator<Nokta> iterator = priorityQueue.iterator();
        Outline outline = new Outline(radius);
        do {
            Nokta nokta = iterator.next();
            if (outline.checkValue(nokta)) {
                System.out.println(nokta.toString());
            }
        } while (iterator.hasNext());
    }
}
