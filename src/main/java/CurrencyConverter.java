/*

*  PROYECTOS EN JAVA PARA EL CÍRCULO DE ESTUDIO
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
import java.util.TreeMap;

/*
REQ+ : Anotar justificaciones e.g. Se empleó List porque ... [descripción List]
*/
public class CurrencyConverter {
    public static void main(String[] args) {
        run();
    }

    private static String run() {
        String SEP = "* * * * * * * * * *";
        boolean salir = false;

        Map<Integer, String> divisas = new TreeMap<>();
        divisas.put(1, "MX");
        divisas.put(1, "MX");

        do {
            System.out.println(SEP);
            System.out.println("\nCurrency Converter\n\nDivisas:\n\n");

        }
        while (!salir);

        return SEP;
    }
}
