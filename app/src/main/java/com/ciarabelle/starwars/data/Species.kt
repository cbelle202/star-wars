package com.ciarabelle.starwars.data

data class SpeciesList(
    override val count: Int? = null,
    override val next: String? = null,
    override val previous: String? = null,
    override val results: List<Species>? = null,
    override val loading: Boolean = false,
) : ResourceList() {
    override fun createCopy(
        count: Int?,
        next: String?,
        previous: String?,
        results: List<Any>?,
        loading: Boolean?,
    ): ResourceList = this.copy(
        count = count,
        next = next,
        previous = previous,
        results = results as List<Species>?,
        loading = loading ?: false,
    )
}

data class Species(
    val average_height: String?,
    val average_lifespan: String?,
    val classification: String?,
    val created: String?,
    val designation: String?,
    val edited: String?,
    val eye_colors: String?,
    val films: List<String>?,
    val hair_colors: String?,
    val homeworld: String?,
    val language: String?,
    val name: String?,
    val people: List<String>?,
    val skin_colors: String?,
    val url: String?
)
