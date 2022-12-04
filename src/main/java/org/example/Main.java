package org.example;

public class Main {
    public static void main(String[] args) {
        int x = 5;
        int y = 7;
        System.out.println(compararMajorOIgual(x, y));
    }

    public static boolean compararValors(int x, int y) {
        boolean flag = true;
        if (x == y)
            return flag;
        else
            flag = false;
        return flag;
    }

    public static boolean compararMenorOIgual(int x, int y) {
        boolean result = true;
        if (x <= y)
            return result;
        else
            result = false;
        return result;
    }

    public static boolean compararMajorOIgual(int x, int y){
        boolean result = true;
        if (x >= y)
            return result;
        else
            result = false;
        return result;
    }

}