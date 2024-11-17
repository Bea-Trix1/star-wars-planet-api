package com.bea.star_wars_planet_api.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.bea.star_wars_planet_api.common.PlanetConstants.INVALID_PLANET;
import static com.bea.star_wars_planet_api.common.PlanetConstants.PLANET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PlanetServiceTest {
    
    @InjectMocks
    private PlanetService planetService;

    @Mock
    private PlanetRepository repository;

    @Test
    public void create_planet_WithValidData_returnsPlanet() {
        when(repository.save(PLANET)).thenReturn(PLANET);

        Planet planet = planetService.create(PLANET);

        assertThat(planet).isEqualTo(PLANET);
    }
    
    @Test
    public void crete_planet_WithInvalidData_ThrowsException(){
        when(repository.save(INVALID_PLANET)).thenThrow(RuntimeException.class);

        assertThatThrownBy(() -> repository.save(INVALID_PLANET)).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void getPlanet_byExistingId_returnsPlanet() {
        when(repository.findById(123L)).thenReturn(Optional.of(PLANET));
        
        Planet planet = planetService.getById(123L).get();
        
        assertThat(planet).isNotNull();
        assertThat(planet).isEqualTo(PLANET);
    }

    @Test
    public void getPlanet_byUnexistingId_returnsEmpty() {
        when(repository.findById(123L)).thenReturn(Optional.empty());
        
        assertThat(planetService.getById(123L)).isEmpty();
    }

    @Test
    public void findPlanet__returnsAllPlanets() {
        when(repository.findAll()).thenReturn(List.of(PLANET));
        
        Planet planet = planetService.findPlanet().iterator().next();
        
        assertThat(planet).isEqualTo(PLANET);
    }

    @Test
    public void findPlanet_returnsEmpty() {
        when(repository.findAll()).thenReturn(List.of());
        
        assertThat(planetService.findPlanet()).isEmpty();
    }
}
