package de.darkatra

import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.engine.embeddedServer
import io.ktor.server.html.respondHtml
import io.ktor.server.http.content.staticResources
import io.ktor.server.netty.Netty
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun Application.module() {
    routing {

        staticResources("/", "static")

        get("/") {
            call.respondHtml {
                DashboardPage.render()
            }
        }
    }
}

fun main() {

    val server = embeddedServer(
        factory = Netty,
        host = "0.0.0.0",
        port = 8080,
        module = Application::module
    )

    server.start(wait = true)
}
