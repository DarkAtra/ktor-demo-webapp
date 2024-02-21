package de.darkatra

import de.darkatra.layouts.MainLayout
import de.darkatra.pages.DashboardPage
import de.darkatra.pages.DemoPage
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.engine.embeddedServer
import io.ktor.server.html.respondHtmlTemplate
import io.ktor.server.http.content.staticResources
import io.ktor.server.netty.Netty
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun Application.module() {
    routing {

        staticResources("/", "static")

        get("/") {
            call.respondHtmlTemplate(MainLayout()) {
                DashboardPage.render()
            }
        }

        get("/demo") {
            call.respondHtmlTemplate(MainLayout()) {
                DemoPage.render()
            }
        }
    }
}

fun main() {

    val server = embeddedServer(
        factory = Netty,
        host = "0.0.0.0",
        port = 8080,
        module = Application::module,
        watchPaths = listOf("target")
    )

    server.start(wait = true)
}
