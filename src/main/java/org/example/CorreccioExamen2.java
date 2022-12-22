package org.example;

public class CorreccioExamen2 {
    public static void main(String[] args) {
        // 1 a)
        System.out.println(isPerfect(6));
        // 1 b)

    }

    // 1 a)
    public static boolean isPerfect (int n) {
      int suma = 0;
        for (int k = 1; k < n; k++) {
            if (n % k == 0){
                suma += k;
            }
        }
        return (suma == n);
    }

    // 1 b)
    public static void primersNombresPerfectes (int n) {
        int countadorPerfectes = 0;
        int nombreCandidat = 1;

        /*
        for (int k = 1; k < n; k++) {
            if (isPerfect(k)){
                System.out.println(k);
            }
        }
         */

        while (countadorPerfectes < n) {
            if (isPerfect(nombreCandidat)){
                System.out.println(nombreCandidat);
                countadorPerfectes++;
            }
            nombreCandidat++;
        }

    }

    // 2
    public static int[][] multiplicarMatrius (int[][]A, int[][]B) {
        int[][] R;

        int ample_A = A[0].length;
        int alt_A = A.length;
        int ample_B = B[0].length;
        int alt_B = B.length;

        if (ample_A != alt_B)
            return null; // podria imprimir "la matriu no es multiplicable"

        R = new int[alt_A][ample_B];

        for (int fila = 0; fila < alt_A; fila++) {
            for (int col = 0; col < ample_B; col++) {
                for (int k = 0; k < ample_A; k++) {
                    R[fila][col] += A[fila][k] * B[k][col];
                }
            }
        }

        return R;
    }

    // 3
    private static final char[] digitsRomans = { 'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    private static final int[] valorDigitsRomans = {1, 5, 10, 50, 100, 500, 1000};

    private static int valorDigitRoma (char digit) {

        for (int k = 0; k < digitsRomans.length; k++) {
            if (digit == digitsRomans[k])
                return valorDigitsRomans[k];
        }
        return 0;
    }
    
    /*public static int conversioANombreDecimal (String nombreRoma) {
        int numDecimal = 0;

        for (int k = 0; k < ; k++) {
            
        }
    }
     */
    
    // 4
    public static boolean esUnPanagrama (String mot) {
        String alfabet = "abcdefghijklmnopqrstuvwxyz";
        String motEnMinuscula = mot.toLowerCase();
        boolean[] lletresTrobades = new boolean[alfabet.length()];
        int index = 0;
        for (int k = 0; k < motEnMinuscula.length(); k++) {
            //comptabilitzant que la lletra de l'index k acaba de sortir
            index = motEnMinuscula.charAt(k) - 'a';
            lletresTrobades[index] = true;
        }
        for (int k = 0; k < alfabet.length(); k++) {
            if (!lletresTrobades[k]){
                return false;
            }
        }

        return false;
    }

}
