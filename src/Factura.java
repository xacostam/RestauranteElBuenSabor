
public class Factura {
    
    private final Pedido pedido;
    private final int numero;

    public Factura(Pedido pedido, int numero) {
        
        this.pedido = pedido;
        this.numero = numero;
    }

    public int getNumero() {
        
        return numero;
    }

    public Pedido getPedido() {
        
        return pedido;
    }

    public double calcularSubtotal() {
        
        return pedido.calcularSubtotal();
    }

    public double calcularDescuento() {
        
        double subtotal = calcularSubtotal();
        if (pedido.contarItemsDiferentes() > Datos.MIN_ITEMS_DESCUENTO) {
            return subtotal * Datos.TASA_DESCUENTO;
        }
        
        return 0;
    }

    public double calcularSubtotalConDescuento() {
        
        return calcularSubtotal() - calcularDescuento();
        
    }

    public double calcularIVA() {
        
        return calcularSubtotalConDescuento() * Datos.TASA_IVA;
        
    }

    public double calcularPropina() {
        
        double subtotalConDescuento = calcularSubtotalConDescuento();
        
        if (subtotalConDescuento > Datos.UMBRAL_PROPINA) {
            return (subtotalConDescuento + calcularIVA()) * Datos.TASA_PROPINA;
        }
        
        return 0;
    }

    public double calcularTotal() {
        
        return calcularSubtotalConDescuento() + calcularIVA() + calcularPropina();
        
    }
    
    public static Factura generarFactura() {
        
        return new Factura(Datos.pedidoActual, Datos.numeroFactura);
        
    }
}
