public class TestGen1 {
    public static void main(String[] args) {
        
        // 1. Crear objeto Cajoneria para almacenar Golosinas
        Cajoneria<Golosina> cajoneria = new Cajoneria<Golosina>(10);

        // 2. Agregar 5 golosinas a la cajonería
        Golosina g1 = new Golosina("Chicle de menta", 5.0);
        Golosina g2 = new Golosina("Chocolate con leche", 25.0);
        Golosina g3 = new Golosina("Paleta de fresa", 10.0);
        Golosina g4 = new Golosina("Gomitas de ositos", 15.0);
        Golosina g5 = new Golosina("Bombones de chocolate", 20.0);

        cajoneria.add(new Caja<Golosina>("rojo", 3));
        cajoneria.add(new Caja<Golosina>("amarillo", 2));

        cajoneria.get(0).add(g1);
        cajoneria.get(0).add(g2);
        cajoneria.get(0).add(g3);

        cajoneria.get(1).add(g4);
        cajoneria.get(1).add(g5);

        // 3. Verificar la existencia de golosinas en la cajonería por nombre y peso
        System.out.println(cajoneria.search(new Golosina("Paleta de fresa", 10.0)));

        // 4. Probar la funcionalidad del método delete
        Golosina eliminada = cajoneria.eliminar(new Golosina("Gomitas de ositos", 15.0));
        if (eliminada != null) {
            System.out.println("Golosina eliminada: " + eliminada);
        } else {
            System.out.println("La golosina no se encuentra en la cajoneria");
        }

        // 5. Imprimir el estado actual de la cajonería
        System.out.println(cajoneria.toString());
    }
}
