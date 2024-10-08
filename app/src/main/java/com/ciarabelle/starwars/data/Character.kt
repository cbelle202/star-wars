package com.ciarabelle.starwars.data

data class CharacterList(
    override val count: Int? = null,
    override val next: String? = null,
    override val previous: String? = null,
    override val results: List<Character>? = null,
    override val loading: Boolean = false,
) : ResourceList()

data class Character(
    val birth_year: String?,
    val created: String?,
    val edited: String?,
    val eye_color: String?,
    val films: List<String>?,
    val gender: String?,
    val hair_color: String?,
    val height: String?,
    val homeworld: String?,
    val mass: String?,
    val name: String?,
    val skin_color: String?,
    val species: List<String>?,
    val starships: List<String>?,
    val url: String?,
    val vehicles: List<String>?,
)
