-- phpMyAdmin SQL Dump
-- version 3.2.0.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 19, 2015 at 04:02 AM
-- Server version: 5.1.36
-- PHP Version: 5.3.0

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `bankdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounttbl`
--

DROP TABLE IF EXISTS `accounttbl`;
CREATE TABLE IF NOT EXISTS `accounttbl` (
  `accnum` int(10) NOT NULL,
  `applicant_name` varchar(50) NOT NULL,
  `applicant_dob` varchar(50) NOT NULL,
  `applicant_gender` varchar(50) NOT NULL,
  `applicant_profession` varchar(50) NOT NULL,
  `applicant_address` varchar(50) NOT NULL,
  `account_mode` varchar(50) NOT NULL,
  `guaranter_name` varchar(50) NOT NULL,
  `guaranter_accnum` varchar(50) NOT NULL,
  `guaranter_address` varchar(50) NOT NULL,
  PRIMARY KEY (`accnum`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accounttbl`
--

INSERT INTO `accounttbl` (`accnum`, `applicant_name`, `applicant_dob`, `applicant_gender`, `applicant_profession`, `applicant_address`, `account_mode`, `guaranter_name`, `guaranter_accnum`, `guaranter_address`) VALUES
(1, 'vivek ', '21/7/2015', 'male', 'student', 'Ispat Nagar', 'saving', 'jay', '0', 'Maitri Nagar'),
(2, 'ajay', '23/7/2015', 'male', 'student', 'Maitri Nagar', 'saving', 'vivek', '1', 'Ispat Nagar'),
(3, 'ritu', '25/7/2015', 'female', 'student', 'VIP Nagar', 'current', 'ajay', '2', 'Maitri Nagar'),
(4, 'rakesh', '23/7/2015', 'male', 'student', 'Risali Sector', 'saving', 'ritu', '3', 'VIP Nagar');

-- --------------------------------------------------------

--
-- Table structure for table `transactiontbl`
--

DROP TABLE IF EXISTS `transactiontbl`;
CREATE TABLE IF NOT EXISTS `transactiontbl` (
  `accnum` int(10) NOT NULL,
  `Date` varchar(50) NOT NULL,
  `Type` varchar(50) NOT NULL,
  `Amount` int(50) NOT NULL,
  `Mode` varchar(50) NOT NULL,
  `Balance` int(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transactiontbl`
--

INSERT INTO `transactiontbl` (`accnum`, `Date`, `Type`, `Amount`, `Mode`, `Balance`) VALUES
(1, 'Wed Jul 26 12:35:16 IST 2015', 'Deposit', 10000, 'Cash', 10000),
(2, 'Wed Jul 26 12:35:16 IST 2015', 'Deposit', 15000, 'Cash', 15000),
(3, 'Wed Jul 26 12:35:16 IST 2015', 'Deposit', 2000, 'Cash', 2000),
(1, 'Thu Jul 27 12:35:16 IST 2015', 'Withdrawl', 1000, 'Cash', 9000),
(2, 'Thu Jul 26 12:35:16 IST 2015', 'Withdrawl', 2000, 'Cash', 13000);

-- --------------------------------------------------------

--
-- Table structure for table `usertbl`
--

DROP TABLE IF EXISTS `usertbl`;
CREATE TABLE IF NOT EXISTS `usertbl` (
	`userid` varchar(10) NOT NULL,
	`userpassword` varchar(10) NOT NULL,
	PRIMARY KEY (`userid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usertbl`
--

INSERT INTO `usertbl` (`userid`, `userpassword`) VALUES
('roopesh', 'roopesh'),
('shatrughan', 'shatrughan'),
('a', 'a'),
('admin', 'admin');
