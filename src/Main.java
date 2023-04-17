import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class Main {
    private static ArrayList<Pais> paises = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("----------MENU----------");
            System.out.println("1. Ingresar un país");
            System.out.println("2. Mostrar medallería");
            System.out.println("3. Mostrar total de medallas");
            System.out.println("4. Mostrar países");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingresa un país con el formato (nombre::oro::plata:bronce) ");
                    ingresarPais(sc);
                    break;
                case 2:
                    Tabla.mostrarTablaConvencional(paises);
                    break;
                case 3:
                    Tabla.mostrarTablaTotal(paises);
                    break;
                case 4:
                    Tabla.mostrarPaises(paises);
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 0);
    }
    /**
     * Este método recibe una instancia de la clase Scanner como argumento para leer la entrada del usuario.
     * Lee una medalla ingresada por el usuario y la agrega a la lista de medallas del país correspondiente o crea un nuevo país si no existe.
     *
     * @param sc Una instancia de la clase Scanner para leer la entrada del usuario.
     */
    public static void ingresarPais(Scanner sc) {
        // Lee la medalla ingresada por el usuario y la divide en partes
        String medalla = sc.next();
        String[] partes = medalla.split("::");
        String nombre = partes[0];
        String tipoMedalla = partes[1];
        int cantidad = Integer.parseInt(partes[2]);

        // Busca el país correspondiente en la lista de países
        boolean encontrado = false;
        for (Pais pais : paises) {
            if (pais.getNombre().equals(nombre)) {
                encontrado = true;
                // Añade la cantidad de medallas correspondiente
                if (tipoMedalla.equals("oro")) {
                    pais.sumarOro(cantidad);
                } else if (tipoMedalla.equals("plata")) {
                    pais.sumarPlata(cantidad);
                } else if (tipoMedalla.equals("bronce")) {
                    pais.sumarBronce(cantidad);
                }
                break;
            }
        }

        // Si no se encontró el país, crea una nueva instancia de la clase Pais y la agrega a la lista de países
        if (!encontrado) {
            Pais nuevoPais = new Pais(nombre, 0, 0, 0);
            if (tipoMedalla.equals("oro")) {
                nuevoPais.sumarOro(cantidad);
            } else if (tipoMedalla.equals("plata")) {
                nuevoPais.sumarPlata(cantidad);
            } else if (tipoMedalla.equals("bronce")) {
                nuevoPais.sumarBronce(cantidad);
            }
            paises.add(nuevoPais);
        }
    }

}