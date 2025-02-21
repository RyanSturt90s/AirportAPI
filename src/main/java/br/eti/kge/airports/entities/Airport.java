/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.kge.airports.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author sesidevb
 */
@Entity
@Table(name = "airport")
public class Airport {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String city;
    private String country;

    @Column(name = "iatacode")
    private String iataCode;

    @Column(name = "icaocode")
    private String icaoCode;

    private double latitude;
    private double longitude;
    private double altitude;

    @Column(name = "offsetutc")
    private double offsetFromUTC;

    @Column(name = "dstcode")
    private String dstCode;
    private String timezone;
}
