package com.unifranz;

//Paso 1 importamos scanner
import java.util.Scanner;


public class PruebaCajeroAutomatico {
    double SALDO = 1000.50;

    public static void main(String[] args) {
        int defaultPin = 1234;
        //Numero maximo de intentos
        int maxIntentos = 3;
        int intentos = 1;


       PruebaCajeroAutomatico cajeroAutomatico = new PruebaCajeroAutomatico();
        boolean validPin = false;
        boolean hasSession = false;

        //Paso 2 instanciar para realizar la lectura de datos
        Scanner scanner = new Scanner(System.in);

        System.out.println("*******************************************");
        System.out.println("Cajero Automático");
        System.out.println("*******************************************");
        System.out.println("Bienvenido!");
        System.out.println();

        while (validPin == false && (intentos <= maxIntentos)) {
            System.out.print("Escriba su PIN: ");
            int pin = scanner.nextInt();

            if (defaultPin == pin) {
                validPin = true;
            } else {
                System.out.println("PIN incorrecto!!");
                System.out.println("Vuelva a intentarlo!!");
            }

            intentos += 1;
        }

        if (validPin) {
            //Mostrar menu
            int menuOption = 0;
            hasSession = true;

            while(hasSession) {
                menuOption = getMenuOption(scanner);

                if (menuOption == 4) {
                    hasSession = false;
                }

                executeMenuOption(menuOption, cajeroAutomatico);
            }
        } else {
            System.out.println("Se excedio el numero de intentos!!!");
            System.out.println("El Programa se cerrará!!");
        }
    }

    public static int getMenuOption(Scanner sc) {
        int opcion = 0;
        do {
            displayMenu();

            while (!sc.hasNextInt()) {
                String input = sc.next();
                System.out.printf("\"%s\" no es una opcion valida.%n", input);

                displayMenu();
            }
            opcion = sc.nextInt();
        } while (opcion <= 0 || opcion > 4 );

        return opcion;
    }


    public static void displayMenu() {
        System.out.println("Menu PRINCIPAL");
        System.out.println("=================================");
        System.out.println("1 - Ver mi Saldo");
        System.out.println("2 - Retirar mi efectivo");
        System.out.println("3 - Depositar fondos");
        System.out.println("4 - Salir");
        System.out.print("Ingrese su opcion: ");
    }

    public static void executeMenuOption(int option, PruebaCajeroAutomatico cajeroAutomatico) {
        switch (option) {
            case 1:
                printSaldo(cajeroAutomatico.SALDO);
                break;
            case 2:
                cajeroAutomatico.SALDO = withdrawFromATM(cajeroAutomatico.SALDO);
                printSaldo(cajeroAutomatico.SALDO);
                break;
            case 3:
                cajeroAutomatico.SALDO = depositToATM(cajeroAutomatico.SALDO);
                printSaldo(cajeroAutomatico.SALDO);
                break;
            case 4:
                System.out.print("Terminando el programa!!!");
                System.exit(0);

                break;
        }
    }

    public static void printSaldo(double saldo) {
        System.out.println("**********************************************");
        System.out.println("           SALDO DE CUENTA                   ");
        System.out.println("**********************************************");
        System.out.printf("%nEl saldo de tu cuenta es: %.2f Bs.%n%n", saldo);
    }

    public static double withdrawFromATM(double initialBalance) {
        Scanner sc = new Scanner(System.in);
        double finalBalance = initialBalance;
        int option = 0;
        do {
            displayWithdrawMenu();
            while (!sc.hasNextInt()) {
                String input = sc.next();
                System.out.printf("\"%s\" no es una opcion valida.%n", input);

                displayWithdrawMenu();
            }
            option = sc.nextInt();
        } while (option <= 0 || option > 6 );

        switch (option) {
            case 1:
                finalBalance = finalBalance - 20;
                break;
            case 2:
                finalBalance = finalBalance - 40;
                break;
            case 3:
                finalBalance = finalBalance - 60;
                break;
            case 4:
                finalBalance = finalBalance - 100;
                break;

            case 5:
                finalBalance = finalBalance - 200;
                break;
            default:
                break;
        }

        System.out.println("Procesando la transacción...");

        return finalBalance;
    }

    public static double depositToATM(double balance) {
        double insertedBalance = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("**********************************************");
        System.out.println("           Menu de Depósito                   ");
        System.out.println("**********************************************");

        do {
            System.out.print("Ingrese el monto en Bs: ");
            while (!sc.hasNextDouble()) {
                String input = sc.next();
                System.out.printf("\"%s\" no es una monto valida.%n", input);

                System.out.print("Ingrese el monto en Bs: ");
            }
            insertedBalance = sc.nextDouble();
        } while (insertedBalance <= 0);
        System.out.println("Procesando la transacción...");
        return (balance + insertedBalance);
    }


    public static void displayWithdrawMenu() {
        System.out.println("********************************************");
        System.out.println("           Menu de Retiro                   ");
        System.out.println("********************************************");

        System.out.printf("%10s %50s\n", "1 - Bs. 20", "4 - Bs. 100");
        System.out.printf("%10s %50s\n", "2 - Bs. 40", "5 - Bs. 200");
        System.out.printf("%10s %50s\n", "3 - Bs. 60", "6 - Cancelar transacción");

        System.out.print("Elija el monto de retiro: ");
    }
}
