/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Modelo.Admin;
import Modelo.Banda;
import Modelo.Pagos;
import Modelo.Turno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Flor
 */
public class PagoData {
            String sql = "";
    private Connection con = null;
    private Turno turno;
    private Pagos pago;
    private Admin admin;
    private int id_pago = 0;
    private Banda banda;
    private LocalDateTime fecha;
    
            public PagoData(Conexion conexion) {
        try {
            con = conexion.getConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido establecer la conexion con la base de datos (Pago Data) error: " + e);
        }
    }
            
             public DefaultTableModel mostrarpagos() {
        DefaultTableModel modelo;

        String[] titulos = {"Id Pago", "Nombre Admin", "Id Turno" , "Nombre Banda", "Fecha de cobro", "Monto"};

        String[] registro = new String[6];

        modelo = new DefaultTableModel(null, titulos);

        sql = "SELECT * FROM pagos";
    
      try {
PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
 

            while (rs.next()) {
                registro[0] = Integer.toString(rs.getInt("id_pago"));
                registro[1] = rs.getString("nombre_admin");
                registro[2] = Integer.toString(rs.getInt("id_turno"));
                registro[3] = rs.getString("nombre_banda");
                registro[4] = String.valueOf(rs.getDate("fecha"));
                registro[5] = String.valueOf(rs.getString("cobro"));

                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"ERROR en metodo MOSTRAR PAGOS de PAGODATA" +e);
            return null;
        }}
             
              public DefaultTableModel totalpagos() {
        DefaultTableModel modelo;

        String[] titulos = {"Nombre Admin", "Total cobrado"};

        String[] registro = new String[2];

        modelo = new DefaultTableModel(null, titulos);

        sql = "SELECT nombre_admin, SUM(cobro) AS 'suma' FROM pagos GROUP BY nombre_admin";
    
      try {
PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
 

            while (rs.next()) {
                registro[0] = rs.getString("nombre_admin");
                registro[1] = Integer.toString(rs.getInt("suma"));


                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"ERROR en metodo MOSTRAR PAGOSTOTALES de PAGODATA" +e);
            return null;
        }}
             
            
            public void RegistrarPago(Turno turno, Admin admin, Banda bd, int saldo) {
              
        this.banda = bd;
        this.admin = admin;
      this.turno = turno;
        sql = "INSERT INTO pagos ( nombre_admin, id_turno, nombre_banda, fecha, cobro) VALUES ( ? , ? , ? , ? , ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, admin.getNombre());   
            ps.setInt(2, turno.getId_turno());
            ps.setString(3, banda.getNombre());   

         Calendar calendar = new GregorianCalendar(); 
     Date fecha = calendar.getTime();
java.sql.Date sqlhoy = new java.sql.Date(fecha.getTime());

            ps.setDate(4, sqlhoy);
            ps.setInt(5, saldo);
            
            ps.executeUpdate();

            }

         catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en agendar() de PagoData error: " + e);
            System.out.println("Error en RegistrarPago en PAGO DATA");
        }
   
        
    }
    
}
