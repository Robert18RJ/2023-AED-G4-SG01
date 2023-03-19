package LAB01.Ejercicios;

public class mainFecha {
    public static void main(String[] args) {
        Fecha fec = new Fecha();
        fec.leer();        
        System.out.println("Dias transcurridos: "+fec.diasTranscurridos());
        System.out.println("Dia: "+fec.diaSemana());
        System.out.println("Fecha larga: "+fec.larga());        
        System.out.println("Es biesto: "+fec.bisiesto(2022));
        System.out.println("Dias de diciembre: "+fec.diasMes(12));        
        System.out.println("Fecha corta:"+fec.corta());                     
        System.out.println("Dias entre fechas: "+fec.diasEntre(fec));        
        System.out.println("Copia: "+fec.copia());
        System.out.println("Son fechas iguales?: "+fec.igualQue(fec));
        System.out.println("Es una fecha menor?: "+fec.menorQue(fec));
        System.out.println("Es una fecha mayor?: "+fec.mayorQue(fec));
    }
}