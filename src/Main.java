import java.util.Scanner;

class DoublyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public void insertAtHead(E value) {
        Node<E> newNode = new Node<E>(value);
        if (null == head) {
            newNode.next = null;
            newNode.prev = null;
            head = newNode;
            tail = newNode;
            size++;
        } else {
            newNode.next = head;
            newNode.prev = null;
            head.prev = newNode;
            head = newNode;
            size++;
        }
    }

    public void insertAtTail(E value) {
        Node<E> newNode = new Node<E>(value);
        if (null == tail) {
            newNode.next = null;
            newNode.prev = null;
            head = newNode;
            tail = newNode;
            size++;
        } else {
            tail.next = newNode;
            newNode.next = null;
            newNode.prev = tail;
            tail = newNode;
            size++;
        }
    }

    public void traverseForward() {
        Node<E> temp = head;
        while (temp != null) {
            System.out.println(temp.item);
            temp = temp.next;
        }
    }

    public void traverseBackward() {
        Node<E> temp = tail;
        while (temp != null) {
            System.out.println(temp.item);
            temp = temp.prev;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node<E> searchByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public Node<E> searchByValue(E value) {
        Node<E> temp = head;

        while (temp != null) {
            if (temp.item.equals(value)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void deleteFromHead() {
        if (head == null) return;

        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        size--;
    }

    public void deleteFromTail() {
        if (tail == null) return;

        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        }
        size--;
    }

    public static class Node<T> {

        T item;
        Node<T> next;
        Node<T> prev;

        public Node(T item) {
            this.item = item;
        }

        public String toString() {
            return String.valueOf(item);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<>();

        int opcion;

        do {

            System.out.println("\nLista Doblemente Enlazada");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Recorrer hacia adelante");
            System.out.println("4. Recorrer hacia atras");
            System.out.println("5. Mostrar tamaño de la lista");
            System.out.println("6. Mostrar si la lista esta vacia");
            System.out.println("7. Buscar elemento por valor");
            System.out.println("8. Buscar elemento por indice");
            System.out.println("9. Borrar un elemento");
            System.out.println("0. Salir");

            System.out.print("Seleccione opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese valor: ");
                    int inicio = sc.nextInt();
                    lista.insertAtHead(inicio);
                    break;

                case 2:
                    System.out.print("Ingrese valor: ");
                    int fin = sc.nextInt();
                    lista.insertAtTail(fin);
                    break;

                case 3:
                    System.out.println("Recorrido hacia adelante:");
                    lista.traverseForward();
                    break;

                case 4:
                    System.out.println("Recorrido hacia atras:");
                    lista.traverseBackward();
                    break;

                case 5:
                    System.out.println("Tamaño de la lista: " + lista.size());
                    break;

                case 6:
                    if (lista.isEmpty())
                        System.out.println("La lista esta vacia");
                    else
                        System.out.println("La lista NO esta vacia");
                    break;

                case 7:
                    System.out.print("Valor a buscar: ");
                    int valor = sc.nextInt();
                    Node<Integer> nodo = lista.searchByValue(valor);

                    if (nodo != null)
                        System.out.println("Elemento encontrado: " + nodo);
                    else
                        System.out.println("Elemento no encontrado");
                    break;

                case 8:
                    System.out.print("Indice a buscar: ");
                    int indice = sc.nextInt();

                    try {
                        Node<Integer> nodoIndice = lista.searchByIndex(indice);
                        System.out.println("Elemento encontrado: " + nodoIndice);
                    } catch (Exception e) {
                        System.out.println("Indice invalido");
                    }
                    break;

                case 9:
                    System.out.println("1. Borrar del inicio");
                    System.out.println("2. Borrar del final");

                    int borrar = sc.nextInt();

                    if (borrar == 1)
                        lista.deleteFromHead();
                    else if (borrar == 2)
                        lista.deleteFromTail();

                    break;

            }

        } while (opcion != 0);

        sc.close();
    }
}