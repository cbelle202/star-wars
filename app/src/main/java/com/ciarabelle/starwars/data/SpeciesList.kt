package com.ciarabelle.starwars.data

data class SpeciesList(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Species>
)