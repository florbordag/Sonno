/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Flor
 */
public class Admin {
    private String nombre;
    private String pass;
    private int id_admin;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }
    
    
    public Admin(){};

    public Admin( int id_admin, String nombre, String pass) {
        this.nombre = nombre;
        this.pass = pass;
        this.id_admin = id_admin;
    }

    public Admin(String nombre, String pass) {
        this.nombre = nombre;
        this.pass = pass;
    }
    
    
}
