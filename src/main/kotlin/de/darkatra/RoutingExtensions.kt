package de.darkatra

import io.ktor.server.routing.Route
import io.ktor.server.routing.Routing
import io.ktor.server.routing.route

fun Routing.components(block: Route.() -> Unit = {}) {
    route("/components") {
        block()
    }
}
