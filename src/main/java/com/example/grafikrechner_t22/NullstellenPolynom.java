package com.example.grafikrechner_t22;

import java.util.Scanner;

public class NullstellenPolynom {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double a, b, c, d;

        System.out.println("Gib die Koeffizienten des Polynoms ax^3 + bx^2 + cx + d ein:");
        System.out.print("a: ");
        a = scanner.nextDouble();
        System.out.print("b: ");
        b = scanner.nextDouble();
        System.out.print("c: ");
        c = scanner.nextDouble();
        System.out.print("d: ");
        d = scanner.nextDouble();

        double discriminant = Math.pow(b, 2) - 4 * a * c;

        if (a == 0) {
            System.out.println(" ist kein Polynom dritten Grades.");
        } else if (discriminant > 0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            double x3 = (-b) / (2 * a);

            System.out.println("Die Nullstellen des Polynoms sind: ");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
            System.out.println("x3 = " + x3);


            System.out.println("Die Nullstelle des Polynoms ist: ");
            System.out.println("x1 = " + x1);
        } else {
            double realPart = (-b) / (2 * a);


            System.out.println("Die Nullstellen des Polynoms sind: ");
            System.out.println("x1 = " + realPart);
            System.out.println("x2 = " + realPart);
            System.out.println("x3 = " + (-b) / (2 * a));
        }

        scanner.close();
    }
}
