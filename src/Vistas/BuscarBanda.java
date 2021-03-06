/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Data.AdminData;
import Data.BandaData;
import Data.Conexion;
import Data.PagoData;
import Data.TurnoData;
import Modelo.Admin;
import Modelo.Banda;
import Modelo.Turno;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author Flor
 */
public class BuscarBanda extends javax.swing.JFrame {
private Conexion con;
private Admin admin;
private Banda band;
private int montoTurno;

private LocalDateTime fecha;
private TurnoData td;
private BandaData bd;
private PagoData pd;


  
    /**
     * Creates new form Inicio
     */
    public BuscarBanda() {
        initComponents();
this.setLocationRelativeTo(null);
    }
    
        public BuscarBanda(Admin admin,Banda banda) {
    initComponents();
    this.setLocationRelativeTo(null);
    this.setResizable(false);
     this.setTitle("Datos de la banda");
    this.band= banda;

    this.admin = admin;

    try {
                    con = new Conexion("jdbc:mysql://localhost/sonno", "root", "");
        td = new TurnoData(con);
        bd= new BandaData(con);
        pd = new PagoData(con);
            mostrarBanda();
               mostrarTurno(); 
        System.out.println("BUSCAR BANDA: Administrado por: " + admin.getNombre()+ "  "+  "Banda : " + banda.getNombre());
    } catch (Exception e){System.out.println("error en el constructor BuscarBanda");}

}
        
        public LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    
        public void mostrarBanda(){
            txtid.setText(Integer.toString(band.getId_banda()));
            txtnombre.setText(band.getNombre());
            txtturno.setText("ninguno");
            txtdias.setText(band.getDias_fijos());
            txtsaldo.setText("$"+Integer.toString(band.getSaldo()));

}
         public void mostrarTurno(){
      LocalDateTime prox = td.proximoTurnodeBanda(band.getId_banda());

   SimpleDateFormat formateador = new SimpleDateFormat("' 'EEEEEE dd ' de ' MMMM ' - ' HH:mm 'hs'", new Locale("es"));  
   
  Date fechaDate = Date.from( prox.atZone( ZoneId.systemDefault()).toInstant());
  
String fecha= formateador.format(fechaDate);  

 txtturno.setText(fecha);}
        
        public void guardarTurno(){
        try {

         
Date utill = txtdate.getDate();

java.sql.Timestamp fec = new java.sql.Timestamp(utill.getTime());
this.setFecha(fec.toLocalDateTime());

    System.out.println(fecha); 
    Turno turno = new Turno();
       turno.setBand(band);
       System.out.println(turno.getBand().getNombre());
       
       turno.setAdmin(admin);
       System.out.println(admin.getNombre());
       
       turno.setFecha(fecha);
           System.out.println(turno.getFecha()); 
           
           String valor = (String) cantHoras.getSelectedItem();
montoTurno = Integer.valueOf(valor) *150;
       turno.setMonto(montoTurno);
           System.out.println(turno.getMonto()); 
       
       turno.setPagado("no");
       System.out.println(turno.getPagado()); 
       
       turno.setEstado(1);
       System.out.println(turno.getEstado()); 

       td.agendar(turno, admin, band);
            
} catch (Exception e) {
            System.out.println("BUSCAR BANDA: error en todo el metodo guardarTurno" + e);
        }}
        
        public boolean verificarfechas(Date date){
            Date hoy = new Date();
        if (date.before(hoy)){return false;} else {return true;}}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBuscar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        txtturno = new javax.swing.JTextField();
        txtdias = new javax.swing.JTextField();
        txtsaldo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtdate = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cantHoras = new javax.swing.JComboBox<>();
        txtmonto = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelBuscar.setBackground(new java.awt.Color(255, 153, 102));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/sonno.jpg"))); // NOI18N

        txtnombre.setEditable(false);
        txtnombre.setBackground(new java.awt.Color(255, 153, 102));
        txtnombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtnombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });

        txtid.setEditable(false);
        txtid.setBackground(new java.awt.Color(255, 153, 102));
        txtid.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtid.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        txtturno.setEditable(false);
        txtturno.setBackground(new java.awt.Color(255, 153, 102));
        txtturno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtturno.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtturno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtturnoActionPerformed(evt);
            }
        });

        txtdias.setEditable(false);
        txtdias.setBackground(new java.awt.Color(255, 153, 102));
        txtdias.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtdias.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtsaldo.setEditable(false);
        txtsaldo.setBackground(new java.awt.Color(255, 153, 102));
        txtsaldo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtsaldo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Id:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Próximo Turno: ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Dias Fijos:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Deuda:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Agendar turno");

        txtdate.setDateFormatString("dd/MM/yyyy       HH:mm");
        txtdate.setPreferredSize(new java.awt.Dimension(86, 20));

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Fecha y Hora:");

        jLabel8.setText("Cantidad de horas:");

        cantHoras.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "1", "2", "3", "4" }));
        cantHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantHorasActionPerformed(evt);
            }
        });

        txtmonto.setEditable(false);
        txtmonto.setBackground(new java.awt.Color(255, 153, 102));
        txtmonto.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtmonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmontoActionPerformed(evt);
            }
        });

        jButton3.setText("Volver");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Pagar deuda");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBuscarLayout = new javax.swing.GroupLayout(panelBuscar);
        panelBuscar.setLayout(panelBuscarLayout);
        panelBuscarLayout.setHorizontalGroup(
            panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(panelBuscarLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBuscarLayout.createSequentialGroup()
                        .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelBuscarLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnombre)
                            .addComponent(txtturno)))
                    .addGroup(panelBuscarLayout.createSequentialGroup()
                        .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(44, 44, 44)
                        .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelBuscarLayout.createSequentialGroup()
                                .addComponent(txtsaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 51, Short.MAX_VALUE))
                            .addComponent(txtdias)))
                    .addGroup(panelBuscarLayout.createSequentialGroup()
                        .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelBuscarLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cantHoras, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(txtmonto, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBuscarLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelBuscarLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        panelBuscarLayout.setVerticalGroup(
            panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBuscarLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(txtid)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtturno)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdias, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBuscarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addComponent(txtsaldo, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtdate, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cantHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtturnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtturnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtturnoActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void cantHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantHorasActionPerformed
 String valor = (String) cantHoras.getSelectedItem();
 
if(valor == "Seleccionar"){txtmonto.setText("");}
else{
 int valormonto = Integer.valueOf(valor) *150;
montoTurno = valormonto;

if (valor.equals("Seleccionar")) {txtmonto.setText("");}
else {txtmonto.setText("Monto: $" + valormonto);}}

    }//GEN-LAST:event_cantHorasActionPerformed

    private void txtmontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmontoActionPerformed

    }//GEN-LAST:event_txtmontoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String valor = (String) cantHoras.getSelectedItem();
        Date utill = txtdate.getDate();
   
if (valor =="Seleccionar") {JOptionPane.showMessageDialog(null, "Ingrese una cantidad de Horas");}
else { 
if (verificarfechas(utill)){
    guardarTurno();
    band = bd.buscarBanda(band.getNombre());
    int saldo= band.getSaldo() + montoTurno;
    bd.sumarSaldo(band, saldo);
    band = bd.buscarBanda(band.getNombre());
    
    JOptionPane.showMessageDialog(null,"El turno ha sido guardado con exito!");
    
              BuscarBanda bbb = new BuscarBanda(admin,band);
        bbb.setVisible(true);
        this.setVisible(false);
    
System.out.println("Turno guardado con exito." );} else { JOptionPane.showMessageDialog(null, "Ingrese una fecha válida");}

}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
Menu menu  = new Menu(admin);
        menu.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
  System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
PagarTurnos pt = new PagarTurnos(admin,band);
pt.setVisible(true);
this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed


  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cantHoras;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel panelBuscar;
    private com.toedter.calendar.JDateChooser txtdate;
    private javax.swing.JTextField txtdias;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtmonto;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtsaldo;
    private javax.swing.JTextField txtturno;
    // End of variables declaration//GEN-END:variables
}
