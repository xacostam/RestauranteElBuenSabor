
import java.util.Scanner;


public class RestauranteElBuenSabor {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean menuActivo = true;
        int intentosInvalidos = 0;

        Imprimible.Encabezado();

        while (menuActivo) {
            
            System.out.println("1. Ver carta");
            System.out.println("2. Agregar producto al pedido");
            System.out.println("3. Ver pedido actual");
            System.out.println("4. Generar factura");
            System.out.println("5. Nueva mesa");
            System.out.println("0. Salir");
            System.out.println("========================================");
            System.out.print("Seleccione una opcion: ");
            
            int opcionMenu = scanner.nextInt();

            if (opcionMenu == 1) {
                
                Imprimible.mostrarCarta();
                System.out.println();

            } else if (opcionMenu == 2) {
                
                System.out.println("--- AGREGAR PRODUCTO ---");
                System.out.print("Numero de producto (1. " + Datos.menu.length + "): ");
                int numeroProducto = scanner.nextInt();
                System.out.print("Cantidad: ");
                
                int cantidad = scanner.nextInt();

                if (numeroProducto > 0 && numeroProducto <= Datos.menu.length) {
                    
                    if (cantidad > 0) {
                        
                        if (Datos.estadoMesa == 0) {
                            
                            System.out.print("Ingrese el numero de la mesa: ");
                            Datos.numeroMesa = scanner.nextInt();
                            
                            if (Datos.numeroMesa <= 0) {
                                
                                Datos.numeroMesa = 1;
                            }
                            Datos.estadoMesa = 1;
                        }
                        
                        Datos.pedidoActual.agregarItem(Datos.menu[numeroProducto - 1], cantidad);
                        System.out.println("Producto agregado al pedido.");
                        System.out.println("  -> " + Datos.menu[numeroProducto - 1].getNombre() + " x" + cantidad);
                        
                    } else {
                        
                        if (cantidad == 0) {
                            System.out.println("La cantidad no puede ser cero.");
                        } else {
                            System.out.println("Cantidad invalida. Ingrese un valor positivo.");
                        }
                    }
                } else {
                    
                    if (numeroProducto <= 0) {
                        System.out.println("El numero debe ser mayor a cero.");
                    } else {
                        System.out.println("Producto no existe. La carta tiene " + Datos.menu.length + " productos.");
                    }
                }
                System.out.println();

            } else if (opcionMenu == 3) {
                System.out.println();
                if (Utilidades.hayProductosEnPedido()) {
                    Imprimible.mostrarPedido();
                } else {
                    System.out.println("No hay productos en el pedido actual.");
                    System.out.println("Use la opcion 2 para agregar productos.");
                }
                System.out.println();

            } else if (opcionMenu == 4) {
                System.out.println();
                if (Utilidades.hayProductosEnPedido()) {
                    Factura factura = Factura.generarFactura();
                    Imprimible.imprimirFacturaCompleta(factura);
                    Datos.pedidoActual.limpiar();
                    System.out.println();
                } else {
                    System.out.println("No se puede generar factura.");
                    System.out.println("No hay productos en el pedido.");
                }

            } else if (opcionMenu == 5) {
                System.out.println();
                Utilidades.reiniciar();
                System.out.println("Mesa reiniciada. Lista para nuevo cliente.");
                System.out.println();

            } else if (opcionMenu == 0) {
                menuActivo = false;
                System.out.println("Hasta luego!");

            } else {
                System.out.println("Opcion no valida. Seleccione entre 0 y 5.");
                intentosInvalidos = intentosInvalidos + 1;
                if (intentosInvalidos > 3) {
                    System.out.println("Demasiados intentos invalidos.");
                    intentosInvalidos = 0;
                }
            }
        }

        scanner.close();
    }
    
    
}
