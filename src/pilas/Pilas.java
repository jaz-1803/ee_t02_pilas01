/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;

public class Pilas {

    char[] pila;
    Integer tope;
    private static Integer tam;
    boolean estado = true;

    public Pilas(Integer tamanio) {
        tope = -1;
        pila = new char[tamanio];
        tam = tamanio;
    }

    public void push(char agrupador) {
        if (tope < tam - 1) {
            tope++;
            pila[tope] = agrupador;
        } else {
            System.out.println("Desbordamiento");
        }
    }

    public char pop() {
        char resultado = ' ';
        if (tope > -1) {
            resultado = pila[tope];
            tope--;
        }
        return resultado;
    }

    public char peek() {
        char resultado = ' ';
        if (tope > -1) {
            resultado = pila[tope];
        } else {
            System.out.println("Subdesbordamiento");
        }
        return resultado;
    }

    public void recorrerPila(String cadena, Pilas p) {
        System.out.println("Cadena: " + cadena);
        for (int i = 0; i < cadena.length(); i++) {
            
            if (cadena.charAt(i) == '(') {//Comprueba parentesis
                p.push(cadena.charAt(i));//SI ABRE LA AGREGA
            } else {
                if (cadena.charAt(i) == ')') {//SI CIERRA 
                    if (p.peek() == '(') {//Comprueba con tope
                        p.pop();
                    }else{
                    estado = false;
                    }
                }
            }
                if (cadena.charAt(i) == '[') {//COMPRUEBA CORCHETES
                    p.push(cadena.charAt(i));
                } else{ 
                    if (cadena.charAt(i) == ']') {
                    if (p.peek() == '[') {
                       p.pop();
                    }else
                     estado = false;
                }
                }
                    if (cadena.charAt(i) == '{') {//COMPRUEBA LLAVES
                        p.push(cadena.charAt(i));
                    } else{ if (cadena.charAt(i) == '}') {
                        if (p.peek() == '{') {
                                p.pop();
                        }else
                         estado = false;
                    }
                }
        }
    }
        
        
    

    public String imprimir() {
        
        if (estado == true) {
            String res = "Si";
            System.out.println("SI");
            return res;
        } else {
            String res = "NO";
            System.out.println("NO");
            return res;
        }
    }

    public static void main(String args[]) {
        Pilas miPila = new Pilas(6);
        miPila.recorrerPila("{[()]}", miPila);
         miPila.imprimir();
        miPila.recorrerPila("{[())]}", miPila);
          miPila.imprimir();
       miPila.recorrerPila("{[()]]", miPila);
          miPila.imprimir();
           
        
  

    }
}
