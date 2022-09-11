package uy.edu.ort.aed2.entregable;

public class Main {

    public static void main(String[] args) {
        int[] datos = {1,2,3,4,5,6,7,8,9,22,33,44};
        int[] datosDesordenados = {32,23,44,55,32,44,76,54,77,56,68,42};
        System.out.println("El valor 10 existe, devuelve false: "+busquedaBinaria(datos,10));
        System.out.println("El valor 4 existe, devuelve true: "+busquedaBinaria(datos,4));
        System.out.println("El valor 21 existe, devuelve false: "+busquedaBinaria(datos,21));
        System.out.println("El valor 33 existe, devuelve true: "+busquedaBinaria(datos,33));
        System.out.println("El valor 0 existe, devuelve false: "+busquedaBinaria(datos,0));
        System.out.println("El valor 50 existe, devuelve false: "+busquedaBinaria(datos,50));

        System.out.println("Suma total metodo normal, devuelve 144: "+sumaIter(datos));
        System.out.println("Suma total metodo recursivo, devuelve 144: "+sumaRec(datos));

        System.out.println("El maximo con valores ordenados devuelve 44: "+obtenerMaximo(datos));
        System.out.println("El maximo con valores desordenados devuelve 77: "+obtenerMaximo(datosDesordenados));

        System.out.println("Fibonacci de 2 devuelve 1: "+fibb(2));
        System.out.println("Fibonacci de 3 devuelve 2: "+fibb(3));
        System.out.println("Fibonacci de 7 devuelve 13: "+fibb(7));
        System.out.println("Fibonacci de 11 devuelve 89: "+fibb(11));
    }

    /**
     * Retorna la suma de los elementos del vector.
     *
     * @param vector Vector con números no necesariamente ordenados.
     */
    public static int sumaIter(int[] vector) {
        int sumaVector = 0;
        for(int i =0; i < vector.length; i++){
            sumaVector += vector[i];
        };

        return sumaVector;
    }

    /**
     * Retorna la suma de los elementos del vector.
     *
     * @param vector Vector con números no necesariamente ordenados.
     */
    public static int sumaRec(int[] vector) {
        return sumarRec(vector, 0, vector.length-1);
    }

    public static int sumarRec(int[] vector, int desde, int hasta){
        if(desde == hasta){
            return vector[desde];
        }else{
            int medio = (desde +hasta)/2;
            int sumaIzq = sumarRec(vector,desde, medio );
            int sumaDer = sumarRec(vector,medio+1, hasta );

            return sumaIzq + sumaDer;
        }
    }

    /**
     * Retorna el elemento máximo del vector.
     * //PRE: Vector no vacío.
     *
     * @param vector Vector con números no necesariamente ordenados.
     */
    public static int obtenerMaximo(int[] vector) {
        return obtenerMaximo(vector, 0, vector.length-1);
    }

    public static int obtenerMaximo(int[] vector, int desde, int hasta){
        if(desde == hasta){
            return vector[desde];
        }else{
            int medio = (desde + hasta)/2;
            int minIzq = obtenerMaximo(vector,desde,medio);
            int minDer = obtenerMaximo(vector,medio+1,hasta);

            return Math.max(minIzq,minDer);
        }
    }

    /**
     * Retorna true si n está en el vector, false en caso contrario.
     * PRE: El vector está ordenado
     *
     * @param vector Vector con números ordenados de forma creciente.
     */
    public static boolean busquedaBinaria(int[] vector, int n) {

        return busquedaBinariaRecursivo(vector,n,0, vector.length-1);
    }

    public static boolean busquedaBinariaRecursivo(int[] vector, int n, int desde, int hasta) {

        if(desde == hasta){
            return vector[desde] ==n;
        }
        int medio = (desde+hasta)/2;
        if(vector[medio] == n){
            return true;
        }else if(vector[medio] <n){
            return busquedaBinariaRecursivo(vector,n,medio+1, hasta);
        }
        else {
            return busquedaBinariaRecursivo(vector,n,desde, medio);
        }

    }

    /**
     * Retorna el n-ésimo número de la sucesión de fibonacci.
     *
     * @param n posición en la sucesión.
     */
    public static int fibb(int n) {

        if(n<2){
            return n;
        }else{
            return fibb(n-1) + fibb(n-2);
        }
    }

}
