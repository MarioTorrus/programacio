package org.example;

public class Main {
    public static void main(String[] args) {

    }

    public static boolean[] erastotenes(int n) {
        boolean[] primers = new boolean[n + 1];

        for (int k = 0; k < primers.length; k++) {
            primers[k] = true;

            primers[0] = false;
            primers[1] = false;

            for (int i = 2; i < primers.length; i++) {   // (int) Math.sqrt(n)
                if (primers[i]) {
                    for (int j = 2; j * i < primers.length; j++) {
                        primers[j * i] = false;
                    }
                }
            }
        }
        return primers;
    }


    public static int[] primersMenorsOIgualQue(int n) {

    }

    public static void imprimirPrimers(boolean[] primers) {


    }

    public static void imprimirPrimers(int[] primers) {

    }

    public static String descomposicioFactorial(int n) {
        String resultat = "";
        int factor = 2;
        while (n != 1) {
            while (n % factor == 0) {
                n = n / factor;
                resultat += " " + factor;
            }
            factor++;
        }
        return resultat;
    }


    // Exercici 3 simplificat
    //"qualsevol cadena de text  amb dos espais aqui"
    // 012345678901234567890123456789012345678901234

    public static boolean textConteStringALaPosicio(String text, String paraulaACercar, int pos) {
        if ((pos < 0) || (pos >= text.length()))
            return false;

        if (pos + paraulaACercar.length() > text.length())
            return false;

        for (int r = 0; r < paraulaACercar.length(); r++){
            if (paraulaACercar.charAt(r) != text.charAt(r+pos)){
                return false;
            }
        }

        return true;
    }
}
