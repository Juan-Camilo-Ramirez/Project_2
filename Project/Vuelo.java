package Project;
//Clase principal/madre de la cual van a heredar las otras clases
public class Vuelo implements Comparable<Vuelo> {
    String horaSalida;
    String aerolinea;
    String destino;

    public Vuelo(String horaSalida, String aerolinea, String destino) {
        this.horaSalida = horaSalida;
        this.aerolinea = aerolinea;
        this.destino = destino;
    }

    @Override
    public String toString() {
        return "Vuelo de " + aerolinea + " a " + destino + " a las " + horaSalida;
    }

    @Override
    public int compareTo(Vuelo otroVuelo) {
        return this.horaSalida.compareTo(otroVuelo.horaSalida);
    }
}
