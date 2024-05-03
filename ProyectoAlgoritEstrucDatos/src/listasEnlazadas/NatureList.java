package listasEnlazadas;

public class NatureList {
    private Node head;

    NatureList() {
        this.head = null;
    }

    // Método para agregar un elemento al final de la lista
    void addElement(String value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Método para eliminar un elemento de la lista
    void removeElement(String value) {
        if (head == null) {
            return;
        }
        if (head.data.equals(value)) {
            head = head.next;
            return;
        }
        Node prev = head;
        Node curr = head.next;
        while (curr != null && !curr.data.equals(value)) {
            prev = curr;
            curr = curr.next;
        }
        if (curr != null) {
            prev.next = curr.next;
        }
    }

    // Método para buscar un elemento en la lista
    boolean searchElement(String value) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.equals(value)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Método para recorrer la lista
    void traverseList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }


}
