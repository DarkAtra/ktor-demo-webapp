package de.darkatra.components.navigation

import de.darkatra.containerClasses
import de.darkatra.hxGet
import de.darkatra.hxPushUrl
import de.darkatra.hxTarget
import io.ktor.server.request.ApplicationRequest
import io.ktor.server.request.path
import kotlinx.html.FlowContent
import kotlinx.html.a
import kotlinx.html.classes
import kotlinx.html.li
import kotlinx.html.nav
import kotlinx.html.ul

private data class NavigationEntry(
    val url: String,
    val text: String,
    val hxUrl: String
)

context(ApplicationRequest)
fun FlowContent.navigation() = nav {

    classes = setOf("bg-gray-800")

    ul {
        classes = containerClasses() + setOf("flex", "align-center", "gap-2")

        listOf(
            NavigationEntry(url = "/", text = "Home", hxUrl = "/components/dashboard"),
            NavigationEntry(url = "/demo", text = "Demo", hxUrl = "/components/demo")
        ).forEach { navigationEntry ->
            li {
                classes = setOf("first:-ml-4", "last:-mr-4")

                a {
                    classes = buildSet {
                        addAll(setOf("text-white", "cursor-pointer", "block", "p-4"))
                        if (path() == navigationEntry.url || path() == navigationEntry.hxUrl) {
                            add("underline")
                        }
                    }
                    hxGet(navigationEntry.hxUrl)
                    hxPushUrl(navigationEntry.url)
                    hxTarget("#main")
                    +navigationEntry.text
                }
            }
        }
    }
}
