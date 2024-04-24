package com.marcohuaiquin;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consultaMoneda = new ConsultaMoneda();
        int opcion = -1;
        while (opcion != 7) {
            System.out.println("");
            System.out.println("**************************************************");
            System.out.println("");
            System.out.println("Sea bienvenido al conversor de monedas :)");
            System.out.println("");
            System.out.println("1) Dólar estadounidense =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar estadounidense");
            System.out.println("3) Dólar estadounidense =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar estadounidense");
            System.out.println("5) Dólar estadounidense =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar estadounidense");
            System.out.println("7) Salir");
            System.out.println("");
            System.out.println("Elija una opción válida: ");
            try {
                opcion = Integer.valueOf(lectura.nextLine());
                System.out.println("");
                if (opcion >= 1 && opcion <= 7) {
                    if (opcion < 7) {
                        System.out.println("Ingrese el valor que desea convertir: ");
                        
                        double valor = Double.valueOf(lectura.nextLine());
                        String monedaOrigen, monedaDestino;
                        switch (opcion) {
                            case 1:
                                monedaOrigen = "USD";
                                monedaDestino = "ARS";
                                break;
                            case 2:
                                monedaOrigen = "ARS";
                                monedaDestino = "USD";
                                break;
                            case 3:
                                monedaOrigen = "USD";
                                monedaDestino = "BRL";
                                break;
                            case 4:
                                monedaOrigen = "BRL";
                                monedaDestino = "USD";
                                break;
                            case 5:
                                monedaOrigen = "USD";
                                monedaDestino = "COP";
                                break;
                            case 6:
                                monedaOrigen = "COP";
                                monedaDestino = "USD";
                                break;
                            default:
                                System.out.println("La opción ingresada no es válida.");
                                continue;
                        }
                        Double resultado = consultaMoneda.convierteMoneda(monedaOrigen, monedaDestino, valor);
                        System.out.println(String.format("El valor %s [%s] corresponde al valor final de =>>> %s [%s]", valor, monedaOrigen, resultado, monedaDestino));
                        System.out.println("");
                    }
                }
                else {
                    System.out.println("La opción ingresada no es válida.");
                }
            }
            catch (NumberFormatException nfe) {
                System.out.println("La opción ingresada no es válida.");
            }
            catch (RuntimeException rte) {
                System.out.println("Resultado no encontrado");
            }
        }
        System.out.println("Adiós :D");
        System.out.println("");
        lectura.close();
    }
}