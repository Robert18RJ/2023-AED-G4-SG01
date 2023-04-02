public class Principal_01{
    //usamos este metodo generico para agregar los elementos que necesitemos por medio de un forege y .add
    public static <T> void agregarElementos(Bolsa<T> bolsa, T... elementos) {
        for (T elemento : elementos) {
            bolsa.add(elemento);
        }
    }
    public static void main(String[] args) {

        Bolsa<Golosina> bolsaGolo = new Bolsa<>(0);
        agregarElementos(bolsaGolo,
                new Golosina("milka", 34.0),
                new Golosina("milka", 10.0),
                new Golosina("ferrero", 20.0)
        );  
        for (Golosina golosina : bolsaGolo) {
            System.out.printf("Nombre: %s\tPeso: %.2f\n", golosina.getNombre(), golosina.getPeso());
        }
    } 
}
