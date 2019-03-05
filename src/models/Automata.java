/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Automata {

    private ArrayList<Estado> estados;
    private ArrayList<Character> lenguaje;
    private ArrayList<Funcion> funcions;
    private Estado estadoInicial;
    private ArrayList<Estado> estadosAceptables;

    public Automata(ArrayList<Estado> estados, ArrayList<Character> lenguaje, ArrayList<Funcion> funcions, Estado estadoInicial, ArrayList<Estado> estadosAceptables) {
        this.estados = estados;
        this.lenguaje = lenguaje;
        this.funcions = funcions;
        this.estadoInicial = estadoInicial;
        this.estadosAceptables = estadosAceptables;
    }

    public Automata() {
        this.estados = new ArrayList<>();
        this.lenguaje = new ArrayList<>();;
        this.funcions = new ArrayList<>();;
        this.estadoInicial = new Estado(Status.INICIAL, "q0");
        this.estadosAceptables = new ArrayList<>();;

    }

    public void agregarEstado(String... stades) {
        for (String stade : stades) {
            estados.add(new Estado(stade));
        }
    }

    public void agregarLenguaje(char... c) {
        for (int i = 0; i < c.length; i++) {
            lenguaje.add(c[i]);
        }

    }

    public void agregarFuncion(Funcion... f) {
        for (Funcion f1 : f) {
            funcions.add(f1);
        }
    }

    public void selecionarEstadoinicial(String estado) {
        Estado s = new Estado(estado);
        if (estados.contains(s)) {
            this.estadoInicial = s;
        }

    }

    public void agregarEstadoAceptables(String... stades) {
        for (String stade : stades) {
            Estado s = new Estado(Status.TRANSICION, stade);
            System.out.println("putooooooo1");
            estadosAceptables.add(s);
            System.out.println("putooooooo");

        }
    }

    public void mostrar() {
        System.out.print("Q\t{ ");
        for (Estado estado : estados) {
            System.out.print(estado.getName() + " , ");
        }
        System.out.print("}\nL\t{ ");
        for (Character character : lenguaje) {
            System.out.print(character + " , ");
        }
        System.out.print("}\n F\t{ ");
        for (Funcion f : funcions) {
            System.out.print(f.toString() + " , ");
        }
        System.out.print("}\nS0\t{ " + estadoInicial.getName() + "}\nSA\t{ ");
        for (Estado e : estadosAceptables) {
            System.out.print(e.getName());
        }
        System.out.println("}");
    }

   
}
