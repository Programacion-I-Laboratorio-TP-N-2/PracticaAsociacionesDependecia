import java.util.ArrayList;

class Factura {
    private String fecha;
    private int numeroFactura;
    private String cliente;
    private ArrayList<DetalleFactura> detallesFactura = new ArrayList<>();
    private double totalCalculadoFactura;

    public Factura(String fecha, int numeroFactura, String cliente) {
        this.fecha = fecha;
        this.numeroFactura = numeroFactura;
        this.cliente = cliente;
    }

    public void agregarDetalle(DetalleFactura detalle) {
        detallesFactura.add(detalle);
    }

    public void calcularMontoTotal() {
        totalCalculadoFactura = 0;
        for (DetalleFactura detalle : detallesFactura) {
            totalCalculadoFactura += detalle.getSubtotal();
        }
    }
    public void imprimirFactura() {
        System.out.println("\nFactura");
        System.out.println("Fecha: " + fecha);
        System.out.println("Número: " + numeroFactura);
        System.out.println("Cliente: " + cliente);
        System.out.println("--------------------------------------------------");
        System.out.printf("%-10s %-20s %-10s %-10s %-10s %-10s\n", "Código", "Nombre", "Cantidad", "Precio", "Desc.", "Subtotal");
        System.out.println("--------------------------------------------------");

        for (DetalleFactura detalle : detallesFactura) {
            System.out.printf("%-10d %-20s %-10d %-10.2f %-10.2f %-10.2f\n",
                    detalle.getCodigoArticulo(), detalle.getNombreArticulo(), detalle.getCantidad(),
                    detalle.getPrecioUnitario(), detalle.getDescuento(), detalle.getSubtotal());
        }

        System.out.println("--------------------------------------------------");
        System.out.printf("Total: %-48.2f\n", totalCalculadoFactura);
    }
}
