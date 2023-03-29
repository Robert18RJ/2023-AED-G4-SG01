public class Principal {
    public static void main(String[] args) {
        /*
         * Bolsa<Golosina> bolsaCho = new Bolsa<Golosina>(0);
         * Golosina c = new Golosina("milka");
         * Golosina c1 = new Golosina("milka");
         * Golosina c2 = new Golosina("ferrero");
         * bolsaCho.add(c);
         * bolsaCho.add(c1);
         * bolsaCho.add(c2);
         * for (Golosina Golosina : bolsaCho) {
         * System.out.println(Golosina.getMarca());
         * }
         */

        Bolsa<Golosina> bolsaGolo = new Bolsa<Golosina>(0);
        Golosina c = new Golosina("milka", 34.0);
        Golosina c1 = new Golosina("milka", 10.0);
        Golosina c2 = new Golosina("ferrero", 20.0);
        bolsaGolo.add(c);
        bolsaGolo.add(c1);
        bolsaGolo.add(c2);
        for (Golosina Golosina : bolsaGolo) {
            System.out.printf("Nombre: %s" + "\t" + "Peso: %.2f" + "\n", Golosina.getNombre(), Golosina.getPeso());// %s=String

        }
    }

}