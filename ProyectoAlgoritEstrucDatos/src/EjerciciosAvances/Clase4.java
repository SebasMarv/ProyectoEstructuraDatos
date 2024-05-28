package EjerciciosAvances;

// import java.util.Calendar;
// import java.util.Date;
// import java.util.LinkedList;
// import java.util.PriorityQueue;
// import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Clase4 {

    public static class cliente {
        String nombre;
        double tiempo;

        public cliente(String nombre, double tiempo) {
            this.nombre = nombre;
            this.tiempo = tiempo;
        }

        public String getNombre() {
            return nombre;
        }

        public double getTiempo() {
            return tiempo;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setTiempo(double tiempo) {
            this.tiempo = tiempo;
        }
    }

    public static class clienteMetodos {
        private Nodo frente, ultimo;

        public clienteMetodos() {
            this.frente = null;
            this.ultimo = null;
        }

        public boolean estaVacio() {
            return frente == null;
        }

        public void encolar(cliente c) {
            Nodo nuevoDato = new Nodo(c);

            if (estaVacio()) {
                frente = nuevoDato;
                ultimo = nuevoDato;
            } else {
                ultimo.puntero = nuevoDato;
                ultimo = nuevoDato;
            }
        }

        public String desencolar() {
            if (estaVacio()) {
                System.out.println("Actualmente no hay datos en la tabla");
                ultimo = null;
            }
            cliente clienteE = frente.datos;
            frente = frente.puntero;

            return clienteE.nombre;
        }
    }

    public static class Nodo {
        cliente datos;
        Nodo puntero;

        public Nodo(cliente datos) {
            this.datos = datos;
            this.puntero = null;
        }
    }

    public static void main(String[] Args) {
        Scanner leer = new Scanner(System.in);
        Random tiempoR = new Random();
        boolean seguir = true;
        clienteMetodos c = new clienteMetodos();
        String[] nombres = { "Bruno", "Jonas", "Sebastian", "Eddie", "Ivan" };

        System.out
                .println("Bienvenido al ejercicio 4, aqui se simulara un servicio de atención al cliente y se estimara "
                        + "el tiempo de atención promedio total de los clientes atendidos");
        System.out.println("Se atenderan 5 clientes para la siguiente simulación");
        int cantidad = 5;

        double tiempoT = 0;

        for (int i = 0; i < cantidad; i++) {
            int tiempoAM = tiempoR.nextInt(8001) + 7000;
            double tiempoAS = tiempoAM / 1000.0;
            tiempoT += tiempoAS;
            cliente nuevoC = new cliente(nombres[i], tiempoAS);
            c.encolar(nuevoC);
        }

        do {
            System.out.println("Opcion 1: Atender cliente del frente de la cola:");
            System.out.println("Opcion 2: Verificar promedio de tiempos atendidos");
            System.out.println("Opcion 3: Finalizar ejercicio 4");
            int op = leer.nextInt();
            switch (op) {
                case 1:
                    if (c.estaVacio()) {
                        System.out.println("Ya no quedan clientes por atender");
                        break;
                    } else {
                        System.out.println("Atendiendo al cliente enfrente de la cola");
                        System.out.println("Se atendio satisfactoriamente al cliente: " + c.desencolar());
                        break;
                    }

                case 2:
                    if (c.estaVacio()) {
                        System.out.println("Calculando el promedio total de tiempo de atención...");
                        System.out
                                .println("Tiempo total: " + tiempoT + ", tiempo promedio calculado: " + (tiempoT / 5));
                        break;
                    } else {
                        System.out.println("Aun queda clientes por atender");
                    }

                case 3:
                    if (c.estaVacio()) {
                        System.out.println("Saliendo de la matrix");
                        seguir = false;
                        break;
                    } else {
                        System.out.println("Aun quedan clientes por atender");
                        break;
                    }
            }

        } while (seguir);
        leer.close();
    }
}