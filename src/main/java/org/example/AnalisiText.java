package org.example;

public class AnalisiText {
    public static void main(String[] args) {
        String frase = "Las palomas ojo, los pavos las gallinas, aa comen, cacac, cacarean, ponen huevos? y cagan.";
        String[] matrizString = {"mundiales","hola","que","papapaxtin","tal","caracol","ok","mundo","y"};
        System.out.println(palabraPalindroma("ojo"));

    }
    public char[] analizar(String frase) {
        char[] matrizChars =new char[frase.length()];

        for(int i=0 ; i < frase.length() ; i++) {
            matrizChars[i] = frase.toLowerCase().charAt(i);
        }

        return matrizChars;
    }

    public void imprimirMatrizChars (char[] matriz){
        System.out.print("{ ");
        for (int i=0;i<matriz.length;i++){
            System.out.print(matriz[i]);
            if (i <matriz.length-1){
                System.out.print(" | ");
            }
        }
        System.out.print(" }");
    }

    public boolean hayUnDelimitadorEnIndex (char[] matriz, int index){
        char encontrado=matriz[index];
        char[] matrizDelimitadores = {'!',' ','?','.',','};
        for (int i=0;i<matrizDelimitadores.length;i++){
            if (matrizDelimitadores[i]==encontrado){
                return true;
            }
        }
        return false;
    }

    public boolean hayUnDelimitadorEnIndex2 (String texto, int index){
        char [] matrizChars = analizar(texto);
        char encontrado=matrizChars[index];
        char[] matrizDelimitadores = {'!',' ','?','.',','};
        for (int i=0;i<matrizDelimitadores.length;i++){
            if (matrizDelimitadores[i]==encontrado){
                return true;
            }
        }
        return false;
    }

    public boolean inicioDePalabraOno (char[] matriz, int index){
        if (index ==0 && !(hayUnDelimitadorEnIndex(matriz,index))){
            return true;
        }
        else if (hayUnDelimitadorEnIndex(matriz,index)){
            return false;
        }
        else if (hayUnDelimitadorEnIndex(matriz,index-1)){
            return true;
        }
        else return false;
    }

    /*public boolean inicioDePalabraOno (char[] matriz, int index){
       if (index == 0 && !(hayUnDelimitadorEnIndex(matriz,index))){
           return true;
       }
        for (int i=0;i<matriz.length;i++){
            if (hayUnDelimitadorEnIndex(matriz,index)){
                return false;
            }
        }
        for (int k=0;k<matriz.length;k++){
            if (hayUnDelimitadorEnIndex(matriz,index-1)){
                return true;
            }
        }
        return false;
    }*/

    public boolean inicioDePalabraOno2 (String texto, int index){
        char [] matrizChars = analizar(texto);
        char[] matrizDelimitadores = {'!',' ','?','.',','};
        boolean inicio = false;
        if (matrizChars[index] == 0){
            return true;
        }
        for (int i=0;i<matrizDelimitadores.length;i++){
            if (matrizDelimitadores[i] == matrizChars[index-1]){
                inicio = true;
            }
        }
        return inicio;
    }

    public int longitudPalabra (char[] matriz, int index){
        int longitud =0;
        if (!inicioDePalabraOno(matriz,index)){
            return longitud;
        }
        for (int i=index; i<matriz.length;i++){
            if (hayUnDelimitadorEnIndex(matriz,i)){
                break;
            }
            longitud++;
        }
        return longitud;
    }
    public String palabraDadoIndex (char[] matriz, int index){
        String palabra = "";
        if (!inicioDePalabraOno(matriz,index)){
            palabra="No es un inicio de palabra";
            return palabra;
        }
        for (int i=index;i<matriz.length;i++){
            if (hayUnDelimitadorEnIndex(matriz,i)){
                break;
            }
            palabra +=matriz[i];
        }
        return palabra;
    }
    public static boolean palabraPalindroma (String palabra){
        int longitud = palabra.length();
        for (int i=0;i<longitud/2;i++){
            if (palabra.charAt(i) != palabra.charAt(longitud -1 -i)){
                return false;
            }
        }
        return true;
    }
    public int numeroDePalindromos (char[] matriz){
        int total=0;
        for (int i=0;i<matriz.length;i++){
            if (inicioDePalabraOno(matriz,i) && palabraPalindroma(palabraDadoIndex(matriz,i))){
                total++;
            }
            i += longitudPalabra(matriz,i);
        }
        return total;
    }

    public String[] matrizString (char[] matriz){
        String[] matrizString = new String[numeroDePalindromos(matriz)];
        int index=0;
        String palabra = "";
        for (int i=0;i<matriz.length;i++){
            if (inicioDePalabraOno(matriz,i) && palabraPalindroma(palabraDadoIndex(matriz,i))){
                palabra = palabraDadoIndex(matriz,i);
                matrizString[index] = palabra;
                index++;

            }
            i += longitudPalabra(matriz,i);
        }
        return matrizString;
    }

    public void imprimirMatrizString (String[] matriz){
        for (int i=0;i<matriz.length;i++){
            System.out.println(matriz[i]+ " ");
        }
    }
    public int[][] matrizBidimensional (char[] matriz){
        int[][] matrizB = new int[26][26];
        for (int i=0;i+1<matriz.length;i++){
            if (!(hayUnDelimitadorEnIndex(matriz,i)) && !(hayUnDelimitadorEnIndex(matriz,i+1))){
                matrizB[matriz[i]-97][matriz[i+1]-97] +=1;
            }
        }
        return matrizB;
    }

    char[] Alfabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public int indexDe(char caracter){

        int index=0;

        for (int i=0;i<Alfabet.length;i++){
            if (Alfabet[i]==caracter){
                index=i;
            }
        }
        return index;
    }
    public int[][] Aparicions(char[] textPerAnalitzar){

        int[][] frequencies = new int[Alfabet.length][Alfabet.length];

        int f,c;

        for ( int k = 0 ; k < textPerAnalitzar.length -1 ; k++ ){
            if (!(hayUnDelimitadorEnIndex(textPerAnalitzar,k)) && !(hayUnDelimitadorEnIndex(textPerAnalitzar,k+1))) {
                //f = indexDe(k,Alfabet);
                //c = indexDe(k+1,Alfabet);
                f = indexDe(textPerAnalitzar[k]);
                c = indexDe(textPerAnalitzar[k + 1]);
                frequencies[f][c]++;
            }
        }

        //System.out.println(frequencies[0][0]);

        return frequencies;
    }

    public void imprimirAparacions (int [][] frequencies){
        int contador=-1;
        for (int i=0;i<frequencies.length;i++){
            for (int j=0;j<frequencies.length;j++){
                contador++;
                if (contador%10==0){
                    System.out.println();
                }
                System.out.print(Alfabet[i]+"+"+Alfabet[j]+"="+frequencies[i][j]+" ");
            }
        }
    }

    public void imprimirBidi (int[][] matrizInt ){
        int contador=-1;
        for (int i = 0; i < matrizInt.length; i++) {
            for (int j = 0; j < matrizInt.length; j++) {
                contador++;
                if (contador%10 ==0){
                    System.out.println();
                }
                System.out.print(Alfabet[i]+"+"+Alfabet[j]+"= "+ matrizInt[i][j]+ " ");
            }
        }
    }

    public String[] ordenarMatrizDeString (String[] matriz){
        for ( int i = 0; i+1 < matriz.length; i++ ) {

            if ( matriz[i].length() > matriz[i + 1].length() ) {

                String original = matriz[i];
                String mayor = matriz[i + 1];
                matriz[i] = mayor;
                matriz[i + 1] = original;

            }
            for ( int j = 0; j+1 <matriz.length ; j++ ) {

                if ( matriz[j].length() > matriz[j + 1].length() ) {

                    String original = matriz[j];
                    String mayor = matriz[j + 1];
                    matriz[j] = mayor;
                    matriz[j + 1] = original;

                }
            }
        }
        return matriz;
    }

    public int indexDelElementoMasPeque (int[] matriz){
        int indexPeque=0;
        for (int i=0;i<matriz.length-1;i++){
            indexPeque=i;
            if (matriz[i]>matriz[i+1]){
                indexPeque=i;
            }
        }

        return indexPeque;
    }


    public int[] ordenarMatrizNumeros (int[] matriz){
        int[] matrizN = matriz;

        for ( int i=0;i<matrizN.length-1;i++ ){

            if ( matrizN[i]>matrizN[i+1] ){
                int numeroInicial= matriz[i];
                int masPeque = matriz[i+1];

            }
        }
        return matriz;
    }
    //int numeroMayor = M[posicion];
//        int index = posicion;
//        for (int i=posicion;i>=0;i--){
//            if ( (numeroMayor < M[i]) && (M[index] < M[i]) ){
//                index=i;
//            }
//        }
//        int valorOriginal = M[index];
//        M[index]=M[posicion];
//        M[posicion]=valorOriginal;
//        return M;
//    }
    public void imprimirMatrizNum (int[] matriz){

        for (int i=0;i<matriz.length;i++){
            System.out.print(matriz[i]+" ");
        }
    }

    public void imprimirListaVertical (String[] matriz){
        for (int i = 0; i <= matriz.length ; i++) {
            for (int j = 0; j < matriz.length ; j++) {

                if (i > matriz[j].length()-1){
                    System.out.print("  ");

                }else {
                    System.out.print(matriz[j].charAt(i));
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}