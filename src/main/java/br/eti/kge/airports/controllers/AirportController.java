/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.kge.airports.controllers;

import br.eti.kge.airports.DTO.AirportMinDTO;
import br.eti.kge.airports.DTO.AirportNearMeDTO;
import br.eti.kge.airports.entities.Airport;
import br.eti.kge.airports.service.AirportService;
import java.util.List;
import static org.apache.logging.log4j.ThreadContext.isEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
     * @param latitude
     * @param longitude
     * @return
     */
    @GetMapping("/nearme")
    public ResponseEntity<List<AirportNearMeDTO>> findByNearMe(
            @RequestParam double latitude,
            @RequestParam double longitude ) {
        
        List<AirportNearMeDTO> result = airportService.findNearMe(latitude, longitude);
        
        if (result.isEmpty()) {
            // Ops.. lista vazia...
            // notFound devolve 404
            return ResponseEntity.notFound().build();
            
        } else {
            // Eba! Tem dados!
            // ok devolve 200
            return ResponseEntity.ok(result);
        } 
    }
}