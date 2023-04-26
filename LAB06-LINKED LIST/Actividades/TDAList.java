package Actividades;

public interface TDAList<T> {
    //metodos abstractos
    boolean isEmptyList();//: determina si la lista está vacía
    int length();//determina la cantidad (longitud) de elementos que hay en la lista
    void destroyList();//elimina los elementos de la lista dejándola vacía
    int search(T x);//verifica si el elemento x está o no en la lista, si está retorna su posición.
    
    void insertFirst(T x);//inserta el nuevo elemento x al inicio de la lista
    void insertLast(T x);// inserta el nuevo elemento x al final de la lista
    void removeNode(T x);//elimina el elemento x de la lista
}


