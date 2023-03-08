package com.example.grafikrechner_t22;

public class PolynomExtrempunkte {

    public static void main(String[] args) {
        double a = 3.0; // x^3-Term
        double b = -4.0; // x^2-Term
        double c = 1.0; // x-Term
        double d = -1.0; // Konstante

        // Ableitungen des Polynoms berechnen
        double fPrime = 3 * a * Math.pow(1, 2) + 2 * b * 1 + c;
        double fDoublePrime = 6 * a * 1 + 2 * b;

        // Wenn die zweite Ableitung nicht gleich Null ist, gibt es einen Extrempunkt
        if (fDoublePrime != 0) {
            // x-Koordinate des Extrempunkts berechnen
            double xCoord = -fPrime / (2 * fDoublePrime);
            // y-Koordinate des Extrempunkts berechnen
            double yCoord = a * Math.pow(xCoord, 3) + b * Math.pow(xCoord, 2) + c * xCoord + d;
            // Ausgabe des Extrempunkts
            System.out.println("Extrempunkt: (" + xCoord + ", " + yCoord + ")");
        } else {
            System.out.println("Kein Extrempunkt vorhanden.");
        }
    }
}
