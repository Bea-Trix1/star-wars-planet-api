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
}
