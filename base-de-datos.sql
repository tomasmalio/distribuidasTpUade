-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: inmobiliaria
-- 
-- Integrantes:
--	- Tomás Malio
--	- Florencia Otero
--	- Martin Sacco
-- ------------------------------------------------------
-- Server version	5.7.21

CREATE DATABASE inmobiliaria;

/**
 * Personas
 **/
DROP TABLE IF EXISTS `personas`;
CREATE TABLE `personas` (
  `cuil_cuit` varchar(255) NOT NULL,
  `domicilio` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `nombre_razon` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cuil_cuit`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/**
 * Propiedades
 **/
DROP TABLE IF EXISTS `propiedades`;
CREATE TABLE `propiedades` (
  `nroPartida` varchar(255) NOT NULL,
  `calle` varchar(255) DEFAULT NULL,
  `cantidadAmbientes` varchar(255) DEFAULT NULL,
  `ciudad` varchar(255) DEFAULT NULL,
  `departamento` varchar(255) DEFAULT NULL,
  `expensas` float NOT NULL,
  `impuestos` float NOT NULL,
  `metrosCubiertos` float NOT NULL,
  `numero` int(11) NOT NULL,
  `piso` varchar(255) DEFAULT NULL,
  `servicios` float NOT NULL,
  `valorAlquiler` float NOT NULL,
  `valorVenta` float NOT NULL,
  `persona_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`nroPartida`),
  KEY `FKnn4n4qsq9yta706tax4fiiufk` (`persona_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/**
 * Servicio / Ventas
 **/
DROP TABLE IF EXISTS `ventas`;
CREATE TABLE `ventas` (
  `id` int(11) NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `comisionVenta` float NOT NULL,
  `fechaEscritura` datetime NOT NULL,
  `gastosEscritura` float NOT NULL,
  `valorEscritura` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/**
 * Servicio / Alquileres
 **/
DROP TABLE IF EXISTS `alquileres`;
CREATE TABLE `alquileres` (
  `id` int(11) NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `comisionGestion` float NOT NULL,
  `fechaDesde` datetime NOT NULL,
  `fechaHasta` datetime NOT NULL,
  `gastosSellado` float NOT NULL,
  PRIMARY KEY (`id`)

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;