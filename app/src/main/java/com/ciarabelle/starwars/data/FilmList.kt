package com.ciarabelle.starwars.data

data class FilmList(
    val count: Int,
    val next: Any,
    val previous: Any,
    val films: List<Film>
)