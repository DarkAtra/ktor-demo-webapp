package de.darkatra.layouts

import de.darkatra.components.navigation.navigation
import de.darkatra.containerClasses
import io.ktor.server.html.Placeholder
import io.ktor.server.html.Template
import io.ktor.server.html.insert
import io.ktor.server.request.ApplicationRequest
import kotlinx.html.FlowContent
import kotlinx.html.HTML
import kotlinx.html.body
import kotlinx.html.classes
import kotlinx.html.div
import kotlinx.html.footer
import kotlinx.html.head
import kotlinx.html.header
import kotlinx.html.id
import kotlinx.html.link
import kotlinx.html.main
import kotlinx.html.meta
import kotlinx.html.script
import java.nio.charset.StandardCharsets

class MainLayout(
    private val request: ApplicationRequest
) : Template<HTML> {

    val mainSlot = Placeholder<FlowContent>()

    override fun HTML.apply() {

        classes = setOf("h-full")

        head {
            meta(charset = StandardCharsets.UTF_8.name())
            meta(name = "viewport", content = "width=device-width, initial-scale=1.0")
            link(href = "/styles/main-layout-style.css", rel = "stylesheet")
            script(src = "https://cdn.tailwindcss.com") {}
            script(src = "https://unpkg.com/htmx.org@1.9.10") {
                integrity = "sha384-D1Kt99CQMDuVetoL1lrYwg5t+9QdHe7NLX/SoJYkXDFfX37iInKRy5xLSi8nO7UC"
                attributes["crossorigin"] = "anonymous"
            }
        }

        body {
            classes = setOf("h-full")

            header {
                id = "header"
                with(request) {
                    navigation()
                }
            }

            main {
                id = "main"
                insert(mainSlot)
            }

            footer {
                classes = setOf("bg-gray-800")

                div {
                    classes = containerClasses() + setOf("p-4", "text-white")
                    +"A tiny little footer"
                }
            }
        }
    }
}
