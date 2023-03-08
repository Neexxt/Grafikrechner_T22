public class Polynom_symetrie {

        static void Symetrie(int[] polynom, int polynomlength) {
            int runde = 0;
            while( polynomlength > runde){;
                if (polynom[runde] % 2 == 0) {
                    System.out.println("Punktsymetrisch");
                    runde += 1;
                } else if (polynom[runde] % 2 == 1) {
                    System.out.println("Achsensymetrisch");
                    runde += 1;
                }
            }
        }

    public static void main(String[] args) {
        int[] polynom = {0, 2, 4};
        int polynomlength = polynom.length;
        Symetrie(polynom, polynomlength);

    }}