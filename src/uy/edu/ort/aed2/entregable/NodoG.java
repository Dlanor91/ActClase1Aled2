package uy.edu.ort.aed2.entregable;

public class NodoG<T>{
    private T dato;
    NodoG<T> siguiente;

    public NodoG(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoG<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoG<T> siguiente) {
        this.siguiente = siguiente;
    }
}
