package org.example;

import java.util.Arrays;

public class ExamenStrings {
    public static void main(String[] args) {
        String provaExecucio = "Cuando un tonto coje un cam)ino, se acaba el camino y sigue el tonto!. Mario dixit";
        char[] delimitadorsDefinits = {' ', '-', ',', '.', '!', '?', '\''};
        System.out.println(stringAMatriuChar(provaExecucio));
        System.out.println(printMatriuChar(provaExecucio));
        System.out.println("4- " + delimitadorDefinit(provaExecucio, delimitadorsDefinits, 9));
        System.out.println("5- " + iniciParaula(provaExecucio, delimitadorsDefinits, 36));
        //System.out.println("6- " + longitudParaula(provaExecucio,delimitadorsDefinits,0));
        System.out.println("7- " + paraulaPosicio(provaExecucio,delimitadorsDefinits,7));
    }

    // 2
    public static char[] stringAMatriuChar(String provaExecucio) {
        String lowerCaseString = provaExecucio.toLowerCase();
        char[] matriuChars = new char[lowerCaseString.length()];

        for (int i = 0; i < lowerCaseString.length(); i++) {
            matriuChars[i] = lowerCaseString.charAt(i);
        }
        return matriuChars;
    }

    // 3

    public static char[] printMatriuChar(String provaExecucio) {
        char[] imprimirMatriuChar = new char[stringAMatriuChar(provaExecucio).length];
        for (int i = 0; i < provaExecucio.length(); i++) {
            imprimirMatriuChar[i] = stringAMatriuChar(provaExecucio)[i];
        }
        return imprimirMatriuChar;
    }

    // 4
    public static boolean delimitadorDefinit(String provaExecucio, char[] delimitadorsDefinits, int posicio) {
        char[] matChars = stringAMatriuChar(provaExecucio);
        for (int i = 0; i < delimitadorsDefinits.length; i++) {
            if (matChars[posicio] == delimitadorsDefinits[i])
                return true;
        }
        return false;
    }


    // 5
    public static boolean iniciParaula(String provaExecucio, char[] delimitadorsDefinits, int posicio) {

        for (int i = 0; i < delimitadorsDefinits.length -1; i++) {
            if (posicio != 0) {
                if (posicio < 0 || posicio > provaExecucio.length() - 1) {
                    return false;
                } else if (provaExecucio.charAt(posicio - 1) == delimitadorsDefinits[i]) {
                    return true;
                }
            } else if (provaExecucio.charAt(0) != delimitadorsDefinits[i]) {
                return true;
            }
        }
        return false;
    }

    // 6
    /*public static int longitudParaula (String provaExecucio,char[] delimitadorsDefinits, int posicio) {
        int result = 0;
        if (!iniciParaula(provaExecucio,delimitadorsDefinits,4))
        return result;
    }

     */

    // 7
    public static String paraulaPosicio (String provaExecucio, char[] delimitadorsDefinits, int posicio) {
        char[] MChars = new char[provaExecucio.length()];
        for (int i = 0; i < provaExecucio.length() - 1; i++) {
            if (provaExecucio.charAt(i) + 1 != delimitadorsDefinits[i]){
                MChars[i] = provaExecucio.charAt(i);
            }
        }
        return MChars.toString();
    }

}
