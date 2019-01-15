/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

public class Banda {
    private int id_banda;
    private String nombre;
    private int saldo= 0;
    private String dias_fijos= "";

    public int getId_banda() {
        return id_banda;
    }

    public void setId_banda(int id_banda) {
        this.id_banda = id_banda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getDias_fijos() {
        return dias_fijos;
    }

    public void setDias_fijos(String dias_fijos) {
        this.dias_fijos = dias_fijos;
    }

    public Banda(int id_banda, String nombre, int saldo, String dias_fijos) {
        this.id_banda = id_banda;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public Banda(String nombre, String dias_fijos) {
        this.nombre = nombre;
        this.dias_fijos = dias_fijos;
        this.dias_fijos = dias_fijos;
    }

    public Banda(String nombre) {
        this.nombre = nombre;
    }

    public Banda() {
    }
    
    
}