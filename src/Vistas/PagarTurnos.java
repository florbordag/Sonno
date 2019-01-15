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
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Flor
 */
public class PagarTurnos extends javax.swing.JFrame {
private Conexion con;
private Admin admin;
private Banda banda;
private Turno tr;
private TurnoData td;
private BandaData bd;
private PagoData pd;
private int id_turnoselec;
    /**
     * Creates new form Inicio
     */
    public PagarTurnos() {
        initComponents();
this.setLocationRelativeTo(null);
    }
        public PagarTurnos(Admin admin, Banda banda) {
        initComponents();
        this.admin = admin;
        this.banda = banda;
this.setLocationRelativeTo(null);
    this.setResizable(false);
 this.setTitle("Pagar turnos");
    try {
        con = new Conexion("jdbc:mysql://localhost/sonno", "root", "");
        td = new TurnoData(con);
        bd= new BandaData(con);
        pd = new PagoData(con);
                    DefaultTableModel modelo;
            modelo = td.mostrarturnos(banda);

            tablaturnos.setModel(modelo); 

    } catch (Exception e){System.out.println("error en el constructor de PagarTurnos");}
            txtdeuda.setText(Integer.toString(banda.getSaldo()));
    }
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaturnos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtdeuda = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMenu.setBackground(new java.awt.Color(255, 153, 102));
        panelMenu.setToolTipText("");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/sonno copia.jpg"))); // NOI18N

        tablaturnos.setBackground(new java.awt.Color(255, 255, 153));
        tablaturnos.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaturnos.setGridColor(new java.awt.Color(255, 255, 153));
        tablaturnos.setShowHorizontalLines(false);
        tablaturnos.setShowVerticalLines(false);
        tablaturnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaturnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaturnos);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Pagar Turno");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Seleccione el turno a pagar:");

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Deuda total:    $");

        txtdeuda.setEditable(false);
        txtdeuda.setBackground(new java.awt.Color(255, 153, 102));
        txtdeuda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtdeuda.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtdeuda.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(157, 157, 157)
                        .addComponent(jButton3)))
                .addGap(35, 35, 35))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtdeuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(62, Short.MAX_VALUE))
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

    private void tablaturnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaturnosMouseClicked
        int selec = tablaturnos.rowAtPoint(evt.getPoint());
        id_turnoselec = Integer.valueOf(String.valueOf(tablaturnos.getValueAt(selec, 0)));
    }//GEN-LAST:event_tablaturnosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
tr = td.buscarTurnoporId(id_turnoselec);
System.out.println("pagarturnos paso 1: id turno:" +tr.getId_turno());
if (tr.getPagado().equals("no")) {
pd.RegistrarPago(tr, admin, banda, tr.getMonto());
System.out.println("pagarturnos paso 2: registrarpago: turnofecha: "+tr.getFecha().toString()+" banda:"+banda.getNombre()+ "monto: "+tr.getMonto());
td.pagarDeuda(banda,tr);
System.out.println("pagarturnos paso 3, td.pagardeuda, banda: "+banda.getNombre()+" fechaturno: "+tr.getFecha().toString() );
bd.PagarDeuda(banda, tr.getMonto());
System.out.println("pagarturnos paso 4, bd.pagardeuda: banda: "+banda.getNombre()+" montoturno: "+tr.getMonto());
banda= bd.buscarBanda(banda.getNombre());
System.out.println("final: fechaturno: "+tr.getFecha().toString());
JOptionPane.showMessageDialog(null, "El turno ha sido pagado.");
PagarTurnos pt = new PagarTurnos(admin, banda);

pt.setVisible(true);
this.setVisible(false);
this.setVisible(false);} else {JOptionPane.showMessageDialog(null, "Este turno ya fué cobrado. Seleccione un turno que no esté pagado.");}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

          BuscarBanda bbb = new BuscarBanda(admin,banda);
        bbb.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JTable tablaturnos;
    private javax.swing.JTextField txtdeuda;
    // End of variables declaration//GEN-END:variables
}
