package de.darkatra.components.navigation

import de.darkatra.components.container.containerClasses
import kotlinx.html.FlowContent
import kotlinx.html.a
import kotlinx.html.classes
import kotlinx.html.li
import kotlinx.html.nav
import kotlinx.html.ul

fun FlowContent.navigation() = nav {

    classes = setOf("bg-gray-800", "p-4")

    ul {
        classes = containerClasses() + setOf("flex", "align-center", "gap-10")

        li {
            a {
                classes = setOf("text-white")
                href = "/"
                +"Home"
            }
        }

        li {
            a {
                classes = setOf("text-white")
                href = "/demo"
                +"Demo"
            }
        }
    }
}
