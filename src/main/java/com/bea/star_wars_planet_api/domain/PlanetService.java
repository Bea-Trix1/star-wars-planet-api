package com.bea.star_wars_planet_api.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class PlanetService {
    
    private PlanetRepository planetRepository;
    
    public PlanetService(PlanetRepository planetRepository){
        this.planetRepository = planetRepository;
    }

    public Planet create(Planet planet){
        return planetRepository.save(planet);
    }

    public Optional <Planet> getById(Long id){
        return planetRepository.findById(id);
    }

    public Iterable<Planet> findPlanet(){
        return planetRepository.findAll();
    }

}
