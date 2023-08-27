package com.ciarabelle.starwars.data

data class CharacterList(
    val count: Int?,
    val next: String?,
    val previous: String?,
    override val results: List<Character>?,
    override val loading: Boolean = false,
) : ResourceList()
