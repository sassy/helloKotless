package io.github.sassy.hellokotless

import io.kotless.dsl.lang.http.Get

object Main {
    @Get("/")
    fun root(): String = "Hello world!"
}
