package com.ciarabelle.starwars.data

data class FilmList(
    val count: Int?,
    val next: String?,
    val previous: String?,
    override val results: List<Film>?,
    override val loading: Boolean = false,
) : ResourceList()
