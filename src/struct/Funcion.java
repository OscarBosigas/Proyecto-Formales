/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struct;

/**
 *
 * @author ASUS
 */
public class Funcion {

    private String estado1, estado2;
    private String transicion;

    public Funcion(String estado1, String estado2, String transicion) {
        this.estado1 = estado1;
        this.estado2 = estado2;
        this.transicion = transicion;
    }

    public String getEstado1() {
        return estado1;
    }

    public void setEstado1(String estado1) {
        this.estado1 = estado1;
    }

    public String getEstado2() {
        return estado2;
    }

    public void setEstado2(String estado2) {
        this.estado2 = estado2;
    }

    public String getTransicion() {
        return transicion;
    }

    public void setTransicion(String transicion) {
        this.transicion = transicion;
    }

    @Override
    public String toString() {
        return "T(" + estado1 + "," + transicion + ") = " + estado2;
    }

}
