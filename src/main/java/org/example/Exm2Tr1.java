package org.example;

public class Exm2Tr1 {
    public static void main(String[] args) {
        //1
        System.out.println(esUnNombrePerfecte(6));
        //2
        int[][] A ={
                {2, 1, 1},
                {0, 1, 3},
                {1, 0, 2}
        };
        int[][] B ={
                {1, 1, 0},
                {2, 1, 2},
                {3, 0, 2}
        };
        imprimirBidimensional(multiplicarMatrius(A,B));
        //4
        System.out.println(esUnPanagrama("pack my box with five dozen liquor jugs"));

    }

    //1
    public static boolean esUnNombrePerfecte(int num) {
        int result = 0;

        for (int i = 1; i < num; i++) {
            if (num % i == 0 || num % i == num) {
                result += i;
            }
        }
        return result == num;
    }

    // 2
    public static int[][] multiplicarMatrius(int[][] A, int[][] B) {

        int[][] resultat;

        int files_A = A.length;
        int col_A = A[0].length;
        int files_B = B.length;
        int col_B = B[0].length;

        resultat = new int[files_A][col_B];

        if (col_A == files_B) {
            for (int i = 0; i < files_A; i++) {
                for (int j = 0; j < col_B; j++) {
                    for (int k = 0; k < col_A; k++) {
                        resultat[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        } else {
            return null;
        }
        return resultat;
    }

    public static void imprimirBidimensional (int[][] M) {
        for (int i = 0; i < M.length; i++) {
            System.out.println(" ");
            for (int j = 0; j < M[0].length; j++) {
                System.out.println(M[i][j] + " ");
            }
        }
    }

    // 3
    /*public static int[] conversioStringADecimal (String nRoma) {
        int [] resultat;
        char Ic = 'I';
        char Vc = 'V';
        char Xc = 'X';
        char Lc = 'L';
        char Cc = 'C';
        char Dc = 'D';
        char Mc = 'M';

        int I = 1;
        int V = 5;
        int X = 10;
        int L = 50;
        int C = 100;
        int D = 500;
        int M = 1000;

        for (int i = 0; i < nRoma.length()-1; i++) {
            if (nRoma.charAt(i)==Ic){
                resultat[i] = I;
            }
        }
        return resultat;
    }


    public static int conversioRomaAAdecimal (int[] M) {
        int result= 0;
        M = conversioStringADecimal("MDCIV");
        int resultatCasError = 0;
        for (int i = 0; i < M.length; i++) {
            if (M[i] > M[i+1]){
                if (M[i+1] == M[i+2]){
                    if (M[i+2] == M[i+3]){
                        result += M[i] + M[i + 1] + M[i + 2] + M[i + 3];
                    } else {
                        result += M[i] + M[i + 1] + M[i + 2];
                    }
                }else {
                    result += M[i] + M[i + 1];
                }
            }else {
                result += M[i + 1] - M[i];
            }
        }
        if (result < 4000){
            return result;
        } else return resultatCasError;
    }
     */

    // 4
    public static boolean esUnPanagrama(String text) {
        String panagrama = text.toLowerCase();
        int counter = 0;
        char[] alfabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int index;

        for (int i = 0; i < panagrama.length(); i++) {
            index = 0;
            while (index < alfabet.length) {
                if (panagrama.charAt(i) == alfabet[index]) {
                    counter++;
                    alfabet[index] = '-';
                    break;  // un cop es compleix el condicional surt del bucle while i ja no comprova la resta de lletres.
                }
                index++;
            }
        }
        return counter == 26;
    }

}
