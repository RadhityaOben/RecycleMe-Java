-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 20, 2023 at 05:44 PM
-- Server version: 8.0.30
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `recycleme`
--

-- --------------------------------------------------------

--
-- Table structure for table `dropbox`
--

CREATE TABLE `dropbox` (
  `id` int NOT NULL,
  `nama` varchar(255) NOT NULL,
  `lokasi` text NOT NULL,
  `id_masyarakat` int NOT NULL,
  `id_kurir` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `dropbox_jenis`
--

CREATE TABLE `dropbox_jenis` (
  `id` int NOT NULL,
  `id_dropbox` int NOT NULL,
  `id_jenis` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `jenis`
--

CREATE TABLE `jenis` (
  `id` int NOT NULL,
  `nama` varchar(255) NOT NULL,
  `id_kategori` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE `kategori` (
  `id` int NOT NULL,
  `nama` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `kurir`
--

CREATE TABLE `kurir` (
  `id` int NOT NULL,
  `nama` varchar(255) NOT NULL,
  `no_hp` char(13) NOT NULL,
  `status_registrasi` enum('Disetujui','Ditolak') NOT NULL,
  `status_penjemputan` enum('Tidak ada penjemputan','Sedang menjemput','Dalam perjalanan','Selesai') NOT NULL,
  `kelengkapan_berkas` enum('Lengkap','Tidak lengkap') NOT NULL,
  `jenis_kendaraan` enum('Roda 2','Roda 4','Lebih dari roda 4') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `masyarakat`
--

CREATE TABLE `masyarakat` (
  `id` int NOT NULL,
  `nama` varchar(255) NOT NULL,
  `alamat` text NOT NULL,
  `email` varchar(255) NOT NULL,
  `no_hp` char(13) NOT NULL,
  `status_registrasi` enum('Disetujui','Ditolak') NOT NULL,
  `status_penjemputan` enum('Tidak ada penjemputan','Menunggu','Sedang dijemput','Selesai') NOT NULL,
  `metode_pembayaran` enum('Cash','Debit','Kredit') NOT NULL,
  `poin` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `masyarakat`
--

INSERT INTO `masyarakat` (`id`, `nama`, `alamat`, `email`, `no_hp`, `status_registrasi`, `status_penjemputan`, `metode_pembayaran`, `poin`) VALUES
(1, 'Radit', 'Jl. Kemana Saja', 'radit@gmail.com', '091234567890', 'Ditolak', 'Tidak ada penjemputan', 'Cash', 0),
(2, 'Lanang', 'Jl.123', 'lanang@gmail.com', '080987654321', 'Ditolak', 'Tidak ada penjemputan', 'Cash', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dropbox`
--
ALTER TABLE `dropbox`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_dropbox_masyarakat` (`id_masyarakat`),
  ADD KEY `fk_dropbox_kurir` (`id_kurir`);

--
-- Indexes for table `dropbox_jenis`
--
ALTER TABLE `dropbox_jenis`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_dropbox` (`id_dropbox`),
  ADD KEY `fk_jenis` (`id_jenis`);

--
-- Indexes for table `jenis`
--
ALTER TABLE `jenis`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_jenis_kategori` (`id_kategori`);

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `kurir`
--
ALTER TABLE `kurir`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `masyarakat`
--
ALTER TABLE `masyarakat`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dropbox_jenis`
--
ALTER TABLE `dropbox_jenis`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dropbox`
--
ALTER TABLE `dropbox`
  ADD CONSTRAINT `fk_dropbox_kurir` FOREIGN KEY (`id_kurir`) REFERENCES `kurir` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `fk_dropbox_masyarakat` FOREIGN KEY (`id_masyarakat`) REFERENCES `masyarakat` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `dropbox_jenis`
--
ALTER TABLE `dropbox_jenis`
  ADD CONSTRAINT `fk_dropbox` FOREIGN KEY (`id_dropbox`) REFERENCES `dropbox` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `fk_jenis` FOREIGN KEY (`id_jenis`) REFERENCES `jenis` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `jenis`
--
ALTER TABLE `jenis`
  ADD CONSTRAINT `fk_jenis_kategori` FOREIGN KEY (`id_kategori`) REFERENCES `kategori` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
