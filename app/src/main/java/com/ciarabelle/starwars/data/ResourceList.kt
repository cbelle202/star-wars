package com.ciarabelle.starwars.data

open class ResourceList(
    open val count: Int? = null,
    open val next: String? = null,
    open val previous: String? = null,
    open val results: List<Any>? = null,
    open val loading: Boolean = false,
) {
    open fun createCopy(
        count: Int? = null,
        next: String? = null,
        previous: String? = null,
        results: List<Any>? = null,
        loading: Boolean? = null,
    ): ResourceList = ResourceList()
}
