import java.util.Scanner;
import java.util.Arrays;

public class evaluacionAcademica {


        // Función para calcular el promedio de un arreglo de notas
        public static double calcularPromedio(double[] notas) {
            double suma = 0;
            for (double nota : notas) {
                suma += nota;
            }
            return suma / notas.length;
        }

        // Función para obtener el literal según el promedio
        public static char obtenerLiteral(double promedio) {
            if (promedio >= 90) return 'A';
            else if (promedio >= 80) return 'B';
            else if (promedio >= 70) return 'C';
            else if (promedio >= 60) return 'D';
            else return 'F';
        }

        // Función para determinar si aprueba según el literal
        public static boolean estaAprobado(char literal) {
            return (literal == 'A' || literal == 'B' || literal == 'C');
        }

        // Procedimiento para mostrar el resultado de un estudiante
        public static void mostrarResultado(String nombre, double[] notas) {
            double promedio = calcularPromedio(notas);
            char literal = obtenerLiteral(promedio);
            boolean aprobado = estaAprobado(literal);

            System.out.println("Nombre del studiante: " + nombre);
            System.out.println("Cantidad de Notas: " + Arrays.toString(notas));
            System.out.printf("Su promedio es: %.2f\n", promedio);
            System.out.println("Literal asignada es: " + literal);
            System.out.println("Su resultado es: " + (aprobado ? "Aprobado ✅" : "Reprobado ❌"));
            System.out.println("---------------------------");
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int cantidad;
            do {
                System.out.print("Ingrese la cantidad de estudiantes (máximo 5): ");
                cantidad = sc.nextInt();
                sc.nextLine(); // limpiar
                if (cantidad < 1 || cantidad > 5) {
                    System.out.println("Por favor, ingrese un número entre 1 y 5.");
                }
            } while (cantidad < 1 || cantidad > 5);

            String[] nombres = new String[cantidad];
            double[][] todasNotas = new double[cantidad][]; // arreglo doble para las notas

            for (int i = 0; i < cantidad; i++) {
                System.out.println("\nEstudiante " + (i + 1));
                System.out.print("Ingrese el nombre del estudiante: ");
                nombres[i] = sc.nextLine();

                System.out.print("¿Cuántas notas tiene " + nombres[i] + "? ");
                int numNotas = sc.nextInt();
                sc.nextLine();

                while (numNotas < 1) {
                    System.out.print("Debe ingresar al menos una nota. Intente de nuevo: ");
                    numNotas = sc.nextInt();
                    sc.nextLine();
                }

                double[] notas = new double[numNotas];
                for (int j = 0; j < numNotas; j++) {
                    System.out.print("Ingrese nota " + (j + 1) + ": ");
                    notas[j] = sc.nextDouble();
                }
                sc.nextLine(); // limpiar
                todasNotas[i] = notas;
            }

            System.out.println("\n=== Resultados ===");
            for (int i = 0; i < cantidad; i++) {
                mostrarResultado(nombres[i], todasNotas[i]);
            }

            sc.close();
        }
    }


