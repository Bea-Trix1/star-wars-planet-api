package com.bea.star_wars_planet_api.common;

import com.bea.star_wars_planet_api.domain.Planet;

public class PlanetConstants {
    public static final Planet PLANET = new Planet("name", "climate", "terrain");
    public static final Planet INVALID_PLANET = new Planet("name", "climate", "terrain");

}