-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 28, 2024 at 11:41 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `restar`
--

-- --------------------------------------------------------

--
-- Table structure for table `layanan`
--

CREATE TABLE `layanan` (
  `idLayanan` int(11) NOT NULL,
  `jenisLayanan` varchar(100) DEFAULT NULL,
  `namaLayanan` varchar(100) DEFAULT NULL,
  `deskripsi` varchar(150) DEFAULT NULL,
  `harga` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `layanan`
--

INSERT INTO `layanan` (`idLayanan`, `jenisLayanan`, `namaLayanan`, `deskripsi`, `harga`) VALUES
(1, 'Potong Rambut', 'Butterfly Haircut', 'Cocok untuk wajah oval, dan Panjang', 120000),
(2, 'Potong Rambut', 'Bob Haircut', 'Cocok untuk wajah oval, hati, dan persegi', 100000),
(3, 'Potong Rambut', 'Hime Haircut', 'Cocok untuk wajah oval atau lonjong', 140000),
(4, 'Potong Rambut', 'Wavy Haircut', 'Cocok untuk wajah oval, bulat, dan Panjang', 130000),
(5, 'Potong Rambut', 'Wolf Haircut', 'Cocok untuk wajah oval, bulat, hati, dan tirus', 120000),
(6, 'Potong Rambut', 'Pixie Haircut', 'Cocok untuk wajah oval dan bulat', 110000),
(7, 'Warna Rambut', 'Ash Purple', NULL, 100000),
(8, 'Warna Rambut', 'Ash Blonde', NULL, 90000),
(9, 'Warna Rambut', 'Ash Blue', NULL, 130000),
(10, 'Warna Rambut', 'Red Wine', NULL, 150000),
(11, 'Warna Rambut', 'Ash Brown', NULL, 120000),
(12, 'Warna Rambut', 'Ash Pink', NULL, 170000),
(13, 'Warna Rambut', 'Ash Rainbow', NULL, 200000),
(14, 'Warna Rambut', 'Ash Grey', NULL, 130000),
(15, 'Perawatan Rambut', 'Creambath', 'Perawatan dengan krim rambut untuk melembutkan, menutrisi, dan melembapkan', 150000),
(16, 'Perawatan Rambut', 'Hair Mask', 'Masker rambut untuk perbaikan rambut rusak dan menjaga kesehatan rambut', 100000),
(17, 'Perawatan Rambut', 'Smoothing', 'Meluruskan rambut dengan hasil lebih natural dibanding rebonding', 170000),
(18, 'Perawatan Rambut', 'Rebonding', 'Meluruskan rambut secara permanen, cocok untuk rambut sangat keriting', 200000);

-- --------------------------------------------------------

--
-- Table structure for table `reservasi`
--

CREATE TABLE `reservasi` (
  `idReservasi` int(11) NOT NULL,
  `idPelanggan` int(11) DEFAULT NULL,
  `idLayanan` int(11) DEFAULT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `tanggalReservasi` date DEFAULT NULL,
  `jamReservasi` time DEFAULT NULL,
  `namaPegawai` varchar(50) DEFAULT NULL,
  `status` enum('Proses','Diterima','Ditolak','Dibatalkan') DEFAULT 'Proses'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reservasi`
--

INSERT INTO `reservasi` (`idReservasi`, `idPelanggan`, `idLayanan`, `nama`, `tanggalReservasi`, `jamReservasi`, `namaPegawai`, `status`) VALUES
(1, 1, 5, 'jia', '2024-11-23', '00:00:09', 'Lala', 'Diterima'),
(2, 2, 4, 'lala', '2024-11-22', '00:00:09', 'Lala', 'Dibatalkan'),
(3, 1, 8, 'kaniz', '2024-11-29', '00:00:09', 'Delia', 'Ditolak'),
(4, 1, 5, 'Delia Nur Ilmi Salam', '2024-11-23', '00:00:15', 'Pipah', 'Diterima'),
(5, 2, 1, 'Afifah Fadilah', '2024-11-28', '00:00:09', 'Delia', 'Dibatalkan'),
(6, 2, 4, 'lala', '2024-11-29', '00:00:09', 'Jia', 'Dibatalkan'),
(7, 2, 3, 'Afifah Fadilah', '2024-11-27', '00:00:10', 'Delia', 'Diterima'),
(8, 3, 5, 'Kelompok 1', '2024-11-24', '00:00:09', 'Lala', 'Dibatalkan'),
(9, 3, 7, 'Kelompok 1', '2024-11-24', '00:00:10', 'Lala', 'Ditolak'),
(10, 3, 5, 'Kelompok 1', '2024-11-25', '00:00:11', 'Jia', 'Diterima'),
(11, 1, 18, 'Delia Nur Ilmi Salam', '2024-11-29', '00:00:15', 'Jia', 'Dibatalkan'),
(12, 4, 6, 'kaniz', '2024-11-29', '00:00:09', 'Lala', 'Dibatalkan'),
(13, 3, 4, 'Kelompok 1', '2024-11-27', '00:00:09', 'Lala', 'Dibatalkan');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `idPelanggan` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `noTelp` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `namaPelanggan` varchar(50) NOT NULL,
  `kataSandi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`idPelanggan`, `nama`, `noTelp`, `alamat`, `namaPelanggan`, `kataSandi`) VALUES
(1, 'Delia Nur Ilmi Salam', '088218985467', 'Garut', 'delia123', '090909'),
(2, 'Afifah Fadilah', '088218985543', 'Subang', 'pipah123', '123'),
(3, 'Kelompok 1', '089347194131', 'C_Informatika', 'Return \"A\"', 'kelompok1'),
(4, 'Lala jia', '088218985467', 'Garut', 'lalajia', '080808');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `layanan`
--
ALTER TABLE `layanan`
  ADD PRIMARY KEY (`idLayanan`);

--
-- Indexes for table `reservasi`
--
ALTER TABLE `reservasi`
  ADD PRIMARY KEY (`idReservasi`),
  ADD KEY `idLayanan` (`idLayanan`),
  ADD KEY `fk_idPelanggan` (`idPelanggan`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`idPelanggan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `layanan`
--
ALTER TABLE `layanan`
  MODIFY `idLayanan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `reservasi`
--
ALTER TABLE `reservasi`
  MODIFY `idReservasi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `idPelanggan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `reservasi`
--
ALTER TABLE `reservasi`
  ADD CONSTRAINT `fk_idPelanggan` FOREIGN KEY (`idPelanggan`) REFERENCES `users` (`idPelanggan`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reservasi_ibfk_1` FOREIGN KEY (`idLayanan`) REFERENCES `layanan` (`idLayanan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
