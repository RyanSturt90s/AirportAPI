/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.kge.airports.controllers;

import br.eti.kge.airports.DTO.AirportMinDTO;
import br.eti.kge.airports.entities.Airport;
import br.eti.kge.airports.service.AirportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sesidevb
 */

@RestController
public class AirportController {
    
    @Autowired
    private AirportService airportService;
    
    /**
     * Endpoint /airports/city/{cityName}
     * @param iataCode
     * @return
     */
    @GetMapping("/iatacode/{iataCode}")
    public ResponseEntity<Airport> findByIataCode(@PathVariable String iataCode) {
        Airport result = airportService.findByIataCode(iataCode);
        
        if (result == null) {
            // Ops.. Aeroporto vazio...
            // notFound devolve 404
            return ResponseEntity.notFound().build();
            
        } else {
            // Eba! Tem dados!
            // ok devolve 200
            return ResponseEntity.ok(result);
        } 
    }
}