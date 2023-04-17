import java.util.ArrayList;

public class Pais implements Comparable<Pais> {
    private String nombre;
    private int oro;
    private int plata;
    private int bronce;

    public Pais(String nombre, int oro, int plata, int bronce) {
        this.nombre = nombre;
        this.oro = oro;
        this.plata = plata;
        this.bronce = bronce;
    }

    public Pais(String s, String s1, int i) {
        paises = new ArrayList<Pais>();
    }

    private ArrayList<Pais> paises;

    public void sumarOro(int cantidad) {
        oro += cantidad;
    }

    public void sumarPlata(int cantidad) {
        plata += cantidad;
    }

    public void sumarBronce(int cantidad) {
        bronce += cantidad;
    }

    public int getTotalMedallas() {
        return oro + plata + bronce;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public int getPlata() {
        return plata;
    }

    public void setPlata(int plata) {
        this.plata = plata;
    }

    public int getBronce() {
        return bronce;
    }

    public void setBronce(int bronce) {
        this.bronce = bronce;
    }

    @Override
    public String toString() {
        return nombre + " - Oros: " + oro + ", Platas: " + plata + ", Bronces: " + bronce;
    }

    @Override
    public int compareTo(Pais otro) {
        int totalOro = this.oro - otro.oro;
        if (totalOro != 0) {
            return totalOro;
        }
        int totalPlata = this.plata - otro.plata;
        if (totalPlata != 0) {
            return totalPlata;
        }
        int totalBronce = this.bronce - otro.bronce;
        return totalBronce;
    }
}

