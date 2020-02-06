-- phpMyAdmin SQL Dump
-- version 4.7.1
-- https://www.phpmyadmin.net/
--
-- Host: sql7.freemysqlhosting.net
-- Generation Time: Nov 28, 2019 at 01:12 PM
-- Server version: 5.5.58-0ubuntu0.14.04.1
-- PHP Version: 7.0.33-0ubuntu0.16.04.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sql7313469`
--

-- --------------------------------------------------------

--
-- Table structure for table `Autorekisteri`
--

CREATE TABLE `Autorekisteri` (
  `auto_id` int(11) NOT NULL,
  `Rekisterinumero` varchar(7) NOT NULL,
  `Merkki` varchar(24) NOT NULL,
  `Malli` varchar(24) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Autorekisteri`
--

INSERT INTO `Autorekisteri` (`auto_id`, `Rekisterinumero`, `Merkki`, `Malli`) VALUES
(2, 'CEL-233', 'Skoda', 'Octavia'),
(4, 'AAV-612', 'Volkswagen', 'Polo'),
(8, 'KAL-414', 'Toyota', 'Yaris'),
(9, 'SHI-722', 'Kia', 'Ceed'),
(11, 'CVV-999', 'Honda', 'Civic'),
(16, 'OOF-879', 'Nissan', 'Juke'),
(19, 'ABC-123', 'Volkswagen', 'Golf'),
(27, 'CEK-333', 'ei määritelty', 'Golf'),
(47, 'LAA-333', 'Fiat', 'Punto'),
(49, 'MAL', 'Toyota', 'Hiace'),
(51, 'OOO-333', 'Toyota', 'Hiace');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Autorekisteri`
--
ALTER TABLE `Autorekisteri`
  ADD PRIMARY KEY (`auto_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Autorekisteri`
--
ALTER TABLE `Autorekisteri`
  MODIFY `auto_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
