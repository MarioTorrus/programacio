package org.example;

public class examen {
    public static void main(String[] args) {
        int[] M = {3, 4, 5, 6, 23, 3, 14, 32, 52, 1};
        String text = "hola buenas tardes mañana hay examen de programacion";
        System.out.println(textConteStringALaPosicio(text, "buenas", 5));
    }

    public static boolean[] erastotenes(int M) {
        boolean[] primers = new boolean[M + 1];

        /*for (int i = 0; i < primers.length; i++) {
            primers[i] = true;

            primers[0] = false;
            primers[1] = false;

            for (int k = 2; k < primers.length; k++) {   // (int) Math.sqrt(n)
                if (primers[k]) {
                    for (int j = 2; j * k < primers.length; j++) {
                        primers[j * k] = false;
                    }
                }
            }
        }
         */

        for (int i = 0; i < primers.length; i++) {
            primers[i] = true;
            primers[0] = false;
            primers[1] = false;
            for (int j = 2; j < primers.length; j++) {
                if (primers[j]) {
                    for (int k = 2; j * k < primers.length; k++) {
                        primers[j * k] = false;
                    }
                }
            }
        }

        return primers;
    }


    public static int[] primersMenorsOIgualQue(int M) {
        int[] result = new int[M];
        return result;
    }

    public static void imprimirPrimers(boolean[] primers) {


    }

    public static void imprimirPrimers(int[] primers) {

    }

    public static String descomposicioFactorial(int M) {
        String resultat = "";
        int factor = 2;
        while (M != 1) {
            while (M % factor == 0) {
                M = M / factor;
                resultat += " " + factor;
            }
            factor++;
        }
        return resultat;
    }

    public static String descomposicioFactorial2(int num) {
        String result = "";
        int factor = 2;
        while (num != 1) {
            while (num % factor == 0) {
                num = num / factor;
                result += " " + factor;
            }
            factor++;
        }
        return result;
    }


    // Exercici 3 simplificat
    //"qualsevol cadena de text  amb dos espais aqui"
    // 012345678901234567890123456789012345678901234

    public static boolean textConteStringALaPosicio(String text, String paraulaACercar, int pos) {
        if ((pos < 0) || (pos >= text.length()))
            return false;

        if (pos + paraulaACercar.length() > text.length())
            return false;

        for (int i = 0; i < paraulaACercar.length(); i++) {
            if (paraulaACercar.charAt(i) != text.charAt(i + pos))
                return false;
        }

        return true;
    }
}
