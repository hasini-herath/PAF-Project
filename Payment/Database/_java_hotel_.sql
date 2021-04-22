-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 22, 2021 at 07:06 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `payment`
--

-- --------------------------------------------------------

--
-- Table structure for table `payment_table`
--

CREATE TABLE `payment_table` (
  `payment_id` int(11) NOT NULL,
  `customer_n` varchar(100) NOT NULL,
  `amount` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `card_type` varchar(100) NOT NULL,
  `card_no` varchar(100) NOT NULL,
  `exp_month` varchar(100) NOT NULL,
  `exp_year` varchar(100) NOT NULL,
  `cvn` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payment_table`
--

INSERT INTO `payment_table` (`payment_id`, `customer_n`, `amount`, `email`, `card_type`, `card_no`, `exp_month`, `exp_year`, `cvn`) VALUES
(1, 'Nipun', '150000', 'nipun@gmail.com', 'Master', '7895422698238542', '5', '25', '456');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `payment_table`
--
ALTER TABLE `payment_table`
  ADD PRIMARY KEY (`payment_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `payment_table`
--
ALTER TABLE `payment_table`
  MODIFY `payment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
