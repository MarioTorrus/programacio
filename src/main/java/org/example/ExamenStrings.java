package org.example;

import java.util.Arrays;

public class ExamenStrings {
    public static void main(String[] args) {
        String provaExecucio = "Cuando un tonto coje un cam)ino, se acaba el camino y sigue el tonto!. Mario dixit";
        char[] delimitadorsDefinits = {' ', '-', ',', '.', '!', '?', '\''};
        System.out.println(stringAMatriuChar(provaExecucio));
        ExamenStrings.printMatriuChar(provaExecucio);
        System.out.println(delimitadorDefinit(provaExecucio, delimitadorsDefinits, 2));

    }

    // 2
    public static char[] stringAMatriuChar(String provaExecucio) {
        String lowerCaseString = provaExecucio.toLowerCase();
        char[] matriuChars = new char[lowerCaseString.length()];
        //char resultat;


        /*for (int i = 0; i < lowerCaseString.length(); i++) {
            resultat = lowerCaseString.charAt(i);
            matriuChars = resultat;
        }
         */
        for (int i = 0; i < lowerCaseString.length(); i++) {
            matriuChars[i] = lowerCaseString.charAt(i);
        }
        return matriuChars;
    }

    // 3

    public static void printMatriuChar(String provaExecucio) {
        System.out.println(stringAMatriuChar(provaExecucio));
    }

    // 4
    public static boolean delimitadorDefinit(String provaExecucio, char[] delimitadorsDefinits, int posicio) {
        boolean resultat = false;
        for (int i = 0; i < provaExecucio.length() - 1; i++) {
            if (posicio <= provaExecucio.length()) {
                if (provaExecucio.charAt(posicio + i) == delimitadorsDefinits[i]) {
                    resultat = true;
                    break;
                }
            }
        }
        return resultat;
    }

}
