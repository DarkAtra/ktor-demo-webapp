package de.darkatra.pages

import de.darkatra.components.container.containerClasses
import de.darkatra.layouts.MainLayout
import kotlinx.html.classes
import kotlinx.html.div

object DashboardPage {

    context(MainLayout)
    fun render() {

        mainSlot {
            div {
                classes = containerClasses() + setOf("py-4")
                +"""Lorem ipsum dolor sit amet, consectetur adipiscing elit.Mauris pretium lacinia sapien quis pretium. Quisque ultricies, elit vitae pharetra
                    |ultrices, massa ipsum ultrices dolor, sit amet sagittis tortor nibh ut nisl. Donec laoreet scelerisque pharetra. Vestibulum a pretium
                    |justo. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Quisque fermentum luctus semper.
                    |Nullam vestibulum felis non laoreet finibus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur augue justo, tempus nec
                    |luctus vel, tincidunt id urna. """.trimMargin()
            }
        }
    }
}
