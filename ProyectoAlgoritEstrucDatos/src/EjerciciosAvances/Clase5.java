package EjerciciosAvances;

/*
Resumen: En este ejemplo, crearemos un programa que simula el procesamiento de
pedidos en una tienda en l&#xED;nea utilizando una cola. La tienda recibe
pedidos de productos y los procesa en el orden en que se reciben.
*/
import java.util.LinkedList;
import java.util.Queue;

class Pedido {
    String producto;
    String cliente;

    public Pedido(String producto, String cliente) {
        this.producto = producto;
        this.cliente = cliente;
    }

    public String toString() {
        return "Pedido de " + producto + " para " + cliente;
    }
}

public class Clase5 {
    public static void main(String[] args) {
        Queue<Pedido> colaPedidos = new LinkedList<>();
        // Agregar pedidos a la cola
        colaPedidos.offer(new Pedido("Camiseta", "Juan"));
        colaPedidos.offer(new Pedido("Zapatos", "Mar&#xED;a"));
        colaPedidos.offer(new Pedido("Sombrero", "Carlos"));
        // Procesar pedidos en orden
        while (!colaPedidos.isEmpty()) {
            Pedido pedidoActual = colaPedidos.poll();
            System.out.println("Procesando: " + pedidoActual);
            // Simular procesamiento (puede incluir pago, empaquetado, env&#xED;o, etc.)
        }
    }
}