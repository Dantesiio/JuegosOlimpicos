import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Tabla {
    private List<Pais> paises;

    public Tabla() {
        paises = new ArrayList<>();
    }

    public void ingresarPais(Pais pais) {
        paises.add(pais);
    }

    public static void mostrarTablaConvencional(List<Pais> paises) {
        Collections.sort(paises);
        System.out.println("Tabla de medallería convencional:");
        for (Pais pais : paises) {
            System.out.println(pais.getNombre() + " - Oro: " + pais.getOro() + " Plata: " + pais.getPlata() + " Bronce: " + pais.getBronce());
        }
    }

    public static void mostrarTablaTotal(List<Pais> paises) {
        Comparator<Pais> comparator = new Comparator<Pais>() {
            @Override
            public int compare(Pais pais1, Pais pais2) {
                int total1 = pais1.getOro() + pais1.getPlata() + pais1.getBronce();
                int total2 = pais2.getOro() + pais2.getPlata() + pais2.getBronce();
                return Integer.compare(total2, total1);
            }
        };
        Collections.sort(paises, comparator);
        System.out.println("Tabla de total de medallas:");
        for (Pais pais : paises) {
            System.out.println(pais.getNombre() + " - Total: " + (pais.getOro() + pais.getPlata() + pais.getBronce()));
        }
    }

    public static void mostrarPaises(List<Pais> paises) {
        for (int i = 0; i < paises.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (paises.get(j).getNombre().compareTo(paises.get(j-1).getNombre()) < 0) {
                    Pais temp = paises.get(j);
                    paises.set(j, paises.get(j-1));
                    paises.set(j-1, temp);
                }
            }
        }
        System.out.println("Tabla de paises por orden alfabético:");
        for (Pais pais : paises) {
            System.out.println(pais.getNombre() + " - Oro: " + pais.getOro() + " Plata: " + pais.getPlata() + " Bronce: " + pais.getBronce());
        }
    }

}
