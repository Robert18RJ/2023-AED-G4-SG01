import javax.swing.JOptionPane;

/* consiste en un programa que va solicitando al usuario que ingrese una serie de 
textos y los va concatenando hasta que se ingresa una cadena vacía. Luego, 
muestra en una ventana el resultado final de la concatenación de todos los 
textos ingresados. */

/*podría ser útil en situaciones en las que se necesita concatenar varios
 textos para formar un mensaje o un documento. Por ejemplo, en una aplicación
  que permita escribir notas, se podría utilizar este programa para concatenar
   varios fragmentos de texto y generar una nota completa. */
   
public class Ejercicio02 {
    public static void main(String[] args){
        String texto=JOptionPane.showInputDialog(null, 
            "Introduce un texto , cadena vacia para terminar",
            "Introducir texto",                                                                     
            JOptionPane.INFORMATION_MESSAGE);

        String cadenaResultante="";
        //mientras no este vacio la cadena escrita continuo
        while(!texto.isEmpty()){
            //concatenamos el texto
            cadenaResultante+=texto;

            //reintroducimos de nuevo una cadena
            texto=JOptionPane.showInputDialog(null, 
                "Introduce un texto , cadena vacia para terminar",
                "Introducir texto",                                                                     
                JOptionPane.INFORMATION_MESSAGE);
        }
        JOptionPane.showMessageDialog(null,
            cadenaResultante,
            "Resultado", 
            JOptionPane.INFORMATION_MESSAGE);
    } 
}
