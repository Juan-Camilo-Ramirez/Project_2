public class Nodo {
    Vuelo vuelo;
    Nodo izquierda, derecha;

    public Nodo(Vuelo vuelo) {
        this.vuelo = vuelo;
        izquierda = derecha = null;
    }
}
