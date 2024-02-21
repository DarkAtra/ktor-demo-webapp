package de.darkatra

import kotlinx.html.HTML
import kotlinx.html.body
import kotlinx.html.classes
import kotlinx.html.div
import kotlinx.html.h1
import kotlinx.html.head
import kotlinx.html.link
import kotlinx.html.meta
import kotlinx.html.script
import java.nio.charset.StandardCharsets

object DashboardPage {

    context(HTML)
    fun render() {

        head {
            meta(charset = StandardCharsets.UTF_8.name())
            meta(name = "viewport", content = "width=device-width, initial-scale=1.0")
            script(src = "https://cdn.tailwindcss.com") {}
            link(href = "/styles/style.css", rel = "stylesheet")
            link(href = "https://rsms.me/inter/inter.css", rel = "stylesheet")
        }

        body {
            classes = setOf("p-2")

            h1 {
                classes = setOf("text-3xl", "font-bold")
                +"Dashboard"
            }

            div {
                classes = setOf("py-2")
                +"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus commodo elit id vestibulum molestie. Mauris sodales elementum ultricies. Suspendisse molestie libero eu erat dignissim suscipit. Phasellus ac suscipit libero. Aenean ut augue magna. Nunc sed arcu a mi cursus euismod. Curabitur ac ante eu sem rhoncus porttitor ut ultricies urna. Nulla facilisi. Etiam suscipit, eros non porta faucibus, ex nisl tincidunt enim, eu vehicula nunc quam sit amet purus."
            }
        }
    }
}
