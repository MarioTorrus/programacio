package org.example;

import java.util.Arrays;

public class Dubtes {
    public static void main(String[] args) {
        int[] n = {2, 43, 1, 12, 6, 4, 8, 54, 76, 3};
        System.out.println(matriuOrdenatAscendent(n));
        System.out.println(Arrays.toString(invertirArrayy(n)));
    }
    public static boolean matriuOrdenatAscendent(int[] n) {
        boolean result = true;
        for (int i = 1; i < n.length; i++) {
            if (i <= n.length) {  // while ??
                if (n[i] > n[i - 1]) {
                    // return result; ??
                } else
                    result = false;
                // break; ??
            }
        }
        return result;
    }

    // 8
    public static int[] invertirArrayy(int[] n) {
        int[] arrayInvertida = new int[n.length];
        for (int i = 0; i < n.length; i++) {
            for (int j = n.length -1; j >= 0; j--) {
                arrayInvertida[j] = n[i];
            }
        }
        return arrayInvertida;
    }
}
