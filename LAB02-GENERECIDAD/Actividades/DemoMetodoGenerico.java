class DemoMetodoGenerico {

    static <T extends Comparable<T>> boolean igualArrays(T[] x, T[] y) {
        // Si las longitudes de los array son diferentes,
        // entonces los array son diferentes
        if (x.length != y.length)
            return false;
        for (int i = 0; i < x.length; i++)
            if (!x[i].equals(y[i]))
                return false; // arrays diferentes
        return true; // Contenido de arrays son equivalentes
    }

    public static void main(String[] args) {
        Integer nums[] = { 1, 2, 3, 4, 5 };
        Integer nums2[] = { 1, 2, 3, 4, 5 };
        Integer nums3[] = { 1, 2, 7, 4, 5 };
        Integer nums4[] = { 1, 2, 7, 4, 5, 6 };
        if (igualArrays(nums, nums))
            System.out.println("nums es igual a nums");
        if (igualArrays(nums, nums2))
            System.out.println("nums es igual a nums2");
        if (igualArrays(nums, nums3))
            System.out.println("nums es igual a num3");
        if (igualArrays(nums, nums4))
            System.out.println("nums es igual a nums4");
        //Crea un array de double                           //A
        // Double dvals[] = { 1.1, 2.2, 3.3, 4.4, 5.5 };      //B   
        // if (igualArrays(nums, dvals))                      //C   
        // System.out.println("nums es igual a dvals");       //D   
    }
}

        // 6. Descomente las lineas etiquetas con A, B, C y D del método main() del
        // ejercicio anterior y ejecute el programa. Analice lo que sucede.
        
        // Respuesta
        // Al descomentar las lineas podemos apreciar que para usar el metodo igual
        // arrays debemos ingresar parametros compatibles en este caso
        // si intentamos ingresar "nums"<Integer> "dvlas" <Double> nos saldra error en
        // momento de compilación ya que no nos dejara pasar a ejecuión sin solucionar el error.
        
        

