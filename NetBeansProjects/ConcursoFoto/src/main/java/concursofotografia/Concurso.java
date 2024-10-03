package concursofotografia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Concurso {
    private final List<Fotografia> fotografias;

    public Concurso() {
        fotografias = new ArrayList<>();
    }

    // Método para registrar una nueva fotografía
    public void registrarFotografia(String titulo, String autor, String nacionalidad, double puntuacion) {
        Fotografia foto = new Fotografia(titulo, autor, nacionalidad, puntuacion);
        fotografias.add(foto);
        System.out.println("Fotografía registrada exitosamente.");
    }

    // Método para mostrar la fotografía con la mayor puntuación
    public void mostrarFotografiaGanadora() {
        if (fotografias.isEmpty()) {
            System.out.println("No hay fotografías registradas.");
            return;
        }
        Fotografia ganadora = fotografias.get(0);
        for (Fotografia foto : fotografias) {
            if (foto.getPuntuacion() > ganadora.getPuntuacion()) {
                ganadora = foto;
            }
        }
        System.out.println("Fotografía Ganadora:");
        System.out.println(ganadora);
    }

    // Método para mostrar fotografías por país
    public void mostrarFotografiasPorPais(String pais) {
        boolean encontrado = false;
        for (Fotografia foto : fotografias) {
            if (foto.getNacionalidad().equalsIgnoreCase(pais)) {
                System.out.println(foto);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron fotografías del país especificado.");
        }
    }

    // Método para calcular la puntuación promedio
    public void mostrarPuntuacionPromedio() {
        if (fotografias.isEmpty()) {
            System.out.println("No hay fotografías registradas.");
            return;
        }
        double suma = 0;
        for (Fotografia foto : fotografias) {
            suma += foto.getPuntuacion();
        }
        double promedio = suma / fotografias.size();
        System.out.println("Puntuacion Promedio: " + promedio);
    }

    // Método principal para ejecutar el menú
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Concurso concurso = new Concurso();
            int opcion;
            
            do {
                System.out.println("Menu:");
                System.out.println("1. Registrar Fotografia");
                System.out.println("2. Mostrar Fotografia Ganadora");
                System.out.println("3. Mostrar Fotografias por Pais");
                System.out.println("4. Mostrar Puntuacion Promedio");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opcion: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                switch (opcion) {
                    case 1 -> {
                        System.out.print("Título: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Autor: ");
                        String autor = scanner.nextLine();
                        System.out.print("Nacionalidad: ");
                        String nacionalidad = scanner.nextLine();
                        System.out.print("Puntuacion: ");
                        double puntuacion = scanner.nextDouble();
                        scanner.nextLine(); // Consumir el salto de línea
                        concurso.registrarFotografia(titulo, autor, nacionalidad, puntuacion);
                    }
                    case 2 -> concurso.mostrarFotografiaGanadora();
                    case 3 -> {
                        System.out.print("Ingrese el pais: ");
                        String pais = scanner.nextLine();
                        concurso.mostrarFotografiasPorPais(pais);
                    }
                    case 4 -> concurso.mostrarPuntuacionPromedio();
                    case 5 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opcion no valida.");
                }
            } while (opcion != 5);
        }
    }
}
