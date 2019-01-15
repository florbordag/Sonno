/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Modelo.Admin;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Flor
 */
public class AdminData {
    private Admin admin;
    String sql = "";
    private Connection con = null;
       
    public AdminData(Conexion conexion) {
        try {
            con = conexion.getConexion();
        } catch (SQLException e) {
        }
    }
    
            public Admin buscarAdmin(String loginnombre, String loginpass) {
        Admin hues = new Admin(); //Instancio un objeto tipoAdmin para almacenar los datos leidos
        sql = "SELECT * FROM administrador WHERE nombre = '" + loginnombre + "' AND pass = '" + loginpass + "' ";

        try {

            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            
            //Si existe este admin, entonces se ingresara al siguiente WHILE:
            while (rs.next()) {
                hues.setId_admin(rs.getInt("id_admin"));
                hues.setNombre(rs.getString("nombre"));
                hues.setPass(rs.getString("pass"));

                System.out.println("ADMINDATA id: " + hues.getId_admin()+ "  " + "usuario : " + hues.getNombre() + "  " + "pass: " + hues.getPass());
            }
        } catch (Exception e) {
        }
        return hues;
    }
                        public Admin buscarAdmin(int id) {
        Admin hues = new Admin(); //Instancio un objeto tipoAdmin para almacenar los datos leidos
        sql = "SELECT * FROM administrador WHERE id_admin = "+ id;

        try {

            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            
            //Si existe este admin, entonces se ingresara al siguiente WHILE:
            while (rs.next()) {
                hues.setId_admin(rs.getInt("id_admin"));
                hues.setNombre(rs.getString("nombre"));
                hues.setPass(rs.getString("pass"));

                System.out.println("id: " + hues.getId_admin()+ "  " + "usuario : " + hues.getNombre() + "  " + "pass: " + hues.getPass());
            }
        } catch (Exception e) {
        }
        return hues;
    }
}
