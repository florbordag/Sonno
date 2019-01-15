/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Modelo.Admin;
import Modelo.Banda;
import Modelo.Turno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Flor
 */
public class TurnoData {
        String sql = "";
    private Connection con = null;
    private Turno turno;
    private AdminData ad;
    private BandaData bd;
    private int id_turno = 0;
    private Banda band;
    private LocalDateTime fecha;

    
        public TurnoData(Conexion conexion) {
        try {
            con = conexion.getConexion();
            ad = new AdminData(conexion);
            bd = new BandaData(conexion);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido establecer la conexion con la base de datos (Turno Data) error: " + e);
        }
    }

         //El siguiente método me permite insertar un nuevo turno y retorna el ID asignado al mismo:
    public int agendar(Turno tr, Admin admin, Banda bd) {
        this.band = bd;
        sql = "INSERT INTO turnos ( id_admin, id_banda, fecha, monto, pagado, estado) VALUES ( ? , ? , ? , ? , ? , ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, admin.getId_admin());   
            ps.setInt(2, bd.getId_banda());
            ps.setTimestamp(3, Timestamp.valueOf(tr.getFecha()));
            ps.setInt(4, tr.getMonto());
            ps.setString(5, tr.getPagado());
            ps.setInt(6, tr.getEstado());
            
            ps.executeUpdate();
            

            ResultSet rs = ps.getGeneratedKeys();
            
            while(rs.next()){
                id_turno = rs.getInt(1);
    
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en agendar() de TurnoData error: " + e);
            System.out.println("Error en agendar en TurnoData");
        }
        return id_turno;
        
    }
    
    
    
    
        //Este metodo verifica si la fecha del turno es anterior a la actual, si es asi, entonces el turno a caducado y se le debe
    //cambiar el estado de 1(avtiva) a 0(inactiva)
        public void verificarFecha(){
            
        sql = "UPDATE turnos SET estado = 0 WHERE fecha < NOW()+ INTERVAL 10 MINUTE";
        try {
            Statement ps = con.createStatement();
            ps.executeUpdate(sql);
  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        sql = "UPDATE turnos SET estado = 1 WHERE fecha > NOW()";
        try {
            Statement ps = con.createStatement();
            ps.executeUpdate(sql);
  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    

             public LocalDateTime proximoTurno() {
                 ArrayList<LocalDateTime> turnos = new ArrayList();
        sql = "SELECT * FROM turnos where fecha > NOW() ORDER BY fecha ASC";

        try {
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            
            //Si existe este huesped, entonces se ingresara al siguiente WHILE:
            while (rs.next()) {
java.sql.Timestamp fec = new java.sql.Timestamp(rs.getTimestamp("fecha").getTime());;
            turnos.add(fec.toLocalDateTime());
            System.out.println(turnos);


            }
        } catch (Exception e) { System.out.println(" error en metodo prooximoTurno de BandaData");
        }
        return   (LocalDateTime) turnos.get(0);}
             
                          public LocalDateTime proximoTurnodeBanda(int id_banda) {
                 ArrayList<LocalDateTime> turnos = new ArrayList();
        sql = "SELECT * FROM turnos where fecha > NOW() AND id_banda = "+ id_banda + " ORDER BY fecha ASC";

        try {
            Statement ps = con.createStatement();         
            ResultSet rs = ps.executeQuery(sql);
            
            //Si existe este huesped, entonces se ingresara al siguiente WHILE:
            while (rs.next()) {
java.sql.Timestamp fec = new java.sql.Timestamp(rs.getTimestamp("fecha").getTime());;
            turnos.add(fec.toLocalDateTime());
            System.out.println(turnos);


            }
        } catch (Exception e) { System.out.println(" error en metodo prooximoTurno de BandaData");
        }
        return   (LocalDateTime) turnos.get(0);}
             
  public int proximaBanda() {
                 ArrayList<Integer> turnos = new ArrayList();
        sql = "SELECT id_banda FROM turnos where fecha > NOW() ORDER BY fecha ASC";

        try {
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            
            //Si existe este huesped, entonces se ingresara al siguiente WHILE:
            while (rs.next()) {

            turnos.add(rs.getInt("id_banda"));
            System.out.println(turnos);


            }
        } catch (Exception e) { System.out.println(" error en metodo prooximoTurno de BandaData");
        }
        return turnos.get(0);}
  
             
             public void pagarDeuda(Banda banda, Turno turno){
                         sql ="UPDATE turnos SET pagado= 'si' WHERE id_banda ="+banda.getId_banda()+" AND id_turno =" + turno.getId_turno();
                     try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al pagar deuda()  " + e);
        }
             }

             
             public void eliminarTurno(int id_b) {
        sql = "DELETE FROM turnos WHERE id_banda = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_b);
            ps.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

             public void eliminarTurnoporid(int id_turno) {
        sql = "DELETE FROM turnos WHERE id_turno = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_turno);
            ps.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
 public DefaultTableModel mostrarturnos(Banda banda) {
        DefaultTableModel modelo;

        String[] titulos = {"Id Turno", "Banda", "fecha","Monto" , "Pagado", "estado"};

        String[] registro = new String[6];

        modelo = new DefaultTableModel(null, titulos);
        String id = String.valueOf(banda.getId_banda());
        sql = "SELECT * FROM turnos WHERE id_banda = "+ id ;
        System.out.println("Mostrar turnos de la banda con id " + id);
      try {
PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            String estado;


            while (rs.next()) {
                if ((rs.getInt("estado")) == 0) {estado = "Inactivo";} else {estado = "Activo";}
      LocalDateTime fecha = rs.getTimestamp("fecha").toLocalDateTime();
   SimpleDateFormat formateador = new SimpleDateFormat("' 'dd '/' MM '/' yy ' -' HH:mm", new Locale("es"));   
  Date fechaDate = Date.from( fecha.atZone( ZoneId.systemDefault()).toInstant());
  String fechita = formateador.format(fechaDate); 
                
                registro[0] = Integer.toString(rs.getInt("id_turno"));
                registro[1] = banda.getNombre();
                registro[2] = fechita;
                registro[3] = String.valueOf(rs.getInt("monto"));
                registro[4] = rs.getString("pagado");
                registro[5] = estado;

                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"ERROR EN METODO MOSTRAR TURNOS DE TURNODATA" +e);
            return null;
        }}
 
 public DefaultTableModel mostrarAgenda() {
        DefaultTableModel modelo;

        String[] titulos = {"Id Turno","Banda", "fecha","Monto" , "Pagado", "estado"};
        String[] registro = new String[6];
        modelo = new DefaultTableModel(null, titulos);

        sql = "SELECT * FROM turnos where fecha > NOW() ORDER BY fecha ASC";
Banda ban= new Banda();
      try {
PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            String estado;

            while (rs.next()) {
                ban= bd.buscarBandaporId(rs.getInt("id_banda"));
                if ((rs.getInt("estado")) == 0) {estado = "Inactivo";} else {estado = "Activo";}
      LocalDateTime fecha = rs.getTimestamp("fecha").toLocalDateTime();
   SimpleDateFormat formateador = new SimpleDateFormat("' ' EEEEEEE dd '/' MM '/' yy ' -' HH:mm", new Locale("es"));   
  Date fechaDate = Date.from( fecha.atZone( ZoneId.systemDefault()).toInstant());
  String fechita = formateador.format(fechaDate); 
                
                registro[0] = Integer.toString(rs.getInt("id_turno"));
                registro[1] = ban.getNombre();
                registro[2] = fechita;
                registro[3] = String.valueOf(rs.getInt("monto"));
                registro[4] = rs.getString("pagado");
                registro[5] = estado;

                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"ERROR EN METODO MOSTRAR TURNOS DE TURNODATA" +e);
            return null;
        }}
 
 public DefaultTableModel turnosviejos() {
        DefaultTableModel modelo;

        String[] titulos = {"Id Turno","Banda", "fecha","Monto" , "Pagado", "estado"};
        String[] registro = new String[6];
        modelo = new DefaultTableModel(null, titulos);

        sql = "SELECT * FROM turnos where fecha < NOW() ORDER BY fecha ASC";
Banda ban= new Banda();
      try {
PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            String estado;

            while (rs.next()) {
                ban= bd.buscarBandaporId(rs.getInt("id_banda"));
                if ((rs.getInt("estado")) == 0) {estado = "Inactivo";} else {estado = "Activo";}
      LocalDateTime fecha = rs.getTimestamp("fecha").toLocalDateTime();
   SimpleDateFormat formateador = new SimpleDateFormat("' ' EEEEEEE dd '/' MM '/' yy ' -' HH:mm", new Locale("es"));   
  Date fechaDate = Date.from( fecha.atZone( ZoneId.systemDefault()).toInstant());
  String fechita = formateador.format(fechaDate); 
                
                registro[0] = Integer.toString(rs.getInt("id_turno"));
                registro[1] = ban.getNombre();
                registro[2] = fechita;
                registro[3] = String.valueOf(rs.getInt("monto"));
                registro[4] = rs.getString("pagado");
                registro[5] = estado;

                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"ERROR EN METODO MOSTRAR TURNOS DE TURNODATA" +e);
            return null;
        }}
         
public Turno buscarTurnoporId(int id) {
        Turno hues = new Turno(); //Instancio un objeto tipo Turno para almacenar los datos leidos
        sql = "SELECT * FROM turnos WHERE id_turno = " + id;

        try {

            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            
            //Si existe este turno, entonces se ingresara al siguiente WHILE:
            while (rs.next()) {
                hues.setId_turno(id);

                hues.setAdmin(ad.buscarAdmin(rs.getInt("id_admin")));
                System.out.println("conexion admin bien");
                hues.setBand(bd.buscarBandaporId(rs.getInt("id_banda")));
                hues.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
                System.out.println("buscar turno x id: id= "+hues.getId_turno()+"fecha : "+hues.getFecha().toString());
                hues.setMonto(rs.getInt("monto"));
                hues.setPagado(rs.getString("pagado"));
                hues.setEstado(rs.getInt("estado"));
                

                //System.out.println(hues.getId_huesped() + hues.getApellido() + hues.getNombre() + hues.getDni());
            }
        } catch (Exception e) { System.out.println(" error en metodo buscarturnosporID de TurnoData");
        }
        return hues;
    }

                 public void editarTurno(int id_turno, int id_admin, LocalDateTime fecha, int monto ) {
        sql = "UPDATE turnos SET id_admin = ? , fecha = ?, monto=? WHERE id_turno = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_admin);
            ps.setTimestamp(2, Timestamp.valueOf(fecha));
            ps.setInt(3, monto);
            ps.setInt(4, id_turno);
            ps.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
                 
                 public DefaultTableModel turnosdehoy(LocalDateTime fecha1,LocalDateTime fecha2){
                     DefaultTableModel modelo;
        String[] titulos = {"Id Turno","Banda", "fecha","Monto" , "Pagado", "estado"};
        String[] registro = new String[6];
        modelo = new DefaultTableModel(null, titulos);
sql= "SELECT * FROM turnos WHERE fecha > ' " +fecha1+"' AND fecha < '"+fecha2+"' ORDER BY fecha ASC";
 try {
     Banda ban = new Banda();
PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            String estado;

            while (rs.next()) {
                ban= bd.buscarBandaporId(rs.getInt("id_banda"));
                if ((rs.getInt("estado")) == 0) {estado = "Inactivo";} else {estado = "Activo";}
      LocalDateTime fecha = rs.getTimestamp("fecha").toLocalDateTime();
   SimpleDateFormat formateador = new SimpleDateFormat("' ' EEEEEEE dd '/' MM '/' yy ' -' HH:mm");   
  Date fechaDate = Date.from( fecha.atZone( ZoneId.systemDefault()).toInstant());
  String fechita = formateador.format(fechaDate); 
                
                registro[0] = Integer.toString(rs.getInt("id_turno"));
                registro[1] = ban.getNombre();
                registro[2] = fechita;
                registro[3] = String.valueOf(rs.getInt("monto"));
                registro[4] = rs.getString("pagado");
                registro[5] = estado;

                modelo.addRow(registro);
            }
            return modelo;
                    
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"ERROR EN METODO TURNOSdeHOY() DE TURNODATA" +e);
            return null;
        }}
      
}


