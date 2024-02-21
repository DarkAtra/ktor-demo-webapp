package de.darkatra

import io.ktor.server.html.respondHtmlTemplate

/**
 * A placeholder that is inserted inside [TOuter].
 * Allows checking if it has content or not.
 * @see [respondHtmlTemplate]
 */
open class OptionalPlaceholder<TOuter> {

    @Suppress("MemberVisibilityCanBePrivate")
    var meta: String = ""
    private var content: (TOuter.(OptionalPlaceholder<TOuter>) -> Unit)? = null

    operator fun invoke(meta: String = "", content: TOuter.(OptionalPlaceholder<TOuter>) -> Unit) {
        this.meta = meta
        this.content = content
    }

    fun apply(destination: TOuter) {
        destination.(content ?: {})(this)
    }

    fun hasContent(): Boolean {
        return content != null
    }
}

fun <TOuter> TOuter.insert(optionalPlaceholder: OptionalPlaceholder<TOuter>): Unit = optionalPlaceholder.apply(this)
