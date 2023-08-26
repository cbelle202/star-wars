package com.ciarabelle.starwars.data

data class CharacterList(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Character>
)