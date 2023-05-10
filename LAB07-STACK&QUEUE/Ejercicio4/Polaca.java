package Ejercicio4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Polaca {

    private Map<Character, Integer> precedencia;

    public Polaca() {
        precedencia = new HashMap<>();
        precedencia.put('^', 4);
        precedencia.put('*', 3);
        precedencia.put('/', 3);
        precedencia.put('+', 2);
        precedencia.put('-', 2);
        precedencia.put('(', 1);
    }

    public String inToPos(String infija) {
        Stack<Character> pila = new Stack<>();
        String posfija = "";

        for (int i = 0; i < infija.length(); i++) {
            char c = infija.charAt(i);
            if (Character.isDigit(c)) {
                posfija += c;
            } else if (c == '(') {
                pila.push(c);
            } else if (c == ')') {
                while (!pila.isEmpty() && pila.peek() != '(') {
                    posfija += pila.pop();
                }
                pila.pop();
            } else {
                while (!pila.isEmpty() && precedencia.getOrDefault(c, 0) <= precedencia.getOrDefault(pila.peek(), 0)) {
                    posfija += pila.pop();
                }
                pila.push(c);
            }
        }

        while (!pila.isEmpty()) {
            posfija += pila.pop();
        }

        return posfija;
    }

    public int resultExpresion(String posfija) {
        Stack<Integer> pila = new Stack<>();

        for (int i = 0; i < posfija.length(); i++) {
            char c = posfija.charAt(i);
            if (Character.isDigit(c)) {
                pila.push(c - '0');
            } else {
                int operando2 = pila.pop();
                int operando1 = pila.pop();
                switch (c) {
                    case '+':
                        pila.push(operando1 + operando2);
                        break;
                    case '-':
                        pila.push(operando1 - operando2);
                        break;
                    case '*':
                        pila.push(operando1 * operando2);
                        break;
                    case '/':
                        pila.push(operando1 / operando2);
                        break;
                    case '^':
                        pila.push((int) Math.pow(operando1, operando2));
                        break;
                }
            }
        }

        return pila.pop();
    }

    public void readFile(String ruta) {
        try {
            File archivo = new File(ruta);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;

            while ((linea = br.readLine()) != null) {
                String infija = linea.substring(1, linea.length() - 1);
                String posfija = inToPos(infija);
                int resultado = resultExpresion(posfija);
                System.out.println("Expresión infija: " + infija);
                System.out.println("Expresión posfija: " + posfija);
                System.out.println("Resultado: " + resultado + "\n");
            }

            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
