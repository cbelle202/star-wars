package com.ciarabelle.starwars.data

data class PlanetList(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Planet>
)