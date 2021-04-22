-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 22, 2021 at 07:00 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fundingbody`
--

-- --------------------------------------------------------

--
-- Table structure for table `fundingbd`
--

CREATE TABLE `fundingbd` (
  `fid` int(11) NOT NULL,
  `fname` varchar(45) DEFAULT NULL,
  `fcountry` varchar(45) DEFAULT NULL,
  `fyears` varchar(45) DEFAULT NULL,
  `fcategory` varchar(45) DEFAULT NULL,
  `frequirements` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `fundingbd`
--

INSERT INTO `fundingbd` (`fid`, `fname`, `fcountry`, `fyears`, `fcategory`, `frequirements`) VALUES
(5, 'shakila', 'Sri Lanka', '4', 'electronic', 'proffesionalism'),
(6, 'Saduni', 'India', '2', 'Sciencetistic', 'proffessionalism'),
(7, 'Hasini', 's', '0714456653', 'd', ''),
(8, 'Hasini', 'America', '3', 'd', '');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `usename` varchar(21) NOT NULL,
  `pass` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`usename`, `pass`) VALUES
('admin', 'a123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `fundingbd`
--
ALTER TABLE `fundingbd`
  ADD PRIMARY KEY (`fid`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`usename`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `fundingbd`
--
ALTER TABLE `fundingbd`
  MODIFY `fid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
