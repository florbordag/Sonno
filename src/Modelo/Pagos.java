/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDateTime;

/**
 *
 * @author Flor
 */
public class Pagos {
    private int id_pago;
    private String nombre_admin;
    private String nombre_banda;
    private LocalDateTime fecha;
    private int cobro;
    private Admin admin;
    private Banda banda;
    private Turno turno;

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

    
    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public String getNombre_admin() {
        return nombre_admin;
    }

    public void setNombre_admin(String nombre_admin) {
        this.nombre_admin = nombre_admin;
    }

    public String getNombre_banda() {
        return nombre_banda;
    }

    public void setNombre_banda(String nombre_banda) {
        this.nombre_banda = nombre_banda;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getCobro() {
        return cobro;
    }

    public void setCobro(int cobro) {
        this.cobro = cobro;
    }

    public Pagos() {
    }

    public Pagos(int id_pago, String nombre_admin, String nombre_banda, LocalDateTime fecha, int cobro, Admin admin, Banda banda, Turno turno) {
        this.id_pago = id_pago;
        this.nombre_admin = nombre_admin;
        this.nombre_banda = nombre_banda;
        this.fecha = fecha;
        this.cobro = cobro;
        this.admin = admin;
        this.banda = banda;
        this.turno = turno;
    } 
}
