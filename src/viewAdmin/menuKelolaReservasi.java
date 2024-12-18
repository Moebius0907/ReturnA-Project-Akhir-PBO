/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package viewAdmin;

import view.*;
import database.MyJDBC;
import javax.swing.JOptionPane;

/**
 *
 * @author lala_
 */
public class menuKelolaReservasi extends javax.swing.JPanel {

    /**
     * Creates new form menuPotongRambut
     */ 
    public final MyJDBC query = new MyJDBC(); 
    
    public menuKelolaReservasi() {
        initComponents();
        
        // Buat model tabel dengan data tidak bisa diedit
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
        new Object[][] {},
        new String[] {
            "ID Reservasi","ID Pelanggan", "Nama", "Jenis Layanan", "Nama Layanan", 
            "Tanggal Reservasi", "Jam Reservasi", "Nama Pegawai", 
            "Harga", "Status"
        }
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Semua sel tidak bisa diedit
        }
    };
    tabelReservasi.setModel(model);
    
        query.loadTableRiwayatReservasi(tabelReservasi);
        loadJumlahReservasi(); // Tambahkan pemanggilan metode ini
        
        
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
        panelround3 = new border.panelround();
        jLabel1 = new javax.swing.JLabel();
        jumlahReservasiDitolakLB = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        panelround2 = new border.panelround();
        jLabel5 = new javax.swing.JLabel();
        jumlahReservasiDiterimaLB = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        panelround1 = new border.panelround();
        jLabel4 = new javax.swing.JLabel();
        JumlahReservasiLB = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelReservasi = new JTableCustom.jtable_custom();
        TerimaBT = new javax.swing.JButton();
        TolakBT = new javax.swing.JButton();
        panelround4 = new border.panelround();
        jLabel3 = new javax.swing.JLabel();
        jumlahReservasiDibatalkanLB = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1139, 661));
        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1139, 661));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(149, 73, 73));
        jLabel2.setText("Kelola Reservasi");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        panelround3.setBackground(new java.awt.Color(250, 213, 219));
        panelround3.setRoundBottomLeft(30);
        panelround3.setRoundBottomRight(30);
        panelround3.setRoundTopLeft(30);
        panelround3.setRoundTopRight(30);
        panelround3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Jumlah Reservasi Ditolak");
        panelround3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 40));

        jumlahReservasiDitolakLB.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jumlahReservasiDitolakLB.setForeground(new java.awt.Color(149, 73, 73));
        jumlahReservasiDitolakLB.setText("0");
        panelround3.add(jumlahReservasiDitolakLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 60));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_delete_70px.png"))); // NOI18N
        panelround3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, 100));

        jPanel1.add(panelround3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 250, 130));

        panelround2.setBackground(new java.awt.Color(250, 213, 219));
        panelround2.setRoundBottomLeft(30);
        panelround2.setRoundBottomRight(30);
        panelround2.setRoundTopLeft(30);
        panelround2.setRoundTopRight(30);
        panelround2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Jumlah Reservasi Diterima");
        panelround2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 40));

        jumlahReservasiDiterimaLB.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jumlahReservasiDiterimaLB.setForeground(new java.awt.Color(149, 73, 73));
        jumlahReservasiDiterimaLB.setText("0");
        panelround2.add(jumlahReservasiDiterimaLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 60));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_checkmark_70px.png"))); // NOI18N
        panelround2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, 90));

        jPanel1.add(panelround2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 210, 130));

        panelround1.setBackground(new java.awt.Color(250, 213, 219));
        panelround1.setRoundBottomLeft(30);
        panelround1.setRoundBottomRight(30);
        panelround1.setRoundTopLeft(30);
        panelround1.setRoundTopRight(30);
        panelround1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Jumlah Reservasi");
        panelround1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 130, 40));

        JumlahReservasiLB.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        JumlahReservasiLB.setForeground(new java.awt.Color(149, 73, 73));
        JumlahReservasiLB.setText("0");
        panelround1.add(JumlahReservasiLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 60));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_group_task_70px.png"))); // NOI18N
        panelround1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, 90));

        jPanel1.add(panelround1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 220, 130));

        tabelReservasi.setBackground(new java.awt.Color(255, 204, 204));
        tabelReservasi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Reservasi", "Id Pelanggan", "Nama", "Jenis Layanan", "Nama Layanan", "Tanggal Reservasi", "Jam Reservasi", "Nama Pegawai", "Harga", "Status"
            }
        ));
        tabelReservasi.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tabelReservasi.setGridColor(new java.awt.Color(255, 255, 255));
        tabelReservasi.setRowHeight(35);
        tabelReservasi.setRowMargin(1);
        tabelReservasi.setSelectionBackground(new java.awt.Color(153, 102, 0));
        tabelReservasi.setShowGrid(true);
        jScrollPane2.setViewportView(tabelReservasi);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 990, 310));

        TerimaBT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TerimaBT.setText("Terima");
        TerimaBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TerimaBTActionPerformed(evt);
            }
        });
        jPanel1.add(TerimaBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 590, -1, 30));

        TolakBT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TolakBT.setText("Tolak");
        TolakBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TolakBTActionPerformed(evt);
            }
        });
        jPanel1.add(TolakBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(882, 590, 80, 30));

        panelround4.setBackground(new java.awt.Color(250, 213, 219));
        panelround4.setRoundBottomLeft(30);
        panelround4.setRoundBottomRight(30);
        panelround4.setRoundTopLeft(30);
        panelround4.setRoundTopRight(30);
        panelround4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Jumlah Reservasi Dibatalkan");
        panelround4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 40));

        jumlahReservasiDibatalkanLB.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jumlahReservasiDibatalkanLB.setForeground(new java.awt.Color(149, 73, 73));
        jumlahReservasiDibatalkanLB.setText("0");
        panelround4.add(jumlahReservasiDibatalkanLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 60));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_delete_70px.png"))); // NOI18N
        panelround4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, 100));

        jPanel1.add(panelround4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 110, 250, 130));

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

     private void loadJumlahReservasi() {
        try {
            // Ambil total reservasi dengan memanggil fungsi getTotalReservasi
            int totalReservasi = MyJDBC.getTotalReservasi();
            JumlahReservasiLB.setText(String.valueOf(totalReservasi));

            // Ambil total reservasi diterima dengan memanggil fungsi getTotalReservasiDiterima
            int totalDiterima = MyJDBC.getReservasiDiterima();
            jumlahReservasiDiterimaLB.setText(String.valueOf(totalDiterima));

            // Ambil total reservasi ditolak dengan memanggil fungsi getTotalReservasiDitolak
            int totalDitolak = MyJDBC.getReservasiDitolak();
            jumlahReservasiDitolakLB.setText(String.valueOf(totalDitolak));

            // Ambil total reservasi dibatalkan dengan memanggil fungsi getTotalReservasiDibatalkan
            int totalDibatalkan = MyJDBC.getReservasiDibatalkan();
            jumlahReservasiDibatalkanLB.setText(String.valueOf(totalDibatalkan));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                null, 
                "Gagal memuat jumlah reservasi: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE
            );
        }
    }



    private void TolakBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TolakBTActionPerformed
        // Memastikan ada baris yang dipilih dalam tabel sebelum melanjutkan
        int selectedRow = tabelReservasi.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Pilih reservasi yang ingin ditolak", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            Object idReservasiObj = tabelReservasi.getValueAt(selectedRow, 0);
            String status = (String) tabelReservasi.getValueAt(selectedRow, 8); 

        // Memeriksa apakah reservasi sudah dibatalkan, jika iya tidak bisa ditolak
        if ("Dibatalkan".equalsIgnoreCase(status)) {
            JOptionPane.showMessageDialog(null, "Reservasi yang sudah dibatalkan tidak dapat ditolak.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int idReservasi;

        if (idReservasiObj instanceof Integer) {
            idReservasi = (Integer) idReservasiObj;
        } else if (idReservasiObj instanceof String) {
            idReservasi = Integer.parseInt((String) idReservasiObj);
        } else {
            JOptionPane.showMessageDialog(null, "ID reservasi tidak valid.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Konfirmasi pembatalan
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menolak reservasi ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Memanggil metode updateStatusReservasi dari MyJDBC
            boolean isUpdated = MyJDBC.updateStatusReservasi(idReservasi, "Ditolak");
            if (isUpdated) {
                JOptionPane.showMessageDialog(null, "Reservasi berhasil ditolak.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                // Refresh tabel untuk memperbarui tampilan data
                MyJDBC.loadTableRiwayatReservasi(tabelReservasi);
            } else {
                JOptionPane.showMessageDialog(null, "Gagal menolak reservasi.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "ID reservasi tidak valid.", "Error", JOptionPane.ERROR_MESSAGE);
    }


    }//GEN-LAST:event_TolakBTActionPerformed

    private void TerimaBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TerimaBTActionPerformed
    // Memastikan ada baris yang dipilih dalam tabel sebelum melanjutkan
        int selectedRow = tabelReservasi.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Pilih reservasi yang ingin diterima.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        
        Object idReservasiObj = tabelReservasi.getValueAt(selectedRow, 0);
        String status = (String) tabelReservasi.getValueAt(selectedRow, 8); // Kolom ke-8 untuk status

        // Memeriksa apakah reservasi sudah dibatalkan, jika iya tidak bisa diterima
        if ("Dibatalkan".equalsIgnoreCase(status)) {
            JOptionPane.showMessageDialog(null, "Reservasi yang sudah dibatalkan tidak dapat diterima.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int idReservasi;

        if (idReservasiObj instanceof Integer) {
            idReservasi = (Integer) idReservasiObj;
        } else if (idReservasiObj instanceof String) {
            idReservasi = Integer.parseInt((String) idReservasiObj);
        } else {
            JOptionPane.showMessageDialog(null, "ID reservasi tidak valid.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Konfirmasi pembatalan
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menerima reservasi ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Memanggil metode updateStatusReservasi dari MyJDBC untuk mengganti status menjadi diterima 
            boolean isUpdated = MyJDBC.updateStatusReservasi(idReservasi, "Diterima");
            if (isUpdated) {
                JOptionPane.showMessageDialog(null, "Reservasi berhasil diterima", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                // Refresh tabel untuk memperbarui tampilan data
                MyJDBC.loadTableRiwayatReservasi(tabelReservasi);
            } else {
                JOptionPane.showMessageDialog(null, "Gagal menerima reservasi.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "ID reservasi tidak valid.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_TerimaBTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JumlahReservasiLB;
    private javax.swing.JButton TerimaBT;
    private javax.swing.JButton TolakBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jumlahReservasiDibatalkanLB;
    private javax.swing.JLabel jumlahReservasiDiterimaLB;
    private javax.swing.JLabel jumlahReservasiDitolakLB;
    private border.panelround panelround1;
    private border.panelround panelround2;
    private border.panelround panelround3;
    private border.panelround panelround4;
    private JTableCustom.jtable_custom tabelReservasi;
    // End of variables declaration//GEN-END:variables
}