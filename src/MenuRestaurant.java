import java.util.ArrayList;
import java.util.Scanner;

public class MenuRestaurant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Plato> platosMenu = new ArrayList<>();

        char continuar;
        do {
            System.out.print("Ingrese el nombre del plato: ");
            String nombrePlato = scanner.nextLine();
            System.out.print("Ingrese el precio del plato: ");
            double precioPlato = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("¿Es una bebida? (s/n): ");
            char esBebida = scanner.next().charAt(0);
            scanner.nextLine();

            if (esBebida == 's') {
                platosMenu.add(new Plato(nombrePlato, precioPlato));
            } else {
                ArrayList<Ingrediente> ingredientes = new ArrayList<>();
                char agregarIngrediente;
                do {
                    System.out.print("Ingrese el nombre del ingrediente: ");
                    String nombreIngrediente = scanner.nextLine();
                    System.out.print("Ingrese la cantidad: ");
                    double cantidad = scanner.nextDouble();
                    System.out.print("Ingrese la unidad de medida: ");
                    String unidadMedida = scanner.nextLine();

                    ingredientes.add(new Ingrediente(nombreIngrediente, cantidad, unidadMedida));

                    System.out.print("¿Desea agregar otro ingrediente? (s/n): ");
                    agregarIngrediente = scanner.next().charAt(0);
                    scanner.nextLine();
                } while (agregarIngrediente == 's');

                platosMenu.add(new Plato(nombrePlato, precioPlato));
            }

            System.out.print("¿Desea agregar otro plato? (s/n): ");
            continuar = scanner.next().charAt(0);
            scanner.nextLine(); // Consumir el salto de línea
        } while (continuar == 's');


        System.out.println("\nMENÚ");
        for (Plato plato : platosMenu) {
            System.out.println(plato.getNombreCompleto());
            System.out.println("Precio: $" + plato.getPrecio());
            if (!plato.isEsBebida()) {
                System.out.println("Ingredientes:");
                System.out.println("Nombre\tCantidad\tUnidad de Medida");
                for (Ingrediente ingrediente : plato.ingredientes) {
                    System.out.println(ingrediente.getNombre() + "\t" + ingrediente.getCantidad() + "\t" + ingrediente.getUnidadMedida());
                }
            }
            System.out.println();

            for (Plato plato2 : platosMenu) {
                System.out.println("----------------------------------");
                System.out.println("Plato: " + plato.getNombreCompleto());
                System.out.println("Precio: $" + plato.getPrecio());

                if (!plato.isEsBebida()) {
                    System.out.println("Ingredientes:");
                    for (Ingrediente ingrediente : plato.ingredientes) {
                        System.out.printf("%-15s %-10.2f %s\n", ingrediente.getNombre(), ingrediente.getCantidad(), ingrediente.getUnidadMedida());
                    }
                }
                System.out.println("----------------------------------");
            }
        }
    }
}
