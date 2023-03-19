package LAB01.Ejercicios;

import java.util.Scanner;

class Fecha {
    int dia;
    int mes;
    int anio;
    protected int[] diasPorMes = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    protected int[] diasAcumulados = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 };
    protected int[] diasAcumuladosEnBisiesto = { 0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335 };
    Scanner entrada = new Scanner(System.in);

    public Fecha() {
        this(1, 1, 1900);
    }

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public void setDia(int d) {
        dia = d;
    }

    public void setMes(int m) {
        mes = m;
    }

    public void setAnio(int a) {
        anio = a;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    // Pedirá al usuario el día (1 a 31), el mes (1 a 12) y el año (1900 a 2050).
    public void leer() {
        System.out.print("Introduce el dia: ");
        this.dia = entrada.nextInt();
        System.out.print("Introduce el mes: ");
        this.mes = entrada.nextInt();
        System.out.print("Introduce el año: ");
        this.anio = entrada.nextInt();
        valida();
    }

    // Indicará si el año de la fecha es bisiesto o no.
    public boolean bisiesto() {
        return this.bisiesto(this.anio);
    }

    // Indicará si el año que se pase como parametro es bisiesto o no.
    public boolean bisiesto(int anio) {
        return (anio % 4 == 0) && (anio % 100 != 0) || (anio % 400 == 0);
    }

    // Devolverá el número de días del mes que se le indique (para el año de la
    // fecha).
    public int diasMes(int mes) {
        int dias = diasPorMes[mes - 1];
        if (bisiesto() && mes == 2)
            dias++;
        return dias;
    }

    // Comprobará si la fecha es correcta (entre el 1-1-1900 y el 31-12-2050).
    private void valida() {
        if (!(this.anio >= 1900 && this.anio <= 2050))
            this.anio = 1900;
        if (!(this.mes > 0 && this.mes <= 12))
            this.mes = 1;
        if (!(this.dia <= this.diasMes(this.mes)))
            this.dia = 1;
    }

    // Mostrará la fecha en formato corto (02-09-2003).
    public String corta() {
        String formato = this.dia + "-" + this.mes + "-" + this.anio;
        System.out.println(formato);
        return formato;
    }

    // Devolverá el número de días transcurridos desde el 1-1-1900 hasta la fecha.
    public int diasTranscurridos() {
        Fecha fecha = new Fecha(1, 1, 1900);
        return this.diasEntre(fecha);
    }

    // Devolverá el día de la semana de la fecha (0 para domingo, ..., 6 para
    // sábado). El 1-1-1900 fue LUNES.
    public String diaSemana() {
        String[] dias = { "lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo" };
        String diaDeLaSemana = dias[this.diasTranscurridos() % 7];
        return diaDeLaSemana;
    }

    // Mostrará la fecha en formato largo, empezando por el día de la semana (martes
    // 2 de septiembre de 2003).
    public String larga() {
        String[] meses = { "enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre",
                "octubre", "noviembre", "diciembre" };
        String formato = String.format("%s %d de %s de %d", this.diaSemana(), this.dia, meses[this.mes - 1], this.anio);
        return formato;
    }

    // Hará que la fecha sea la correspondiente a haber transcurrido los días que se
    // indiquen desde el 1-1-1900.
    public void fechaTras(long dias) {
        this.dia = 1;
        this.mes = 1;
        this.anio = 1900;
        while (dias > 0) {
            this.siguiente();
            dias--;
        }
    }

    // Devolverá el número de días entre la fecha y la proporcionada.
    public int diasEntre(Fecha fecha) {
        return Math.abs(this.diferenciaEntreFechas(fecha));
    }

    // Pasará al día siguiente.
    public void siguiente() {
        if (this.dia == diasMes(this.mes)) {
            this.dia = 1;
            if (this.mes == 12) {
                this.mes = 1;
                this.anio++;
            } else {
                this.mes++;
            }
        } else {
            this.dia++;
        }
    }

    // Pasará al día anterior.
    public void anterior() {
        if (this.dia == 1) {
            if (this.mes == 1) {
                this.dia = 31;
                this.mes = 12;
                this.anio--;
            } else {
                this.dia = 31;
                this.mes--;
            }
        } else {
            this.dia--;
        }
    }

    // Devolverá un clon de la fecha.
    public Fecha copia() {
        return new Fecha(this.anio, this.mes, this.dia);
    }

    // Indica si la fecha es la misma que la proporcionada
    public boolean igualQue(Fecha fecha) {
        return (this.anio == fecha.anio && this.mes == fecha.mes && this.dia == fecha.dia);
    }

    // Indica si la fecha es anterior a la proporcionada.
    public boolean menorQue(Fecha fecha) {
        return this.diferenciaEntreFechas(fecha) < 0;
    }

    // Indica si la fecha es posterior a la proporcionada.
    public boolean mayorQue(Fecha fecha) {
        return this.diferenciaEntreFechas(fecha) > 0;
    }

    private int diferenciaDelOrigen(int dia, int mes, int anio) {
        int dias;
        if (this.bisiesto(anio)) {
            anio--;
            int aniosBisiestos = anio / 4 - anio / 100 + anio / 400;
            dias = anio * 365 + aniosBisiestos + diasAcumuladosEnBisiesto[mes - 1] + dia - 1;
        } else {
            anio--;
            int aniosBisiestos = anio / 4 - anio / 100 + anio / 400;
            dias = anio * 365 + aniosBisiestos + diasAcumulados[mes - 1] + dia - 1;
        }
        return dias;
    }

    private int diferenciaEntreFechas(Fecha fecha) {
        int diferencia1 = diferenciaDelOrigen(fecha.dia, fecha.mes, fecha.anio);
        int diferencia2 = diferenciaDelOrigen(this.dia, this.mes, this.anio);

        return diferencia2 - diferencia1;
    }
}