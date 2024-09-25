package com.ciarabelle.starwars.data

data class VehicleList(
    override val count: Int? = null,
    override val next: String? = null,
    override val previous: String? = null,
    override val results: List<Vehicle>? = null,
    override val loading: Boolean = false,
) : ResourceList()

data class Vehicle(
    val cargo_capacity: String?,
    val consumables: String?,
    val cost_in_credits: String?,
    val created: String?,
    val crew: String?,
    val edited: String?,
    val films: List<String>?,
    val length: String?,
    val manufacturer: String?,
    val max_atmosphering_speed: String?,
    val model: String?,
    val name: String?,
    val passengers: String?,
    val pilots: List<String>?,
    val url: String?,
    val vehicle_class: String?,
)
