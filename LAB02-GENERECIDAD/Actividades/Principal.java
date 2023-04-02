
public class Principal {
    public static void main(String[] args) {

        //--- ACTIVIDADES 4 ---
        Bolsa<Chocolatina> bolsaCho = new Bolsa<Chocolatina>(0);
        Chocolatina c = new Chocolatina("milka");
        Chocolatina c1 = new Chocolatina("milka");
        Chocolatina c2 = new Chocolatina("ferrero");
        bolsaCho.add(c);
        bolsaCho.add(c1);
        bolsaCho.add(c2);
        for (Chocolatina Chocolatina : bolsaCho) {
            System.out.println(Chocolatina.getMarca());
        }

        //--- ACTIVIADES 7 ---
        Bolsa<Golosina> bolsaGolo = new Bolsa<Golosina>(0);
        Golosina g = new Golosina("milka", 34.0);
        Golosina g1 = new Golosina("milka", 10.0);
        Golosina g2 = new Golosina("ferrero", 20.0);
        bolsaGolo.add(g);
        bolsaGolo.add(g1);
        bolsaGolo.add(g2);
        for (Golosina Golosina : bolsaGolo) {
            System.out.printf("Nombre: %s" + "\t" + "Peso: %.2f" + "\n", Golosina.getNombre(), Golosina.getPeso());// %s=String y %.2f=double

        }
    }

}