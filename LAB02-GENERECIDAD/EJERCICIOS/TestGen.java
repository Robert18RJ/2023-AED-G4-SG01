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
    /*String[] v = { "Perez", "Sanchez", "Rodriguez" };
    Integer[] w = { 12, 34, 56 };

    System.out.println(exist(v, "Sanchez"));
    System.out.println(exist(w, 34));
    System.out.println(exist(w, "Salas"));*/

    Cajoneria<Golosina> cajoneria = new Cajoneria<>(5);
    cajoneria.add(new Caja<>(new Golosina("Chocolatina", 20), "Rojo"));
    cajoneria.add(new Caja<>(new Golosina("Gomitas", 30), "Azul"));
    cajoneria.add(new Caja<>(new Golosina("Caramelos", 15), "Verde"));
    cajoneria.add(new Caja<>(new Golosina("Chicles", 10), "Amarillo"));
    cajoneria.add(new Caja<>(new Golosina("Mentas", 5), "Morado"));

    // Buscar por nombre
    System.out.println(cajoneria.search(new Golosina("Gomitas", 30)));
    System.out.println(cajoneria.search(new Golosina("Mentas", 5)));

    // Buscar por peso
    System.out.println(cajoneria.search(new Golosina("", 15)));
    System.out.println(cajoneria.search(new Golosina("", 25)));

    // Eliminar una golosina existente
    Golosina gomitas = new Golosina("Gomitas", 30);
    System.out.println(cajoneria.delete(gomitas));
    System.out.println(cajoneria); // Verificar que la golosina fue eliminada

    // Eliminar una golosina inexistente
    Golosina chocolates = new Golosina("Chocolatina", 10);
    System.out.println(cajoneria.delete(chocolates));
    System.out.println(cajoneria); // Verificar que la cajoneria no se modificó


    //Ejercicio 6

    Cajoneria<Chocolatina> cajoneria = new Cajoneria<>(5);
    cajoneria.add(new Caja<>(new Chocolatina("Hershey's", "Blanco"), "Rojo"));
    cajoneria.add(new Caja<>(new Chocolatina("Milka", "Negro"), "Azul"));
    cajoneria.add(
      new Caja<>(new Chocolatina("Ferrero Rocher", "Leche"), "Verde")
    );
    cajoneria.add(new Caja<>(new Chocolatina("Kinder", "Blanco"), "Amarillo"));
    cajoneria.add(new Caja<>(new Chocolatina("KitKat", "Negro"), "Morado"));

    // Buscar por marca
    System.out.println(cajoneria.search(new Chocolatina("Milka", "")));
    System.out.println(cajoneria.search(new Chocolatina("Kinder", "")));

    // Buscar por tipo
    System.out.println(cajoneria.search(new Chocolatina("", "Negro")));
    System.out.println(cajoneria.search(new Chocolatina("", "Leche")));

    // Eliminar una chocolatina existente
    Chocolatina milka = new Chocolatina("Milka", "Negro");
    System.out.println(cajoneria.delete(milka));
    System.out.println(cajoneria); // Verificar que la chocolatina fue eliminada

    // Eliminar una chocolatina inexistente
    Chocolatina toblerone = new Chocolatina("Toblerone", "Blanco");
    System.out.println(cajoneria.delete(toblerone));
    System.out.println(cajoneria); // Verificar que la cajoneria no se modificó
  }
}
