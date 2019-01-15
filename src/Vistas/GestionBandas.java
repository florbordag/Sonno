/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Data.BandaData;
import Data.Conexion;
import Data.TurnoData;
import Modelo.Admin;
import Modelo.Banda;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Flor
 */
public class GestionBandas extends javax.swing.JFrame {
private Conexion con;
private Admin admin;
private String nombreBanda;
private Banda h;
private TurnoData td;
private BandaData bd;
boolean existe;
private int id_bandaselec;
    /**
     * Creates new form Inicio
     */
    public GestionBandas() {
        initComponents();
this.setLocationRelativeTo(null);

    }
        public GestionBandas(Admin admin) {
        initComponents();
        this.admin = admin;
this.setLocationRelativeTo(null);
    this.setResizable(false);
 this.setTitle("Gestionar bandas");
txtproximoturno.setText("No hay próximos turnos");
btmodificar.setEnabled(false);
bteliminar.setEnabled(false);

System.out.println("GESTION BANDAS administrado por: " +admin.getNombre());

    try {
        con = new Conexion("jdbc:mysql://localhost/sonno", "root", "");
        td = new TurnoData(con);
        bd= new BandaData(con);

                    DefaultTableModel modelo;
            modelo = bd.mostrarbandas();

            tablabandas.setModel(modelo); 
    } catch (Exception e){System.out.println("error en el constructor de GestioBandas");}
    try {
mostrarTurno();

    } catch (Exception e){System.out.println("no hay turnos proximos");}
    }
    
 public void mostrarTurno(){
      LocalDateTime prox = td.proximoTurno();
 int id_banda = td.proximaBanda();

Banda ban = bd.buscarBandaporId(id_banda);

   SimpleDateFormat formateador = new SimpleDateFormat("' 'EEEEEE dd ' de ' MMMM ' - ' HH:mm 'hs'", new Locale("es"));  
   
  Date fechaDate = Date.from( prox.atZone( ZoneId.systemDefault()).toInstant());
  
String fecha=ban.getNombre() + " - " + formateador.format(fechaDate);  

 txtproximoturno.setText(fecha);}
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtproximoturno = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablabandas = new javax.swing.JTable();
        btadd = new javax.swing.JButton();
        btmodificar = new javax.swing.JButton();
        bteliminar = new javax.swing.JButton();
        btvolver = new javax.swing.JButton();
        btpagos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMenu.setBackground(new java.awt.Color(255, 153, 102));
        panelMenu.setToolTipText("");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/sonno copia.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Próxima Banda:");

        txtproximoturno.setEditable(false);
        txtproximoturno.setBackground(new java.awt.Color(255, 153, 102));
        txtproximoturno.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        txtproximoturno.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtproximoturno.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtproximoturno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtproximoturnoActionPerformed(evt);
            }
        });

        tablabandas.setBackground(new java.awt.Color(255, 255, 153));
        tablabandas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablabandas.setGridColor(new java.awt.Color(255, 255, 153));
        tablabandas.setShowHorizontalLines(false);
        tablabandas.setShowVerticalLines(false);
        tablabandas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablabandasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablabandas);

        btadd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btadd.setText("Añadir");
        btadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btaddActionPerformed(evt);
            }
        });

        btmodificar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btmodificar.setText("Modificar");
        btmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmodificarActionPerformed(evt);
            }
        });

        bteliminar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bteliminar.setText("Eliminar");
        bteliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bteliminarActionPerformed(evt);
            }
        });

        btvolver.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btvolver.setText("Volver");
        btvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btvolverActionPerformed(evt);
            }
        });

        btpagos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btpagos.setText("Ver Pagos");
        btpagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btpagosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMenuLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtproximoturno))
                    .addComponent(jScrollPane1)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addComponent(btadd, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(btmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(bteliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(btpagos)
                        .addGap(62, 62, 62)
                        .addComponent(btvolver, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtproximoturno, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btadd)
                    .addComponent(bteliminar)
                    .addComponent(btvolver)
                    .addComponent(btpagos)
                    .addComponent(btmodificar))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 760, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtproximoturnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtproximoturnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtproximoturnoActionPerformed

    private void tablabandasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablabandasMouseClicked
btmodificar.setEnabled(true);
bteliminar.setEnabled(true);
        int selec = tablabandas.rowAtPoint(evt.getPoint());
        id_bandaselec = Integer.valueOf(String.valueOf(tablabandas.getValueAt(selec, 0)));
    }//GEN-LAST:event_tablabandasMouseClicked

    private void bteliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bteliminarActionPerformed
          if (JOptionPane.showConfirmDialog(rootPane, "Al eliminar una banda se eliminan también los turnos previos y pendientes de la misma. ¿Está seguro que desea eliminar esta banda?",
                "Eliminar Huesped", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
              td.eliminarTurno(id_bandaselec);
            //A continuacion elimino la habitacion seleccionada.
            bd.eliminarBanda(id_bandaselec);
        }

        //A continuacion desabilito los botones de modificar y eliminar hasta que el admin haga click en una reserva:
        btmodificar.setEnabled(false);
        bteliminar.setEnabled(false);

 DefaultTableModel modelo;
            modelo = bd.mostrarbandas();

            tablabandas.setModel(modelo); 
    }//GEN-LAST:event_bteliminarActionPerformed

    private void btaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btaddActionPerformed

    // prompt the user to enter their name
    String nombre = JOptionPane.showInputDialog("Introduzca el nombre de la banda:");
    if (nombre == null){JOptionPane.showMessageDialog(null, "Se ha cancelado el registro.");} else {
     
        if (bd.verificarBanda(nombre)==0){JOptionPane.showMessageDialog(null, "Esta banda ya está registrada");} else{ 
            
  int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea asignarle dias fijos?"); //0 = si, 1 = no, 2 = cancelar
  
    if (respuesta == 0){
    String diasfijos;
 String[] dias = {
            "Seleccionar",
            "Lunes",
            "Martes",
            "Miercoles",
            "Jueves",
            "Viernes"};
        String resp = (String) JOptionPane.showInputDialog(null, "Seleccione un dia fijo", "Dias", JOptionPane.DEFAULT_OPTION,null, dias, dias[0]);
                if (resp ==null){JOptionPane.showMessageDialog(null, "Se ha cancelado el registro.");} else{
        int respuesta2 = JOptionPane.showConfirmDialog(null, "¿Desea asignarle otro dia fijo?"); //0 = si, 1 = no, 2 = cancelar
        if (respuesta2 == 0) 
        {String resp2 = (String) JOptionPane.showInputDialog(null, "Seleccione un dia fijo", "Dias", JOptionPane.DEFAULT_OPTION,null, dias, dias[0]);
        diasfijos = resp + " y " + resp2 ; bd.registrarBanda(nombre, diasfijos);} 
        
        else{if (respuesta2 ==1){bd.registrarBanda(nombre, resp);} else {JOptionPane.showMessageDialog(null, "Se ha cancelado el registro.");}}}
    }else {if (respuesta == 1){bd.registrarBanda(nombre, "Ninguno");} else {JOptionPane.showMessageDialog(null, "Se ha cancelado el registro.");}}}}
     DefaultTableModel modelo;
            modelo = bd.mostrarbandas();

            tablabandas.setModel(modelo); 
    }//GEN-LAST:event_btaddActionPerformed

    private void btvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btvolverActionPerformed
Menu menu  = new Menu(admin);
        menu.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_btvolverActionPerformed

    private void btmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmodificarActionPerformed
        // TODO add your handling code here:
        Banda nueva = bd.buscarBandaporId(id_bandaselec);
        ModBanda mb = new ModBanda(admin,nueva);
        mb.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btmodificarActionPerformed

    private void btpagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btpagosActionPerformed
VerPagos vp = new VerPagos(admin);
vp.setVisible(true);
this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_btpagosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btadd;
    private javax.swing.JButton bteliminar;
    private javax.swing.JButton btmodificar;
    private javax.swing.JButton btpagos;
    private javax.swing.JButton btvolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JTable tablabandas;
    private javax.swing.JTextField txtproximoturno;
    // End of variables declaration//GEN-END:variables
}
