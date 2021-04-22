-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 22, 2021 at 07:06 PM
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
-- Database: `reseacher`
--

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `pid` int(11) NOT NULL,
  `pcode` varchar(45) DEFAULT NULL,
  `pname` varchar(45) DEFAULT NULL,
  `pcatelog` varchar(45) DEFAULT NULL,
  `pprice` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`pid`, `pcode`, `pname`, `pcatelog`, `pprice`) VALUES
(1, 's', 'x', ' x', 's'),
(2, NULL, NULL, NULL, NULL),
(3, 'd', 'c', 'd', 'd');

-- --------------------------------------------------------

--
-- Table structure for table `rdetails`
--

CREATE TABLE `rdetails` (
  `rid` int(11) NOT NULL,
  `fname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `bdate` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `inoctgry` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `edustate` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `cpasswored` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rdetails`
--

INSERT INTO `rdetails` (`rid`, `fname`, `lname`, `phone`, `bdate`, `email`, `inoctgry`, `country`, `edustate`, `password`, `cpasswored`) VALUES
(5, 'dulmi', 'nawya', '0715565456', '1997/02/23', 'dul@gmail.com', 'Scientific', 'Sri Lanka', 'undergratuate', 'dul@', 'dyl@'),
(6, 'sach', 'herath', '0712234432', '1999/03/12', 'sach22@gmail.com', '', '', '', '', ''),
(8, 'gggggggg', '', '', '', '', '', '', '', '', ''),
(9, 'Hasini', 'Shiwanya', 'Shiwanya', 'd', '', '', NULL, '', '', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`pid`);

--
-- Indexes for table `rdetails`
--
ALTER TABLE `rdetails`
  ADD PRIMARY KEY (`rid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `pid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `rdetails`
--
ALTER TABLE `rdetails`
  MODIFY `rid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
