package de.darkatra.pages

import de.darkatra.components
import de.darkatra.components.navigation.navigation
import de.darkatra.containerClasses
import de.darkatra.layouts.MainLayout
import io.ktor.server.application.call
import io.ktor.server.html.respondHtml
import io.ktor.server.html.respondHtmlTemplate
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get
import kotlinx.html.FlowContent
import kotlinx.html.body
import kotlinx.html.classes
import kotlinx.html.div
import kotlinx.html.id

object DemoPage {

    context(Routing)
    fun setupRoutes() {

        get("/demo") {
            call.respondHtmlTemplate(MainLayout(call.request)) {
                render()
            }
        }

        components {
            get("/demo") {
                call.respondHtml {
                    body {
                        mainSlot()
                        div {
                            id = "header"
                            attributes["hx-swap-oob"] = "innerHTML"
                            with(call.request) {
                                navigation()
                            }
                        }
                    }
                }
            }
        }
    }

    context(MainLayout)
    private fun render() {
        mainSlot {
            mainSlot()
        }
    }

    context(FlowContent)
    private fun mainSlot() {
        div {
            classes = containerClasses() + setOf("py-4")
            +"Demo Demo Demo"
        }
    }
}
