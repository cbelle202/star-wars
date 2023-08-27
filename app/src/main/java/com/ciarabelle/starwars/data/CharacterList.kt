package com.ciarabelle.starwars.data

data class CharacterList(
    val count: Int?,
    val next: String?,
    val previous: String?,
    val results: List<Character>? = listOf(),
)
