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
public class Estado {

    private Status status;
    private int id;
    private String name;

    public static int VAR = 0;

    public Estado (String name){
        this.name = name;
        this.id = VAR++;
        this.status = Status.TRANSICION;
    }
    public Estado(Status status, String name) {
        this.status = status;
        this.name = name;
        this.id = VAR++;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Estado = \tid   \t" + id + "\t  name    \t" + name + "\t    tipo  \t" + status;
    }

}
