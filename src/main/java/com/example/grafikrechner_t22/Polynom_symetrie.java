package com.example.grafikrechner_t22master;
import java.util.ArrayList;

 public class  Polynom_symetrie {

    static  void Symetrie(int[] polynom, int polynomlength) {
        int runde = 0;
        ArrayList<Integer> ergebniss = new ArrayList<Integer>();
        while (polynomlength > runde) {
            if (polynom[runde] % 2 == 0) {
                ergebniss.add(1);
                runde += 1;
            } else if (polynom[runde] % 2 == 1) {
                ergebniss.add(0);
                runde += 1;
            }
        }
        String symetrie;
        if (ergebniss.contains(1) && ergebniss.contains(0)) {
            symetrie = "Unbestimmt";
        } else if (ergebniss.contains(1)) {

            symetrie = "Achsensymetrisch";
        } else if (ergebniss.contains(0)) {
            symetrie = "Punktsymetrisch";
        }
    }

    public static void main(String[] args) {
        int[] polynom = {0, 2, 4};
        int polynomlength = polynom.length;
        Symetrie(polynom, polynomlength);

    }}