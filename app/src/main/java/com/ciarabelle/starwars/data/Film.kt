package com.ciarabelle.starwars.data

data class FilmList(
    override val count: Int? = null,
    override val next: String? = null,
    override val previous: String? = null,
    override val results: List<Film>? = null,
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
        results = results as List<Film>?,
        loading = loading ?: false,
    )
}

data class Film(
    val characters: List<String>,
    val created: String,
    val director: String,
    val edited: String,
    val episode_id: Int,
    val opening_crawl: String,
    val planets: List<String>,
    val producer: String,
    val release_date: String,
    val species: List<String>,
    val starships: List<String>,
    val title: String,
    val url: String,
    val vehicles: List<String>
)
