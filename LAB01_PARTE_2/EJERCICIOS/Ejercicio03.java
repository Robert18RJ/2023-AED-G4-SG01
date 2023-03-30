import javax.swing.JOptionPane;
/*Este programa podría ser utilizado, por ejemplo, en una aplicación de registro de eventos, donde se solicita al
 usuario que introduzca los nombres de los participantes del evento. La concatenación de nombres podría ser útil 
 para mostrar una lista de participantes en la pantalla de confirmación antes de enviar la información del registro al servidor. */
public class Ejercicio03 {
    public static void main(String[] args){
        String nombre = JOptionPane.showInputDialog(null, 
                                                    "Introduce un nombre, dejar vacío para terminar",
                                                    "Introducir nombre",                                                                     
                                                    JOptionPane.INFORMATION_MESSAGE);
    
        String nombresConcatenados = "";
        while(!nombre.isEmpty()){
            nombresConcatenados += nombre + " ";
            nombre = JOptionPane.showInputDialog(null, 
                                                  "Introduce un nombre, dejar vacío para terminar",
                                                  "Introducir nombre",                                                                     
                                                  JOptionPane.INFORMATION_MESSAGE);
        }
        
        JOptionPane.showMessageDialog(null,
                                      "Los nombres concatenados son: " + nombresConcatenados.trim(),
                                      "Resultado", 
                                      JOptionPane.INFORMATION_MESSAGE);
    } 
}