public class Ejercicios_basicos_DDR_33 {
    public static void main(String[] args){
        String cadena="Hola mundo";

        //CUIDADO: es 3 porque empieza en 0 las cadenas(cuarta letra)
        //el 5 es porque siempre hay que sumarle uno, ya que si no no mostraria lo que deseamos (quinta letra)
        String subcadena = cadena.substring(3,5);
        System.out.println(subcadena);
    }
}
