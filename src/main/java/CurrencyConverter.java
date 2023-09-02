/*
*  PROYECTOS EN JAVA PARA EL CIRCULO DE ESTUDIO SESION 09 MODULO 01     AGOSTO-SEPTIEMBRE 2023
* * Currency Converter

 "La idea es desarrollar un sistema interactivo de conversión
 de divisas, en donde se tiene una lista de divisas disponible
 y se hacen conversiones entre estas divisas. El programa debe
 incluir lo siguiente:

  - Una interfaz interactiva con el usuario a partir de la terminal
  - El usuario selecciona la divisa origen y la divisa destino
  - Determina la cantidad que quiere convertir de la divisa origen a la divisa destino
  - El programa le imprime con un formato comprensible el resultado de la conversión, por ejemplo: 25 pesos mexicanos son 1.35 euros
  - El programa debe tener la opción de salir del programa y sólo en ese caso debe terminar. De lo contrario debe permitir realizar más conversiones
  - El programa debe ser resistente a entradas inesperadas y reaccionar adecuadamente a ellas
  - Se deben tener un mínimo de 10 divisas diferentes y las conversiones pueden ser entre cualesquiera dos de ellas

* */

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CurrencyConverter {
    static Map<Integer, String> divisasAbbrev = new TreeMap<>();
    static Map<Integer, Double> divisasValores = new TreeMap<>();//MSN Money, Saturday 02:52 AM 09/02/2023
    static int selectedDivisaOrigen;
    static int selectedDivisaDestino;
    static double selectedCantidad;

    public static void main(String[] args) {
        divisasAbbrev.put(1, "MXN"); // Peso mexicano
        divisasAbbrev.put(2, "USD"); // Dólar estadounidense
        divisasAbbrev.put(3, "CAD"); // Dólar canadiense
        divisasAbbrev.put(4, "EUR"); // Euro
        divisasAbbrev.put(5, "GBP"); // Libra esterlina
        divisasAbbrev.put(6, "JPY"); // Yen japonés
        divisasAbbrev.put(7, "CHF"); // Franco suizo
        divisasAbbrev.put(8, "AUD"); // Dólar australiano
        divisasAbbrev.put(9, "NZD"); // Dólar neozelandés
        divisasAbbrev.put(10, "BRL"); // Real brasileño

        divisasValores.put(1, 17.08);// "MXN"); // Peso mexicano
        divisasValores.put(2, 1.0);// "USD"); // Dólar estadounidense
        divisasValores.put(3, 1.36);// "CAD"); // Dólar canadiense
        divisasValores.put(4, 0.93);// "EUR"); // Euro
        divisasValores.put(5, 0.79);// "GBP"); // Libra esterlina
        divisasValores.put(6, 146.23);// "JPY"); // Yen japonés
        divisasValores.put(7, 0.89);// "CHF"); // Franco suizo
        divisasValores.put(8, 1.55);// "AUD"); // Dólar australiano
        divisasValores.put(9, 1.68);// "NZD"); // Dólar neozelandés
        divisasValores.put(10, 4.95);//  "BRL"); // Real brasileño
        run();
    }

    private static void run() {
        int divisaInt = 1;
        System.out.println("""
                * * * * * * * * * *
                Conversor Divisas

                Divisas:
                """);
        for (String divisaOrigen : divisasAbbrev.values()) {
            System.out.printf("%d\t%s\n", divisaInt, divisaOrigen);
            divisaInt++;
        }

        selectedDivisaOrigen = askCurrency("Selecciona divisa origen[1-10]:");
        selectedDivisaDestino = askCurrency("Selecciona divisa destino[1-10]:");

        System.out.printf("\nDetermine la cantidad a convertir de %s a %s:", divisasAbbrev.get(selectedDivisaOrigen), divisasAbbrev.get(selectedDivisaDestino));
        selectedCantidad = askDouble();

        printConversion();

        askNextAction();
    }


    private static int askInteger() {
        Scanner sc = new Scanner(System.in);
        return sc.hasNextInt() ? sc.nextInt() : askInteger(0);
    }

    @SuppressWarnings("unused")
    private static int askInteger(int i) {
        System.out.println("Entrada no valida intenta de nuevo:");
        return askInteger();
    }

    private static double askDouble() {
        Scanner sc = new Scanner(System.in);
        return sc.hasNextDouble() ? sc.nextDouble() : askDouble(0);
    }

    @SuppressWarnings("unused")
    private static double askDouble(double i) {
        System.out.println("Entrada no valida intenta de nuevo:");
        return askDouble();
    }

    private static int askCurrency(String println) {
        System.out.println(println);
        int i = askInteger();
        if (i < 1 || i > 10) {
            System.out.println("Fuera de rango");
            return askCurrency(println);
        } else return i;
    }

    private static double convertCurrency(double cantidad, int divOrigen, int divDestino) {
        return (cantidad / divisasValores.get(divOrigen)) * divisasValores.get(divDestino);
    }

    private static void printConversion() {
        System.out.printf("\n%.2f %s = %.2f %s:", selectedCantidad, divisasAbbrev.get(selectedDivisaOrigen), convertCurrency(selectedCantidad, selectedDivisaOrigen, selectedDivisaDestino), divisasAbbrev.get(selectedDivisaDestino));
    }

    private static void askNextAction() {
        System.out.println("\n\n¿Qué desea hacer a continuación?\n[1] Nueva conversión\n[2] Nueva divisa destino\n[3] Salir");
        switch (askInteger()) {
            case 1 -> run();
            case 2 -> newConversion();
            default -> System.exit(0);
        }
    }

    private static void newConversion() {
        selectedDivisaDestino = askCurrency("Selecciona divisa destino[1-10]:");
        printConversion();
        askNextAction();
    }
}