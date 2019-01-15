/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Data.BandaData;
import Data.Conexion;
import Data.PagoData;
import Data.TurnoData;
import Modelo.Admin;
import Modelo.Banda;
import Modelo.Turno;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import static java.util.Calendar.HOUR;
import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MINUTE;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Flor
 */
public class Agenda extends javax.swing.JFrame {
private Conexion con;
private Admin admin;
private Turno tr;
private Banda banda;
private TurnoData td;
private int id_turnoselec;
    /**
     * Creates new form Inicio
     */
    public Agenda() {
        initComponents();
this.setLocationRelativeTo(null);
 this.setTitle("Agenda");
    }
        public Agenda(Admin admin) {
        initComponents();
        this.admin = admin;
this.setLocationRelativeTo(null);
    this.setResizable(false);
 this.setTitle("Agenda");
 hoy();
 mañana();
btmodificar.setEnabled(false);
bteliminar.setEnabled(false);
    try {
        con = new Conexion("jdbc:mysql://localhost/sonno", "root", "");
        td = new TurnoData(con);
                    DefaultTableModel modelo;
            modelo = td.mostrarAgenda();

            tablagenda.setModel(modelo); 
            TableColumn columna = tablagenda.getColumn("fecha");
            columna.setMinWidth(200);
columna.setMaxWidth(200);

                    
            

    } catch (Exception e){System.out.println("error en el constructor de PagarTurnos");}
    }
        public LocalDateTime hoylocal(){
        LocalDateTime ldt = Instant.ofEpochMilli( hoy().getTime() )
                            .atZone( ZoneId.systemDefault() )
                            .toLocalDateTime(); return ldt;}
                public LocalDateTime mañanalocal(){
        LocalDateTime ldt = Instant.ofEpochMilli( mañana().getTime() )
                            .atZone(ZoneId.systemDefault())
                            .toLocalDateTime(); return ldt;}
        public void turnoshoy(){
        DefaultTableModel mod;
            mod=td.turnosdehoy(hoylocal(),mañanalocal());
            tablagenda.setModel(mod);
                        TableColumn columna = tablagenda.getColumn("fecha");
            columna.setMinWidth(200);
columna.setMaxWidth(200);
                }
    public Date hoy() {
         Calendar calendar = new GregorianCalendar(); 
     Date fecha = calendar.getTime();
   SimpleDateFormat formateador = new SimpleDateFormat("' Hoy es 'EEEEEE dd ' de ' MMMM ' - ' HH:mm 'hs'", new Locale("es")); 
 String calendario = formateador.format(fecha);

 System.out.println(calendario);
 return fecha;}
 
    public Date mañana() {
Calendar cal = new GregorianCalendar();
Calendar cl = new GregorianCalendar(); 
     cal.add(Calendar.DAY_OF_YEAR, +1); cal.set(HOUR_OF_DAY, 03); cal.add(MINUTE, - cl.get(MINUTE));
     Date fechamañana = cal.getTime();
    SimpleDateFormat forma = new SimpleDateFormat("' Mañana es 'EEEEEE dd ' de ' MMMM ' - ' HH:mm 'hs'", new Locale("es")); 
    String mañana = forma.format(fechamañana);
 System.out.println(mañana); return fechamañana;}
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablagenda = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtturno = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btmodificar = new javax.swing.JButton();
        bteliminar = new javax.swing.JButton();
        anteriores = new javax.swing.JButton();
        hoy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMenu.setBackground(new java.awt.Color(255, 153, 102));
        panelMenu.setToolTipText("");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/sonno copia.jpg"))); // NOI18N

        tablagenda.setBackground(new java.awt.Color(255, 255, 153));
        tablagenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Título 5", "Título 6"
            }
        ));
        tablagenda.setGridColor(new java.awt.Color(255, 255, 153));
        tablagenda.setShowHorizontalLines(false);
        tablagenda.setShowVerticalLines(false);
        tablagenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablagendaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablagenda);
        if (tablagenda.getColumnModel().getColumnCount() > 0) {
            tablagenda.getColumnModel().getColumn(2).setMinWidth(150);
        }

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Salir del sistema");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtturno.setEditable(false);
        txtturno.setBackground(new java.awt.Color(255, 153, 102));
        txtturno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtturno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtturno.setText("TURNOS PENDIENTES");
        txtturno.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtturno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtturnoActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Turnos pendientes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btmodificar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btmodificar.setText("Modificar");
        btmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmodificarActionPerformed(evt);
            }
        });

        bteliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bteliminar.setText("Eliminar");
        bteliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bteliminarActionPerformed(evt);
            }
        });

        anteriores.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        anteriores.setText("Turnos anteriores");
        anteriores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anterioresActionPerformed(evt);
            }
        });

        hoy.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        hoy.setText("Hoy");
        hoy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hoyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtturno)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMenuLayout.createSequentialGroup()
                                .addComponent(btmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                                .addComponent(bteliminar))
                            .addGroup(panelMenuLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(anteriores)))
                        .addGap(60, 60, 60)
                        .addComponent(hoy)
                        .addGap(57, 57, 57)
                        .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelMenuLayout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(122, 122, 122))
                            .addGroup(panelMenuLayout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3)))))
                .addGap(32, 32, 32))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtturno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anteriores)
                    .addComponent(jButton1)
                    .addComponent(hoy))
                .addGap(18, 18, 18)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btmodificar)
                    .addComponent(bteliminar)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addContainerGap(44, Short.MAX_VALUE))
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

    private void tablagendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablagendaMouseClicked
       btmodificar.setEnabled(true);
bteliminar.setEnabled(true);
        
        int selec = tablagenda.rowAtPoint(evt.getPoint());
        id_turnoselec = Integer.valueOf(String.valueOf(tablagenda.getValueAt(selec, 0)));
    }//GEN-LAST:event_tablagendaMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

          Menu bbb = new Menu(admin);
        bbb.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtturnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtturnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtturnoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                    DefaultTableModel modelo;
            modelo = td.mostrarAgenda();
            tablagenda.setModel(modelo);
                        TableColumn columna = tablagenda.getColumn("fecha");
            columna.setMinWidth(200);
columna.setMaxWidth(200);
            txtturno.setText("TURNOS PENDIENTES");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bteliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bteliminarActionPerformed
try {td.eliminarTurnoporid(id_turnoselec);
JOptionPane.showMessageDialog(null, "El turno se ha eliminado.");
}catch (Exception e){JOptionPane.showMessageDialog(null, "ERROR");}
                    DefaultTableModel modelo;
            modelo = td.mostrarAgenda();
            tablagenda.setModel(modelo);
            txtturno.setText("TURNOS PENDIENTES");
    }//GEN-LAST:event_bteliminarActionPerformed

    private void btmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmodificarActionPerformed
 tr = td.buscarTurnoporId(id_turnoselec);
 banda= tr.getBand();
 ModTurno mt= new ModTurno(admin,banda,tr);
 mt.setVisible(true);
 this.setVisible(false);
    }//GEN-LAST:event_btmodificarActionPerformed

    private void anterioresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anterioresActionPerformed
                   DefaultTableModel modelo2;
            modelo2 = td.turnosviejos();
            tablagenda.setModel(modelo2); 
                        TableColumn columna = tablagenda.getColumn("fecha");
            columna.setMinWidth(200);
columna.setMaxWidth(200);
            txtturno.setText("TURNOS ANTERIORES");

    }//GEN-LAST:event_anterioresActionPerformed

    private void hoyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hoyActionPerformed
turnoshoy();
txtturno.setText("TURNOS DE HOY");
    }//GEN-LAST:event_hoyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anteriores;
    private javax.swing.JButton bteliminar;
    private javax.swing.JButton btmodificar;
    private javax.swing.JButton hoy;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JTable tablagenda;
    private javax.swing.JTextField txtturno;
    // End of variables declaration//GEN-END:variables
}
