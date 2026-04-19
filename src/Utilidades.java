
public class Utilidades {
    
      public static boolean hayProductosEnPedido() {
        return Datos.pedidoActual.tieneProductos();
    }

    public static void reiniciar() {
        Datos.pedidoActual.limpiar();
        Datos.numeroMesa = 0;
        Datos.estadoMesa = 0;
    }
    
}
