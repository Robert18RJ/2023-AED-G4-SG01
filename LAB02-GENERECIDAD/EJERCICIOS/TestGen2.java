public class TestGen2 {
    public static void main(String[] args) {
        Cajoneria<Chocolatina> cajoneria = new Cajoneria<Chocolatina>(10);

        Chocolatina c1 = new Chocolatina("Milka");
        Chocolatina c2 = new Chocolatina("Toblerone");
        Chocolatina c3 = new Chocolatina("Hershey's");

        // Agregamos las chocolatinas a la cajonería
        cajoneria.add(new Caja<Chocolatina>("Oreo", 3));        
        
        cajoneria.get(0).add(c1);
        cajoneria.get(0).add(c2);
        cajoneria.get(0).add(c3);
        
        System.out.println(cajoneria.search(new Chocolatina("Milka")));

        Chocolatina eliminada = cajoneria.eliminar(new Chocolatina("Gomitas de ositos"));
        if (eliminada != null) {
            System.out.println("Golosina eliminada: " + eliminada);
        } else {
            System.out.println("La golosina no se encuentra en la cajoneria");
        }

        // Imprimimos las chocolatinas restantes en la cajonería
        System.out.println("Chocolatinas restantes en la cajonería:");
        System.out.println(cajoneria.toString());
    }
}

