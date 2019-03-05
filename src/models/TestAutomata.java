/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author ASUS
 */
public class TestAutomata {
    
     public static void main(String[] args) {
        System.out.println("Iniciado");
        Automata a = new Automata();
        a.agregarEstado("q0", "q1", "q2");
        a.agregarLenguaje('c', 'x');
        a.agregarFuncion(new Funcion("q0", "q1", 'x'),
                new Funcion("q0", "q2", 'c'),
                new Funcion("q1", "q1", 'c'),
                new Funcion("q1", "q1", 'x'),
                new Funcion("q2", "q2", 'c'),
                new Funcion("q2", "q2", 'x'));
        a.selecionarEstadoinicial("q0");
        a.agregarEstadoAceptables("q2");
        a.mostrar();
    }
    
}
