
package ListasEnlazada;

public class listaEnlazada {
    public static void main(String[] args) {
        // TODO code application logic here
        NatureList natureList = new NatureList();
        natureList.addElement("Árbol");
        natureList.addElement("Flor");
        natureList.addElement("Río");
        natureList.addElement("Montaña");

        System.out.println("Lista de elementos naturales:");
        natureList.traverseList();

        System.out.println("¿Flor está en la lista? " + natureList.searchElement("Flor"));
        System.out.println("¿Sol está en la lista? " + natureList.searchElement("Sol"));

        natureList.removeElement("Río");

        System.out.println("Lista después de eliminar el río:");
        natureList.traverseList();
    }
}
