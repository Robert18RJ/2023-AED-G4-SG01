    public class Test {
    public static void main(String[] args) {
        // TODO code application logic here
       
       HashC PrimerHash= new HashC(11); 
       PrimerHash.insert(34, "Elemento 1");
       PrimerHash.insert(3, "Elementon 2");
       PrimerHash.insert(7, "Elemento 3");
       PrimerHash.insert(30, "Elemento 4");
       PrimerHash.insert(11, "Elemento 5");
       PrimerHash.insert(8, "Elemento 6");
       PrimerHash.insert(7, "Elemento 7");
       PrimerHash.insert(23, "Elemento 8");
       PrimerHash.insert(41, "Elemento 9");
       PrimerHash.insert(16, "Elemento 10");
       PrimerHash.insert(34, "Elemento 11");
       
       System.out.println(PrimerHash.toString());
        HashA<String> hashTable = new HashA<>(7);

        hashTable.insert(1, "Hola");
        hashTable.insert(2, "Alfalfa");
        hashTable.insert(3, "Mnazana");
        hashTable.insert(4, "Sofa");
        hashTable.insert(5, "Pera");
        hashTable.insert(6, "Piña");
        hashTable.insert(7, "Papaya");
        hashTable.insert(34, "Durazno");
        hashTable.insert(3, "Registro3");
        hashTable.insert(7, "Melocoto");
        hashTable.insert(30, "Registro30");
        hashTable.insert(11, "Registro11");
        hashTable.insert(8, "Registro8");
        hashTable.insert(7, "Registro7_2");
        hashTable.insert(23, "Registro23");
        hashTable.insert(41, "Registro41");
        hashTable.insert(16, "Registro16");
        hashTable.insert(34, "Registro34_2");

        System.out.println(hashTable.toString());

        System.out.println("Valor asociado a la clave 4: " + hashTable.search(4));
        System.out.println("Valor asociado a la clave 8: " + hashTable.search(8));
        System.out.println("Valor asociado a la clave 34: " + hashTable.search(34));
    }
    
}