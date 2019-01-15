/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Modelo.Banda;
import Modelo.Turno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Flor
 */
public class BandaData {
        private int id_banda;

    String sql = "";
    private Connection con = null;
    public Integer totalregistros;

    public BandaData(Conexion conexion) {
        try {
            con = conexion.getConexion();
        } catch (SQLException e) {
        }
    }
    public int verificarBanda(String nombre){
         Banda ba = buscarBanda(nombre);
         if(ba.getNombre() == null) {return 1;} else {return 0;} // 1 = agregar , 0 = no agregar
    }
  
     public int registrarBanda(Banda banda) {
        
        sql = "INSERT INTO bandas (nombre, saldo, dias_fijos) VALUES ( ? , ? , ?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, banda.getNombre());
            ps.setInt(2, 0);
            ps.setString(3, banda.getDias_fijos());

            ps.executeUpdate();
            //A continuacion obtengo el ID asignado al huesped:
            ResultSet rs = ps.getGeneratedKeys();
            
            while(rs.next()){
                id_banda = rs.getInt(1);
            }

            JOptionPane.showMessageDialog(null, "Registro Exitoso!");

        } catch (Exception e) {
            System.out.println(e);
            return banda.getId_banda();
        }
        return banda.getId_banda();
    }
     
          public int registrarBanda(String nombre, String dias) {
        
        sql = "INSERT INTO bandas (nombre, saldo, dias_fijos) VALUES ( ? , ? , ?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, nombre);
            ps.setInt(2, 0);
            ps.setString(3, dias);

            ps.executeUpdate();
            //A continuacion obtengo el ID asignado al huesped:
            ResultSet rs = ps.getGeneratedKeys();
            
            while(rs.next()){
                id_banda = rs.getInt(1);
            }

            JOptionPane.showMessageDialog(null, "Registro Exitoso!");


        } catch (Exception e) {
            System.out.println( e);
        }
        return id_banda;
    }
public Banda buscarBanda(String nombre) {
        Banda hues = new Banda(); //Instancio un objeto tipo Huesped para almacenar los datos leidos
        sql = "SELECT * FROM bandas WHERE  nombre = '" + nombre +"'";

        try {

            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            
            //Si existe este huesped, entonces se ingresara al siguiente WHILE:
            while (rs.next()) {
                hues.setId_banda(rs.getInt("id_banda"));
                hues.setNombre(rs.getString("nombre"));
                hues.setSaldo(rs.getInt("saldo"));
                hues.setDias_fijos(rs.getString("dias_fijos"));

                //System.out.println(hues.getId_huesped() + hues.getApellido() + hues.getNombre() + hues.getDni());
            }
        } catch (Exception e) { System.out.println(" error en metodo buscarBanda de BandaData");
        }
        return hues;
    }

public Banda buscarBandaporId(int id) {
        Banda hues = new Banda(); //Instancio un objeto tipo Huesped para almacenar los datos leidos
        sql = "SELECT * FROM bandas WHERE id_banda = " + id;

        try {

            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            
            //Si existe este huesped, entonces se ingresara al siguiente WHILE:
            while (rs.next()) {
                hues.setId_banda(rs.getInt("id_banda"));
                hues.setNombre(rs.getString("nombre"));
                hues.setSaldo(rs.getInt("saldo"));
                hues.setDias_fijos(rs.getString("dias_fijos"));

                //System.out.println(hues.getId_huesped() + hues.getApellido() + hues.getNombre() + hues.getDni());
            }
        } catch (Exception e) { System.out.println(" error en metodo buscarBanda de BandaData");
        }
        return hues;
    }

    //El siguiente método permite editar los datos de una banda:
    public void sumarSaldo(Banda banda, int saldo) {
        sql = "UPDATE bandas SET saldo = ? WHERE id_banda = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
           

            ps.setInt(1, saldo);
            ps.setInt(2, banda.getId_banda());
            ps.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error sumarSalgo() de banda data " + e);
        }
    }
    public void PagarDeudaTotal(Banda banda) {
        sql = "UPDATE bandas SET saldo = ? WHERE id_banda = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, 0);
            ps.setInt(2, banda.getId_banda());
            ps.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al pagar deuda()  " + e);
        }
    }
       public void PagarDeuda(Banda banda, int saldo) {
           int resto = banda.getSaldo() - saldo;
        sql = "UPDATE bandas SET saldo = ? WHERE id_banda = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, resto);
            ps.setInt(2, banda.getId_banda());
            ps.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al pagar deuda()  " + e);
        }
    }

         public DefaultTableModel mostrarbandas() {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre", "Balance" , "Dias fijos"};

        String[] registro = new String[4];

        modelo = new DefaultTableModel(null, titulos);
        
        sql = "SELECT * FROM bandas";
        
      try {
PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            

            while (rs.next()) {
                registro[0] = Integer.toString(rs.getInt("id_banda"));
                registro[1] = rs.getString("nombre");
                registro[2] = String.valueOf(rs.getInt("saldo"));
                registro[3] = rs.getString("dias_fijos");

                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }}
         
         
             public void eliminarBanda(int id_b) {
        sql = "DELETE FROM bandas WHERE id_banda = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_b);
            ps.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
         
                 public void editarBanda(String nombre, int saldo, String diasfijos, int id_banda) {
        sql = "UPDATE bandas SET nombre = ? , saldo = ? , dias_fijos = ? WHERE id_banda = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setInt(2, saldo);
            ps.setString(3, diasfijos);
            ps.setInt(4, id_banda);
            ps.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
             
    
}
