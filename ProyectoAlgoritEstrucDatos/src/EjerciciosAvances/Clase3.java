package EjerciciosAvances;

import java.util.Scanner;

public class Clase3 {

    public static class Nodo {
        int dato;
        Nodo puntero;

        public Nodo(int dato) {
            this.dato = dato;
            this.puntero = null;
        }
    }

    public static class MetodosCola {
        private Nodo frente, ultimo;

        public MetodosCola() {
            this.frente = null;
            this.ultimo = null;
        }

        public boolean estaVacio() {
            return frente == null;
        }

        public void encolar(int d) {
            Nodo nuevoDato = new Nodo(d);

            if (estaVacio()) {
                frente = nuevoDato;
                ultimo = nuevoDato;
            } else {
                ultimo.puntero = nuevoDato;
                ultimo = nuevoDato;
            }
        }

        public int desencolar() {
            if (estaVacio()) {
                System.out.println("Actualmente no hay datos en la tabla");
                ultimo = null;
            }
            int datoE = frente.dato;
            frente = frente.puntero;

            return datoE;
        }

        public int consultarFrente() {
            if (estaVacio()) {
                System.out.println("Actualmente no hay datos en la tabla");
            }

            return frente.dato;
        }
    }

    public static void main(String[] Args) {
        Scanner leer = new Scanner(System.in);

        MetodosCola mc = new MetodosCola();

        boolean seguir = true;

        System.out.println("Bienvenido al ejercicio 3, seleccione la opcion de su preferencia: ");
        do {
            System.out.println("Opcion 1: Encolar");
            System.out.println("Opcion 2: Desencolar");
            System.out.println("Opcion 3: Consultar el frente de la cola");
            System.out.println("Opcion 4: Verificar si la lista esta vacia");
            System.out.println("Opcion 5: Finalizar ejercicio 3");
            int op = leer.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Ingresar dato númerico entero a encolar: ");
                    int dato = leer.nextInt();
                    mc.encolar(dato);
                    System.out.println("El dato: " + dato + ". Se encolo con exito");
                    break;

                case 2:
                    System.out.println("Desencolando primer dato...");
                    System.out.println("Dato: " + mc.desencolar() + ". Desencolado");
                    break;

                case 3:
                    System.out.println("El dato que encabeza la cola es: " + mc.consultarFrente());
                    break;

                case 4:
                    if (mc.estaVacio()) {
                        System.out.println("La cola esta vacia");
                        break;
                    } else {
                        System.out.println("La cola no esta vacia");
                        break;
                    }

                case 5:
                    seguir = false;
                    break;
            }

        } while (seguir);

        leer.close();
    }
}