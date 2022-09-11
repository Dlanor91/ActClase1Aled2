package uy.edu.ort.aed2.entregable;

public class ListaSimpleEncadenada implements Lista {

    NodoG<Integer> primero;
    NodoG<Integer> ultimo;
    int cantNodos;

    public ListaSimpleEncadenada() {
        this.primero = null;
        this.ultimo = null;
        this.cantNodos = 0;
    }

    public NodoG<Integer> getPrimero() {
        return primero;
    }

    public void setPrimero(NodoG<Integer> primero) {
        this.primero = primero;
    }

    public NodoG<Integer> getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoG<Integer> ultimo) {
        this.ultimo = ultimo;
    }

    public int getCantNodos() {
        return cantNodos;
    }

    public void setCantNodos(int cantNodos) {
        this.cantNodos = cantNodos;
    }

    @Override
    public void agregarAlPrincipio(int valorNuevo) {
        NodoG<Integer> nuevo = new NodoG<>(valorNuevo);

        if(estaVacia()){
            setPrimero(nuevo);
            setUltimo(nuevo);
        }else{
            nuevo.setSiguiente(primero);
            primero= nuevo;
        }
        cantNodos++;
    }

    @Override
    public void agregarAlFinal(int elementoNuevo) {
        NodoG<Integer> nuevo = new NodoG<>(elementoNuevo);

        if(estaVacia()){
            setPrimero(nuevo);
            setUltimo(nuevo);
        }else{
             ultimo.setSiguiente(nuevo);
             setUltimo(nuevo);
        }
        cantNodos++;
    }

    @Override
    public int eliminarPrincipio() {

       if(!estaVacia()){
           NodoG<Integer> aux =getPrimero();
           if(primero == ultimo){
               primero = null;
               ultimo= null;
               cantNodos --;
               return aux.getDato();
           }else {
               primero = primero.siguiente;
               cantNodos --;
               return aux.getDato();
           }
       }else{
           return -1;
       }
    }

    @Override
    public int getLargo() {
        return getCantNodos();
    }

    @Override
    public boolean estaVacia() {
       return getPrimero() ==null;
    }

    @Override
    public int obtener(int indice) {
        NodoG<Integer> aux = getPrimero();
        boolean encontrado = false;
        int conteo =0;
        while(aux !=null && !encontrado){
            if(conteo ==indice ){
              encontrado = true;
            }else{
                conteo++;
                aux = aux.getSiguiente();
            }
        }
        return aux.getDato();
    }
}
