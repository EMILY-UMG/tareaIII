import java.util.Scanner;
import java.util.ArrayList;

public class cajero {

        public static void consultarSaldo(double saldo, ArrayList<String> historial) {
            System.out.printf("Saldo actual: Q%.2f\n", saldo);
            historial.add("Consulta de saldo");
        }

        public static void depositarDinero(double[] saldo, ArrayList<String> historial) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Ingrese monto a depositar: Q");
            double monto = sc.nextDouble();

            if (monto > 0) {
                saldo[0] += monto;
                System.out.println("Su depósito ha sido exitoso.");
                consultarSaldo(saldo[0], historial);
                historial.add(String.format("Depósito de Q%.2f", monto));
            } else {
                System.out.println("Monto inválido. Debe ser positivo.");
            }
        }

        public static void retirarDinero(double[] saldo, ArrayList<String> historial) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Ingrese monto a retirar: Q");
            double monto = sc.nextDouble();

            if (monto > 0) {
                if (saldo[0] >= monto) {
                    saldo[0] -= monto;
                    System.out.println("Su retiro ha sido exitoso.");
                    consultarSaldo(saldo[0], historial);
                    historial.add(String.format("Depósito de Q%.2f", monto));
                } else {
                    System.out.println("Saldo insuficiente para realizar el retiro.");
                }
            } else {
                System.out.println("Monto inválido. Debe ser positivo.");
            }
        }

    public static void iniciarSesion() {
        Scanner sc = new Scanner(System.in);
        double[] saldo = {0};
        ArrayList<String> historial = new ArrayList<>();
        int opcion;

        do {
            System.out.println("\n--- Menú Cajero ---");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    consultarSaldo(saldo[0], historial);
                    break;
                case 2:
                    depositarDinero(saldo, historial);
                    break;
                case 3:
                    retirarDinero(saldo, historial);
                    break;
                case 4:
                    System.out.println("Gracias por usar el cajero. ¡Hasta luego!");
                    System.out.println("\nHistorial de transacciones:");
                    for (String transaccion : historial) {
                        System.out.println(transaccion);
                    }
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 4);
    }

    public static void main(String[] args) {
        iniciarSesion();
    }
}