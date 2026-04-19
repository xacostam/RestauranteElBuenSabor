import java.util.ArrayList;
import java.util.List;

public class Pedido {
    
     private final List<ItemPedido> items = new ArrayList<>();

     
    public void agregarItem(Producto producto, int cantidad) {
        
        //Recorre la lista, si el producto ya está en el pedido, solo aumenta la cantidad
        
        
        for (ItemPedido item : items) {
            if (item.getProducto().getNombre().equals(producto.getNombre())) {
                item.setCantidad(item.getCantidad() + cantidad);
                return;
            }
        }
        
        //Si no está, lo agrega como uno nuevo
        items.add(new ItemPedido(producto, cantidad));
    }

    public double calcularSubtotal() {
        double subtotal = 0;
        for (ItemPedido item : items) {
            subtotal = subtotal + item.calcularSubtotal();
        }
        return subtotal;
    }

    public int contarItemsDiferentes() {
        return items.size();
    }

    public boolean tieneProductos() {
        return !items.isEmpty();
    }

    public List<ItemPedido> getItems() {
        return items;
    }

    public void limpiar() {
        items.clear();
    }
}
