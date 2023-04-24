package com.example.lk_grafikrechner;

import java.util.Scanner;

public class Wendepunkte {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, b, c, d;

        // Eingabe der Koeffizienten des Polynoms
        System.out.println("Gib den Koeffizienten a, b, c und d des Polynoms ax^3 + bx^2 + cx + d ein:");
        a = sc.nextDouble();
        b = sc.nextDouble();
        c = sc.nextDouble();
        d = sc.nextDouble();

        // Ableitungen berechnen
        double f1 = 3*a*Math.pow(1,2) + 2*b*1 + c;
        double f2 = 6*a*Math.pow(1,1) + 2*b;

        // Wendepunkt berechnen
        double xw = -f1/(6*a);
        double yw = a*Math.pow(xw,3) + b*Math.pow(xw,2) + c*xw + d;

        // Ausgabe
        System.out.println("Der Wendepunkt liegt bei (" + xw + "," + yw + ")");
    }

}

