
public class Imprimible {
     public static void Encabezado() {
        System.out.println("======================================");
        System.out.println("    RESTAURANTE " + Datos.NOMBRE_RESTAURANTE);
        System.out.println("    " + Datos.DIRECCION);
        System.out.println("    NIT: " + Datos.NIT);
        System.out.println("=======================================");
    }

    public static void mostrarCarta() {
        Encabezado();
        System.out.println("   --- NUESTRA CARTA ---  ");
        System.out.println("======================================");
        int indice = 0;
        while (indice < Datos.menu.length) {
            System.out.printf("%d. %-22s $%,.0f%n",
                (indice + 1),
                Datos.menu[indice].getNombre(),
                Datos.menu[indice].getPrecio());
            indice++;
        }
        System.out.println("========================================");
    }

    public static void mostrarPedido() {
        System.out.println("--- PEDIDO ACTUAL ---");
        for (ItemPedido item : Datos.pedidoActual.getItems()) {
            System.out.printf("%-20s x%-6d $%,.0f%n",
                item.getProducto().getNombre(),
                item.getCantidad(),
                item.calcularSubtotal());
        }
        System.out.println("--------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", Datos.pedidoActual.calcularSubtotal());
    }

    public static void imprimirFacturaCompleta(Factura factura) {
        Encabezado();
        System.out.printf("FACTURA No. %03d%n", factura.getNumero());
        System.out.println("----------------------------------------");

        for (ItemPedido item : factura.getPedido().getItems()) {
            System.out.printf("%-20s x%-6d $%,.0f%n",
                item.getProducto().getNombre(),
                item.getCantidad(),
                item.calcularSubtotal());
        }

        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", factura.calcularSubtotalConDescuento());
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", factura.calcularIVA());

        if (factura.calcularPropina() > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", factura.calcularPropina());
        }

        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", factura.calcularTotal());
        System.out.println("========================================");
        System.out.println("Gracias por su visita!");
        System.out.println("========================================");

        Datos.numeroFactura = Datos.numeroFactura + 1;
        Datos.estadoMesa = 0;
    }
}
