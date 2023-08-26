package com.ciarabelle.starwars.data

data class VehicleList(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Vehicle>
)