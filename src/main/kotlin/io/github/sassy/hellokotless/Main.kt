package io.github.sassy.hellokotless

import io.kotless.dsl.ktor.Kotless
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.routing
import io.ktor.routing.get

object Main : Kotless() {
    override fun prepare(app: Application) {
        app.routing {
            get("/") {
                call.respondText { "Hello, World!" }
            }

            get("/test/{id}") {
                val param =  call.parameters["id"]
                call.respondText {
                   if (param == null) "test" else param
                }
            }
        }
    }
}
