/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package viewAdmin;

import view.*;
import database.MyJDBC;

/**
 *
 * @author lala_
 */

public class menuLihatCustomer extends javax.swing.JPanel {

    /**
     * Creates new form menuPotongRambut
     */
    public final MyJDBC query = new MyJDBC(); 
    
    public menuLihatCustomer() {
        initComponents();
        query.lihatCustomer(tabelCustomer);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelCustomer = new JTableCustom.jtable_custom();

        setPreferredSize(new java.awt.Dimension(1139, 661));
        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1139, 661));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(149, 73, 73));
        jLabel2.setText("Customer");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        tabelCustomer.setBackground(new java.awt.Color(255, 204, 204));
        tabelCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Pelanggan", "Nama ", "No Telepon", "Alamat", "Nama Pengguna", "Jumlah Reservasi"
            }
        ));
        tabelCustomer.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tabelCustomer.setGridColor(new java.awt.Color(255, 255, 255));
        tabelCustomer.setRowHeight(35);
        tabelCustomer.setRowMargin(1);
        tabelCustomer.setSelectionBackground(new java.awt.Color(153, 102, 0));
        tabelCustomer.setShowGrid(true);
        jScrollPane2.setViewportView(tabelCustomer);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 920, 450));

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private JTableCustom.jtable_custom tabelCustomer;
    // End of variables declaration//GEN-END:variables
}