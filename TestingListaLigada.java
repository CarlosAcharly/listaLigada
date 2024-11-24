import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestingListaLigada {
    public static void main(String[] args) throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        char respuesta;
        int dato;
        ListaLigada lista = new ListaLigada();

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Agregar dato");
            System.out.println("2. Mostrar lista");
            System.out.println("3. Modificar dato en la lista");
            System.out.println("4. Eliminar dato de la lista");
            System.out.println("5. Insertar dato en una posición específica");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            entrada = bufer.readLine();
            int opcion = Integer.parseInt(entrada);

            switch (opcion) {
                case 1:
                    System.out.print("Escribe el dato a almacenar: ");
                    entrada = bufer.readLine();
                    dato = Integer.parseInt(entrada);
                    lista.add(dato);
                    break;
                case 2:
                    System.out.println("Contenido de la lista: ");
                    lista.print();
                    break;
                case 3:
                    System.out.print("Ingresa la posición del nodo a modificar: ");
                    entrada = bufer.readLine();
                    int posicionModificar = Integer.parseInt(entrada);
                    System.out.print("Ingresa el nuevo dato: ");
                    entrada = bufer.readLine();
                    int nuevoDato = Integer.parseInt(entrada);
                    lista.modificar(posicionModificar, nuevoDato);
                    break;
                case 4:
                    System.out.print("Ingresa la posición del nodo a eliminar: ");
                    entrada = bufer.readLine();
                    int posicionEliminar = Integer.parseInt(entrada);
                    lista.eliminar(posicionEliminar);
                    break;
                case 5:
                    System.out.print("Ingresa el dato a insertar: ");
                    entrada = bufer.readLine();
                    dato = Integer.parseInt(entrada);
                    System.out.print("Ingresa la posición donde deseas insertar: ");
                    entrada = bufer.readLine();
                    int posicionInsertar = Integer.parseInt(entrada);
                    lista.addAtPosition(dato, posicionInsertar);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }

            System.out.print("¿Deseas realizar otra operación? (s/n): ");
            entrada = bufer.readLine();
            respuesta = entrada.charAt(0);
        } while (respuesta != 'n');
    }
}
