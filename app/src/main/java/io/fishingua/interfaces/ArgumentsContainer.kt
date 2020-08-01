package io.fishingua.interfaces

interface ArgumentsContainer {
    fun <T> putArgument(name: String, value: T)
}