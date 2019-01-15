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
public class Turno {
   private int id_turno;
   private Admin admin;
   private Banda band;
   private LocalDateTime fecha;
   private int monto;
   private String pagado= "no";
   private int estado;

    public int getId_turno() {
        return id_turno;
    }

    public void setId_turno(int id_turno) {
        this.id_turno = id_turno;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Banda getBand() {
        return band;
    }

    public void setBand(Banda band) {
        this.band = band;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }


    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getPagado() {
        return pagado;
    }

    public void setPagado(String pagado) {
        this.pagado = pagado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

   
   
    public Turno() {
    }

    public Turno(int id_turno, Admin admin, Banda band, LocalDateTime fecha, int monto, int estado) {
        this.id_turno = id_turno;
        this.admin = admin;
        this.band = band;
        this.fecha = fecha;
        this.monto = monto;
        this.estado = estado;
    }

    public Turno(Admin admin, Banda band, LocalDateTime fecha) {
        this.band = band;
        this.fecha = fecha;
    }
   
}
