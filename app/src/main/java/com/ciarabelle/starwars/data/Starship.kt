package com.ciarabelle.starwars.data

data class StarshipList(
    override val count: Int? = null,
    override val next: String? = null,
    override val previous: String? = null,
    override val results: List<Starship>? = null,
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
        results = results as List<Starship>?,
        loading = loading ?: false,
    )
}

data class Starship(
    val MGLT: String?,
    val cargo_capacity: String?,
    val consumables: String?,
    val cost_in_credits: String?,
    val created: String?,
    val crew: String?,
    val edited: String?,
    val films: List<String>?,
    val hyperdrive_rating: String?,
    val length: String?,
    val manufacturer: String?,
    val max_atmosphering_speed: String?,
    val model: String?,
    val name: String?,
    val passengers: String?,
    val pilots: List<String>?,
    val starship_class: String?,
    val url: String?,
)
