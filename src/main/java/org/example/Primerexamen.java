package org.example;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.util.Arrays;

public class Primerexamen {
    public static void main(String[] args) {
        int[] n = {2, 43, 1, 12, 6, 4, 8, 54, 76, 3};  // 10 pos (0-9)
        System.out.println("Suma matriu: " + sumaMatriu(n));
        System.out.println("Mitja aritmetica: " + mitjaAritmetica(n));
        System.out.println("Valor mínim: " + valorMinim(n));
        System.out.println("Index valor mínim: " + indexValorMinim(n));
        System.out.println("valor maxim: " + valorMaxim(n));
        System.out.println("Index valor maxim: " + indexValorMaxim(n));
        System.out.println("Boolean matriu ordenada: " + matriuOrdenatAscendent(n));
        System.out.println("Boolean indexSenarOrdenatDescendent: " + indexSenarOrdenatDescendent(n));
        System.out.println("Array invertida: " + Arrays.toString(invertirArray(n)));
        System.out.println("Ocurrencia: " + indexOcurrencia(n,12));
        System.out.println("Valor més proper a la mitja: " + mesProperMitja(n));
        System.out.println("Intercanvi de posició: " + Arrays.toString(intercanviValor(n, 5 )));
        System.out.println("Matriu intercanviada ordenada: " + Arrays.toString(matriuOrdenada(n)));

    }

    // 1  mitja aritmetica
   /*public static float mitjaAritmetica (int[] n){
       float result = 0;
       for (int i = 0; i < n.length; i++) {
           result += n[i];
       }
       result /= n.length;
       return result;
   }
    */

    public static int sumaMatriu(int[] n) {
        int result = 0;
        for (int i = 0; i < n.length; i++) {
            result += n[i];
        }
        return result;
    }

    public static float mitjaAritmetica(int[] n) {
        float result = (float) sumaMatriu(n) / n.length;
        return result;
    }

    // 2 valor minim matriu
   /*public static int valorMinim (int[] n){
       int result = 0;
       for (int i = 0; i < n.length; i++) {
           for (int j = i + 1; j < n.length; j++) {
               if (n[i] < n[j]){
                   result = n[i];
                   n[i] = n[j];
                   n[j] = result;
               }
           }
       }
       return result;
   }
    */

    public static int valorMinim(int[] n) {
        int result = n[0];
        for (int i = 1; i < n.length; i++) {
            if (n[i] < result) {
                result = n[i];
            }
        }

        return result;
    }

    // 3 index de valor minim matriu
    public static int indexValorMinim(int[] n) {
        int result = n[0];
        for (int i = 0; i < n.length; i++) {
            if (n[i] < result) {
                result = i;
            }
        }
        return result;
    }

    // 4 valor maxim matriu
    public static int valorMaxim(int[] n) {
        int result = n[0];
        for (int i = 1; i < n.length; i++) {
            if (n[i] > result) {
                result = n[i];
            }

        }
        return result;
    }

    // 5 index valor maxim matriu
    public static int indexValorMaxim(int[] n) {
        int result = n[0];
        for (int i = 0; i < n.length; i++) {
            if (n[i] > result) {
                result = i;
            }
        }
        return result;
    }

    // 6 true si matriu ordenat ascendent else false
    public static boolean matriuOrdenatAscendent(int[] n) {
        boolean result = true;
       /*for (int i = 0; i < n.length; i++) {
           for (int j = i + 1; j < n.length; j++) {
               if (n[j] < n[i]){
                   result = false;
               }
           }
       }
        */
        for (int i = 1; i < n.length; i++) {
            if (i <= n.length) {
                if (n[i] > n[i - 1]) {

                } else
                    result = false;
            }
        }
        return result;
    }

    // 7
    public static boolean indexSenarOrdenatDescendent(int[] n) {
        boolean result = true;
        for (int i = 1; i < n.length; i += 2) {
            if (i + 2 <= n.length) {
                if (n[i] > n[i + 2]) {

                } else
                    result = false;
            }
        }
        return result;
    }

    // 8

    public static int[] invertirArray(int[] n) {
        int[] arrayInvertida = new int[n.length];
        int contador = 0;
        while (contador < n.length) {
            for (int i = arrayInvertida.length - 1; i >= 0; i--) {
                arrayInvertida[i] = n[contador];
                contador++;
            }

        }
        return arrayInvertida;
    }

    // 9

    public static int indexOcurrencia(int[] n, int ocurrencia) {
        int result = -1;
        for (int i = 0; i < n.length; i++) {
            if (ocurrencia == n[i])
                result = i;
        }
        return result;
    }

    // 10

    public static int mesProperMitja(int[] n) {
        float mitja = mitjaAritmetica(n);  // 20.9
        int indexValorProperMitja = 0;
        int valorProperMitja = 0;
        for (int i = 1; i < n.length; i++) {
            if (Math.abs(n[i] - mitja) < Math.abs(n[indexValorProperMitja] - mitja)) {
                indexValorProperMitja = i;
                valorProperMitja = n[i];
            }
        }


        return valorProperMitja;
    }

    // 11
    public static int[] intercanviValor(int[] n, int a) {
        int[] result = n;
        int temp = n[0];  // valor més gran
        int index = 0;  // index del valor més gran
        int temporal = n[a];  // valor posició a

        for (int i = a ; i > 0; i--) {  // (int i = 0; i < a; i++)
            if (temp < n[i]) {
                temp = n[i];
                index = i;
            }
        }

        result[a] = temp;
        result[index] = temporal;
        return result;
    }

    // 12
    public static int[] matriuOrdenada(int[] n) {
        for (int i = n.length -1; i > 0; i--) {
            n = intercanviValor(n,i);
        }
        return n;
    }

}

