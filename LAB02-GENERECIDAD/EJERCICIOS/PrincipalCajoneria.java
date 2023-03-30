public class PrincipalCajoneria {
    public static void main(String[] args) {
        Cajoneria<Object> cajoneria = new Cajoneria<Object>(20);
        Caja<Object> caja1 = new Caja<Object>("Rojo", 5);
        Caja<Object> caja2 = new Caja<Object>("Azul", 5);

        caja1.add("Libro");
        caja1.add(42);
        caja1.add("Apuntes");
        caja2.add(3.1416);
        caja2.add("Silla");

        cajoneria.add(caja1);
        cajoneria.add(caja2);

        for (Caja<Object> caja : cajoneria) {
            System.out.println("Caja " + caja.hashCode() + " de color " + caja.getColor() + ":");
            for (Object objeto : caja) {
                System.out.println("\t" + objeto);
            }
        }
    }
}