class TestGen {

    /*static <T extends Comparable<T>> boolean igualArrays(T[] x, T[] y) {
        // Si las longitudes de los array son diferentes,
        // entonces los array son diferentes
        if (x.length != y.length)
            return false;
        for (int i = 0; i < x.length; i++)
            if (!x[i].equals(y[i]))
                return false; // arrays diferentes
        return true; // Contenido de arrays son equivalentes
    }*/
    /*En este ejemplo, el método exist() toma dos argumentos: un arreglo de tipo 
    * genérico T[] y un elemento de tipo T. Utiliza un ciclo for-each para iterar sobre 
    * cada elemento del arreglo y usa el método equals() para comparar el elemento actual con el 
    * elemento que se busca. Si encuentra una coincidencia, devuelve true; de lo contrario, devuelve false.
    */
    
    public static <T> boolean exist(T[] array, T element) {
        for (T item : array) {
          if (item.equals(element)) {
            return true;
          }
        }
        return false;
    }
    public static void main(String[] args) {
        String[] v = { "Perez","Sanchez","Rodriguez" };
        Integer[] w = { 12, 34, 56 };
        
        System.out.println(exist(v,"Sanchez"));
        System.out.println(exist(w,34));
        System.out.println(exist(w,"Salas"));
       
    }
}