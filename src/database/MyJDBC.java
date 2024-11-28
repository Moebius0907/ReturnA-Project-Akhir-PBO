/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import Sesi.SessionManager;
import com.mysql.cj.Session;
import java.sql.*;                
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author lala_
 */
// kelas untuk mengatur koneksi ke database dan melakukan operasi-operasi yang terkait database. 
public class MyJDBC {

    // Fungsi untuk mendaftarkan pengguna baru dan memasukannya ke database users
    public static boolean Register(String nama, String noTelp, String alamat, String namaPelanggan, String kataSandi){
        try {
            // memeriksa apakah pengguna sudah ada di database dengan memanggil 'checkUser'.
            if (!checkUser(namaPelanggan)){
                // membuat koneksi ke database
                Connection konek = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_NAMAPENGGUNA, CommonConstants.DB_KATASANDI);
            
            // menyiapkan statement SQL untuk memasukkan data pengguna ke dalam tabelv 
            PreparedStatement insertUser = konek.prepareStatement(
                    "INSERT INTO " + CommonConstants.DB_USERS_TABLE_NAME + "(nama, noTelp, alamat, namaPelanggan, kataSandi)" + "VALUES(?, ?, ?, ?, ?)");
            
            // mengatur parameter pada statement
            insertUser.setString(1, nama);
            insertUser.setString(2, noTelp);
            insertUser.setString(3, alamat);
            insertUser.setString(4, namaPelanggan);
            insertUser.setString(5, kataSandi);
            
            // mengeksekusi pernyataan untuk menambahkan data ke database
            insertUser.executeUpdate();
            return true;    // mengembalikan true jika pendaftaran berhasil
            }
        }catch(SQLException e){
            e.printStackTrace();        // mencetak stack trace jika terjadi kesalahan SQL
        }
        return false;       // mengembalikan false jika pendaftaran gagal
    }
    
    // Fungsi untuk memeriksa apakah pengguna (username)  sudah terdaftar di database 
    public static boolean checkUser(String namaPengguna) {
    try {
        Connection konek = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_NAMAPENGGUNA, CommonConstants.DB_KATASANDI);
        PreparedStatement checkUserExists = konek.prepareStatement(
                "SELECT * FROM " + CommonConstants.DB_USERS_TABLE_NAME + " WHERE NAMAPELANGGAN = ?");
        checkUserExists.setString(1, namaPengguna);
        ResultSet resultSet = checkUserExists.executeQuery();
        
        
        if (resultSet.next()) {
            return true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false; 
}

    
    // untuk memvalidasi login pengguna dengan mencocokkan username dan password
    public static boolean validasiLogin(String namaPengguna, String kataSandi){
        try{
            // membuat koneksi ke database
            Connection konek = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_NAMAPENGGUNA, CommonConstants.DB_KATASANDI);
            
            // menyiapkan statement SQL untuk memvalidasi Login pengguna.
            PreparedStatement validasiUser = konek.prepareStatement(
                    "SELECT * FROM " + CommonConstants.DB_USERS_TABLE_NAME + " WHERE NAMAPELANGGAN = ? AND KATASANDI = ?");
            
            // mengatur parameter pada statment
            validasiUser.setString(1, namaPengguna);
            validasiUser.setString(2, kataSandi);
            
            // menjalankan query dan menyimpan hasilnya
            ResultSet resultSet = validasiUser.executeQuery();
            
            // memriksa apakah resultSet memeiliki data pengguna yang valid
            return resultSet.next();
        }catch(SQLException e){
            e.printStackTrace();    // mencetak stack trace jika terjadi kesalahan SQL
        }
        
        return false;    // mengembalikan true jika login valid
    }
 
    
   public static boolean validasiCustomer(String namaPengguna, String kataSandi) {
    try (Connection konek = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_NAMAPENGGUNA, CommonConstants.DB_KATASANDI)) {
        // SQL query untuk validasi login dan mengambil idPelanggan
        String queryPengguna = "SELECT idPelanggan FROM users WHERE namaPelanggan = ? AND kataSandi = ?";
        PreparedStatement pst = konek.prepareStatement(queryPengguna);
        pst.setString(1, namaPengguna);
        pst.setString(2, kataSandi);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            // Menyimpan idPelanggan ke dalam sesi
            SessionManager.idPelanggan = rs.getInt("idPelanggan");
            
            return true; // Login berhasil
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false; // Login gagal
}
   
   //Fungsi untuk mendapatkan nama pelanggan dari idPelanggan
   public String getNamaPelanggan(int idPelanggan) {
    String namaPelanggan = "";
    try (Connection konek = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_NAMAPENGGUNA, CommonConstants.DB_KATASANDI)) {
        String query = "SELECT nama FROM users WHERE idPelanggan = ?";
        PreparedStatement pst = konek.prepareStatement(query);
        pst.setInt(1, idPelanggan);
        ResultSet rs = pst.executeQuery();
        
        if (rs.next()) {
            namaPelanggan = rs.getString("nama");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return namaPelanggan;
}

    
   //Fungsi untuk mendapatkan seluruh data dari tabel layanan di database
    public static void loadTableDataLayanan(javax.swing.JTable tabelReservasi) {
    // Mendapatkan model dari tabel dan mengosongkan isinya
    javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tabelReservasi.getModel();
    model.setRowCount(0); // Kosongkan tabel sebelum memuat data baru

    // Menghubungkan ke database dan memuat data dari tabel reservasi
    try (Connection konek = DriverManager.getConnection(
            CommonConstants.DB_URL, 
            CommonConstants.DB_NAMAPENGGUNA, 
            CommonConstants.DB_KATASANDI)) {

        // SQL query untuk mengambil data dari tabel reservasi
        String sql = "SELECT idLayanan, jenisLayanan, namaLayanan, deskripsi, harga FROM layanan";
        
        try (PreparedStatement ps = konek.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            // Memproses setiap baris hasil query
            while (rs.next()) {
                // Ambil data dari ResultSet
                int idLayanan = rs.getInt("idLayanan");
                String jenisLayanan = rs.getString("jenisLayanan");
                String namaLayanan = rs.getString("namaLayanan");
                String deskripsi = rs.getString("deskripsi");
                int harga = rs.getInt("harga");

                // Tambahkan data ke tabel model
                model.addRow(new Object[]{idLayanan, jenisLayanan, namaLayanan, deskripsi,  "Rp. " + harga});
            }
        }
    } catch (SQLException e) {
        // Tampilkan pesan error jika gagal memuat data
        JOptionPane.showMessageDialog(null, 
            "Gagal memuat data: " + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
}
    
    
    //Fungsi untuk inserta data reservasi ke tabel reservasi di database
    public static void insertReservasi(int idPelanggan, int idLayanan, String nama,
                                   java.util.Date tanggalReservasi, String jamReservasi, 
                                   String namaPegawai, String status, javax.swing.JTable tabelReservasi) {
        try (Connection konek = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_NAMAPENGGUNA, CommonConstants.DB_KATASANDI)) {
            
        // Mengecek apakah data sudah ada di database
        String checkSql = "SELECT COUNT(*) FROM reservasi WHERE namaPegawai = ? AND tanggalReservasi = ? AND jamReservasi = ?";
        try (PreparedStatement checkPs = konek.prepareStatement(checkSql)) {
            checkPs.setString(1, namaPegawai);
            checkPs.setDate(2, new java.sql.Date(tanggalReservasi.getTime()));
            checkPs.setString(3, jamReservasi);

            ResultSet rs = checkPs.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(null, "Data sudah ada di database!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return; // Menghentikan proses jika data sudah ada
            }
        }

        // Jika tidak ada duplikasi/data yang sama, masukkan data ke tabel reservasi
        String insertSql = "INSERT INTO reservasi (idPelanggan, idLayanan, nama, tanggalReservasi, jamReservasi, namaPegawai, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement insertPs = konek.prepareStatement(insertSql)) {
            insertPs.setInt(1, idPelanggan); // Tambahkan idPelanggan dari sesi
            insertPs.setInt(2, idLayanan);
            insertPs.setString(3, nama);
            insertPs.setDate(4, new java.sql.Date(tanggalReservasi.getTime()));
            insertPs.setString(5, jamReservasi);
            insertPs.setString(6, namaPegawai);
            insertPs.setString(7, status);

            int rowsAffected = insertPs.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);

                // Memuat data terbaru ke tabel
                loadTableRiwayatReservasi(tabelReservasi);
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Gagal menyimpan data ke database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    public void lihatCustomer(JTable tableUsers) {
    // Menambahkan kolom baru untuk menampilkan jumlah reservasi
    DefaultTableModel model = new DefaultTableModel(
        new Object[]{"ID Pengguna", "Nama", "No Telp", "Alamat", "Nama Pengguna", "Jumlah Reservasi"}, 0
    );
    tableUsers.setModel(model);

    try (Connection konek = DriverManager.getConnection(
            CommonConstants.DB_URL, 
            CommonConstants.DB_NAMAPENGGUNA, 
            CommonConstants.DB_KATASANDI)) {
        
        // SQL query untuk mengambil data pengguna dan jumlah reservasi
        String sql = "SELECT u.idPelanggan, u.nama, u.noTelp, u.alamat, u.namaPelanggan, " +
                     "COUNT(r.idReservasi) AS jumlahReservasi " +
                     "FROM users u " +
                     "LEFT JOIN reservasi r ON u.idPelanggan = r.idPelanggan " +
                     "GROUP BY u.idPelanggan, u.nama, u.noTelp, u.alamat, u.namaPelanggan";

        try (Statement stmt = konek.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("idPelanggan");
                String nama = rs.getString("nama");
                String noTelp = rs.getString("noTelp");
                String alamat = rs.getString("alamat");
                String namaPelanggan = rs.getString("namaPelanggan");
                int jumlahReservasi = rs.getInt("jumlahReservasi"); // Ambil jumlah reservasi

                // Tambahkan data ke tabel
                model.addRow(new Object[]{id, nama, noTelp, alamat, namaPelanggan, jumlahReservasi});
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    
    
    public static void loadTableRiwayatReservasi(javax.swing.JTable tabelReservasi) {
    // Mendapatkan model dari tabel dan mengosongkan isinya
    javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tabelReservasi.getModel();
    model.setRowCount(0); // Kosongkan tabel sebelum memuat data baru

    // Menghubungkan ke database dan memuat data dari tabel reservasi dan layanan
    try (Connection konek = DriverManager.getConnection(
            CommonConstants.DB_URL, 
            CommonConstants.DB_NAMAPENGGUNA, 
            CommonConstants.DB_KATASANDI)) {

        // SQL query untuk mengambil data dengan JOIN antara tabel reservasi dan layanan
        String sql = "SELECT reservasi.idReservasi, reservasi.idPelanggan, reservasi.nama, layanan.jenisLayanan, " +
                     "layanan.namaLayanan, reservasi.tanggalReservasi, reservasi.jamReservasi, reservasi.namaPegawai, " +
                     "layanan.harga, reservasi.status " +
                     "FROM reservasi " +
                     "JOIN layanan ON reservasi.idLayanan = layanan.idLayanan";

        try (PreparedStatement ps = konek.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            // Memproses setiap baris hasil query
            while (rs.next()) {
                // Mengambil data dari ResultSet
                int idReservasi = rs.getInt("idReservasi");
                int idPelanggan = rs.getInt("idPelanggan"); 
                String nama = rs.getString("nama");
                String jenisLayanan = rs.getString("jenisLayanan");
                String namaLayanan = rs.getString("namaLayanan");
                String tanggalReservasi = rs.getDate("tanggalReservasi").toString();
                String jamReservasi = rs.getString("jamReservasi");
                String namaPegawai = rs.getString("namaPegawai");
                double harga = rs.getDouble("harga");
                String status = rs.getString("status");

                // Tambahkan data ke tabel model
                model.addRow(new Object[]{
                    idReservasi,    
                    idPelanggan,    
                    nama,           
                    jenisLayanan,   
                    namaLayanan,    
                    tanggalReservasi, 
                    jamReservasi,   
                    namaPegawai,    
                    "Rp. " + harga, 
                    status          
                });
            }
        }
    } catch (SQLException e) {
        // pesan error jika gagal memuat data
        JOptionPane.showMessageDialog(null, 
            "Gagal memuat data: " + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
}
    
    public static void loadRiwayatReservasiByIdPelanggan(javax.swing.JTable tabelReservasi) {
    // Mendapatkan model tabel dan membersihkannya
    javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tabelReservasi.getModel();
    model.setRowCount(0); // Kosongkan tabel sebelum memuat data baru

    // idPelanggan dari sesi
    int idPelanggan = SessionManager.idPelanggan;

    // Koneksi ke database
    try (Connection konek = DriverManager.getConnection(
            CommonConstants.DB_URL, 
            CommonConstants.DB_NAMAPENGGUNA, 
            CommonConstants.DB_KATASANDI)) {

        // Query untuk mengambil data reservasi berdasarkan idPelanggan
        String sql = "SELECT reservasi.idReservasi, reservasi.nama, layanan.jenisLayanan, " +
                     "layanan.namaLayanan, reservasi.tanggalReservasi, reservasi.jamReservasi, " +
                     "reservasi.namaPegawai, layanan.harga, reservasi.status " +
                     "FROM reservasi " +
                     "JOIN layanan ON reservasi.idLayanan = layanan.idLayanan " +
                     "WHERE reservasi.idPelanggan = ?"; // Filter berdasarkan idPelanggan
        
        try (PreparedStatement ps = konek.prepareStatement(sql)) {
            ps.setInt(1, idPelanggan); // Gunakan idPelanggan dari sesi

            try (ResultSet rs = ps.executeQuery()) {
                // Proses setiap baris hasil query
                while (rs.next()) {
                    int idReservasi = rs.getInt("idReservasi");
                    String nama = rs.getString("nama");
                    String jenisLayanan = rs.getString("jenisLayanan");
                    String namaLayanan = rs.getString("namaLayanan");
                    String tanggalReservasi = rs.getDate("tanggalReservasi").toString();
                    String jamReservasi = rs.getString("jamReservasi");
                    String namaPegawai = rs.getString("namaPegawai");
                    double harga = rs.getDouble("harga");
                    String status = rs.getString("status");

                    // Tambahkan data ke tabel model
                    model.addRow(new Object[]{
                        idReservasi,    
                        nama,           
                        jenisLayanan,   
                        namaLayanan,
                        tanggalReservasi, 
                        jamReservasi,   
                        namaPegawai,    
                        "Rp. " + harga, 
                        status          
                    });
                }
            }
        }
    } catch (SQLException e) {
        // pesan error jika gagal memuat data
        JOptionPane.showMessageDialog(null, 
            "Gagal memuat data reservasi: " + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
}

  
  // Metode untuk memperbarui status reservasi berdasarkan idReservasi
    public static boolean updateStatusReservasi(int idReservasi, String statusBaru) {
        try (Connection konek = DriverManager.getConnection(
                CommonConstants.DB_URL,
                CommonConstants.DB_NAMAPENGGUNA,
                CommonConstants.DB_KATASANDI)) {
            
            String sql = "UPDATE reservasi SET status = ? WHERE idReservasi = ?";
            try (PreparedStatement ps = konek.prepareStatement(sql)) {
                ps.setString(1, statusBaru);
                ps.setInt(2, idReservasi);
                int rowsUpdated = ps.executeUpdate();
                return rowsUpdated > 0; // Mengembalikan true jika ada baris yang diperbarui
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false; // Mengembalikan false jika terjadi kesalahan
        }
    }

    
    //Fungsi untuk mendapatkan total reservasi yang tercatat di tabel reservasi
    public static int getTotalReservasi() {
        //query untuk mengambil jumlah reservasi 
        String query = "SELECT COUNT(*) AS total FROM reservasi";
        
    try (Connection konek = DriverManager.getConnection(
            CommonConstants.DB_URL, 
            CommonConstants.DB_NAMAPENGGUNA, 
            CommonConstants.DB_KATASANDI);
         PreparedStatement ps = konek.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {

        if (rs.next()) {
            return rs.getInt("total"); // Ambil jumlah total reservasi
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Gagal mendapatkan total reservasi: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return 0; // Return 0 jika terjadi kesalahan
}
    
    
    //Fungsi untuk mendapatkan total reservasi dengan status "diterima" yang tercatat di tabel reservasi
    public static int getReservasiDiterima() {
        
        //query  untuk mengambil jumlah reservasi "diterima" 
        String query = "SELECT COUNT(*) AS diterima FROM reservasi WHERE status = 'Diterima'";
    try (Connection konek = DriverManager.getConnection(
            CommonConstants.DB_URL, 
            CommonConstants.DB_NAMAPENGGUNA, 
            CommonConstants.DB_KATASANDI);
         PreparedStatement ps = konek.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {

        if (rs.next()) {
            return rs.getInt("diterima"); // Ambil jumlah reservasi yang diterima
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Gagal mendapatkan jumlah reservasi diterima: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return 0; // Return 0 jika terjadi kesalahan
}

    //Fungsi untuk mendapatkan total reservasi dengan status "dibatalkan" yang tercatat di tabel reservasi
    public static int getReservasiDibatalkan() {
        
        //query  untuk mengambil jumlah reservasi "dibatalkan" 
        String query = "SELECT COUNT(*) AS dibatalkan FROM reservasi WHERE status = 'Dibatalkan'";
        
    try (Connection konek = DriverManager.getConnection(
            CommonConstants.DB_URL, 
            CommonConstants.DB_NAMAPENGGUNA, 
            CommonConstants.DB_KATASANDI);
         PreparedStatement ps = konek.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {

        if (rs.next()) {
            return rs.getInt("dibatalkan"); // Ambil jumlah reservasi yang ditolak atau dibatalkan
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Gagal mendapatkan jumlah reservasi dibatalkan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return 0; // Return 0 jika terjadi kesalahan
}
    
    
    //Fungsi untuk mendapatkan total reservasi dengan status "diterima" yang tercatat di tabel reservasi
    public static int getReservasiDitolak() {
        
        //query  untuk mengambil jumlah reservasi "ditolak" 
        String query = "SELECT COUNT(*) AS ditolak FROM reservasi WHERE status = 'Ditolak'";
        
    try (Connection konek = DriverManager.getConnection(
            CommonConstants.DB_URL, 
            CommonConstants.DB_NAMAPENGGUNA, 
            CommonConstants.DB_KATASANDI);
         PreparedStatement ps = konek.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {

        if (rs.next()) {
            return rs.getInt("ditolak"); // Ambil jumlah reservasi yang ditolak atau dibatalkan
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Gagal mendapatkan jumlah reservasi ditolak: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return 0; // Return 0 jika terjadi kesalahan
}


}
