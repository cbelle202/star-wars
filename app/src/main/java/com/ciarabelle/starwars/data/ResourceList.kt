package com.ciarabelle.starwars.data

open class ResourceList(
    open val loading: Boolean = false,
    open val results: List<Any>? = null,
)
