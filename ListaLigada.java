public class ListaLigada {
    private Nodo head;
    private Nodo tail;
    private Nodo actual;
    private int size; // Tamaño actual de la lista

    public ListaLigada() {
        this.head = null;
        this.tail = null;
        this.actual = null;
        this.size = 0;
    }

    public void add(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (this.size == 0) {
            this.head = nuevoNodo;
            this.tail = nuevoNodo;
        } else {
            this.tail.setSiguiente(nuevoNodo);
            this.tail = nuevoNodo;
        }
        this.size++;
    }

    // Nuevo método para agregar un nodo en una posición específica
    public void addAtPosition(int dato, int position) {
        if (position <= 0 || position > size + 1) {
            System.out.println("Posición inválida.");
            return;
        }

        Nodo nuevoNodo = new Nodo(dato);

        if (position == 1) { // Insertar al inicio
            nuevoNodo.setSiguiente(head);
            head = nuevoNodo;
            if (size == 0) { // Si era la lista vacía
                tail = nuevoNodo;
            }
        } else {
            Nodo actual = head;
            int indice = 1;
            while (indice < position - 1) {
                actual = actual.getSiguiente();
                indice++;
            }
            nuevoNodo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevoNodo);
            if (nuevoNodo.getSiguiente() == null) { // Si se insertó al final
                tail = nuevoNodo;
            }
        }

        size++;
        System.out.println("Nodo agregado en la posición " + position);
    }

    public void print() {
        this.actual = this.head;
        while (actual != null) {
            int dato = actual.getDato();
            System.out.println("Dato: " + dato);
            actual = actual.getSiguiente();
        }
    }

    public void modificar(int position, int nuevoDato) {
        if (position <= 0 || position > size) {
            System.out.println("Posición inválida.");
            return;
        }
        Nodo actual = head;
        int indice = 1;
        while (indice < position) {
            actual = actual.getSiguiente();
            indice++;
        }
        actual.setDato(nuevoDato);
        System.out.println("Dato modificado en la posición " + position);
    }

    public void eliminar(int position) {
        if (position <= 0 || position > size) {
            System.out.println("Posición inválida.");
            return;
        }

        if (position == 1) { // Eliminar el primer nodo
            head = head.getSiguiente();
            if (head == null) { // Si solo había un nodo
                tail = null;
            }
        } else {
            Nodo actual = head;
            int indice = 1;
            while (indice < position - 1) {
                actual = actual.getSiguiente();
                indice++;
            }
            Nodo nodoAEliminar = actual.getSiguiente();
            actual.setSiguiente(nodoAEliminar.getSiguiente());
            if (nodoAEliminar == tail) { // Si se elimina el último nodo
                tail = actual;
            }
        }
        size--;
        System.out.println("Nodo eliminado en la posición " + position);
    }

    public int sizeOfList() {
        return this.size;
    }
}
