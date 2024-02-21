package de.darkatra.layouts

import de.darkatra.OptionalPlaceholder
import de.darkatra.components.container.containerClasses
import de.darkatra.components.navigation.navigation
import de.darkatra.insert
import io.ktor.server.html.Placeholder
import io.ktor.server.html.Template
import io.ktor.server.html.insert
import kotlinx.html.FlowContent
import kotlinx.html.HTML
import kotlinx.html.body
import kotlinx.html.classes
import kotlinx.html.div
import kotlinx.html.footer
import kotlinx.html.head
import kotlinx.html.header
import kotlinx.html.link
import kotlinx.html.main
import kotlinx.html.meta
import kotlinx.html.script
import java.nio.charset.StandardCharsets

class MainLayout : Template<HTML> {

    val mainSlot = Placeholder<FlowContent>()
    val breadcrumbSlot = OptionalPlaceholder<FlowContent>()

    override fun HTML.apply() {

        classes = setOf("h-full")

        head {
            meta(charset = StandardCharsets.UTF_8.name())
            meta(name = "viewport", content = "width=device-width, initial-scale=1.0")
            link(href = "/styles/main-layout-style.css", rel = "stylesheet")
            script(src = "https://cdn.tailwindcss.com") {}
        }

        body {
            classes = setOf("h-full")

            header {
                navigation()
            }

            if (breadcrumbSlot.hasContent()) {
                div {
                    classes = setOf("breadcrumb")

                    insert(breadcrumbSlot)
                }
            }

            main {
                insert(mainSlot)
            }

            footer {
                classes = setOf("bg-gray-800", "p-4")

                div {
                    classes = containerClasses() + setOf("text-white")
                    +"A tiny little footer"
                }
            }
        }
    }
}
