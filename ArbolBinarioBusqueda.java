import javax.swing.*;

public class ArbolBinarioBusqueda {
    Nodo raiz;

    public ArbolBinarioBusqueda() {
        raiz = null;
    }

    void insertar(Vuelo vuelo) {
        raiz = insertarRec(raiz, vuelo);
    }

    Nodo insertarRec(Nodo raiz, Vuelo vuelo) {
        if (raiz == null) {
            raiz = new Nodo(vuelo);
            return raiz;
        }
        if (vuelo.compareTo(raiz.vuelo) < 0)
            raiz.izquierda = insertarRec(raiz.izquierda, vuelo);
        else if (vuelo.compareTo(raiz.vuelo) > 0)
            raiz.derecha = insertarRec(raiz.derecha, vuelo);
        return raiz;
    }

    Nodo eliminar(Nodo raiz, String horaSalida) {
        if (raiz == null) return raiz;
        if (horaSalida.compareTo(raiz.vuelo.horaSalida) < 0)
            raiz.izquierda = eliminar(raiz.izquierda, horaSalida);
        else if (horaSalida.compareTo(raiz.vuelo.horaSalida) > 0)
            raiz.derecha = eliminar(raiz.derecha, horaSalida);
        else {
            if (raiz.izquierda == null) return raiz.derecha;
            else if (raiz.derecha == null) return raiz.izquierda;
            raiz.vuelo = encontrarMin(raiz.derecha).vuelo;
            raiz.derecha = eliminar(raiz.derecha, raiz.vuelo.horaSalida);
        }
        return raiz;
    }

    Nodo encontrarMin(Nodo raiz) {
        Nodo actual = raiz;
        while (actual.izquierda != null) {
            actual = actual.izquierda;
        }
        return actual;
    }

    Vuelo encontrarMin() {
        if (raiz == null) return null;
        Nodo actual = raiz;
        while (actual.izquierda != null) {
            actual = actual.izquierda;
        }
        return actual.vuelo;
    }

    void eliminarMin() {
        if (raiz != null) {
            raiz = eliminarMin(raiz);
        }
    }

    Nodo eliminarMin(Nodo raiz) {
        if (raiz.izquierda == null) return raiz.derecha;
        raiz.izquierda = eliminarMin(raiz.izquierda);
        return raiz;
    }

    void inorder(JTextArea textArea) {
        inorderRec(raiz, textArea);
    }

    void inorderRec(Nodo raiz, JTextArea textArea) {
        if (raiz != null) {
            inorderRec(raiz.izquierda, textArea);
            textArea.append(raiz.vuelo + "\n");
            inorderRec(raiz.derecha, textArea);
        }
    }
}
