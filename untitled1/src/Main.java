import java.util.ArrayList;
import java.util.Scanner;

class CargaNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Alumno> alumnos = new ArrayList<>();

        System.out.print("Ingrese la cantidad de alumnos: ");
        int cantidadAlumnos = scanner.nextInt();

        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.println("Alumno " + (i + 1));
            System.out.print("Nombre completo: ");
            String nombre = scanner.next();
            System.out.print("Legajo: ");
            long legajo = scanner.nextLong();

            Alumno alumno = new Alumno(nombre, legajo);
            alumno.setNombreCompleto(nombre);
            alumno.setLegajo(legajo);

            System.out.print("Ingrese la cantidad de notas: ");
            int cantidadNotas = scanner.nextInt();
            for (int j = 0; j < cantidadNotas; j++) {
                System.out.print("Cátedra: ");
                        String catedra = scanner.next();
                System.out.print("Nota: ");
                double nota = scanner.nextDouble();
                alumno.getNotas().add(new Nota(catedra, nota));
            }
            alumnos.add(alumno);
        }

        for (Alumno alumno : alumnos) {
            System.out.println("Nombre: " + alumno.getNombreCompleto());
            System.out.println("Legajo: " + alumno.getLegajo());
            System.out.println("Promedio: " + alumno.calcularPromedio());
            System.out.println();
        }
    }
}