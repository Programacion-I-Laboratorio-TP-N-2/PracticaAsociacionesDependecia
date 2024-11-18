import java.util.Scanner;

public class Facturacion {
    private static String[][] articulos={
    {"101", "Leche", "25"},
    {"102", "Gaseosa", "30"},
    {"103", "Fideos", "15"},
    {"104", "Arroz", "28"},
    {"105", "Vino", "120"},
    {"106", "Manteca", "20"},
    {"107", "Lavandina", "18"},
    {"108", "Detergente", "46"},
    {"109", "Jabon en polvo", "96"},
    {"110", "Galletas", "60"}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Facturacion facturacion = new Facturacion();

        System.out.print("Ingrese la fecha de la factura (AAAA-MM-DD): ");
        String fecha = scanner.nextLine();
        System.out.print("Ingrese el número de factura: ");
        int numeroFactura = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Ingrese el nombre del cliente: ");
        String cliente = scanner.nextLine();

        Factura factura = new Factura(fecha, numeroFactura, cliente);

        boolean continuar = true;
        while (continuar) {
            System.out.print("Ingrese el código del artículo: ");
            String codigoArticulo = scanner.nextLine();

            boolean encontrado = false;
            for (String[] articulo : Facturacion.articulos) {
                if (articulo[0].equals(codigoArticulo)) {
                    encontrado = true;
                    System.out.print("Ingrese la cantidad: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    // Crear el objeto DetalleFactura y agregarlo a la factura
                    DetalleFactura detalle = new DetalleFactura(
                            Integer.parseInt(articulo[0]), articulo[1], cantidad, Double.parseDouble(articulo[2])
                    );
                    factura.agregarDetalle(detalle);
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("El código ingresado no existe, intente nuevamente.");
            } else {
                System.out.print("¿Desea agregar otro artículo? (S/N): ");
                continuar = scanner.nextLine().equalsIgnoreCase("S");
            }
        }

        factura.calcularMontoTotal();
        factura.imprimirFactura();
    }
}
