package de.darkatra

import kotlinx.html.HTMLTag

fun HTMLTag.hxGet(url: String) {
    attributes["hx-get"] = url
}

fun HTMLTag.hxTarget(selector: String) {
    attributes["hx-target"] = selector
}

fun HTMLTag.hxPushUrl(url: String) {
    attributes["hx-push-url"] = url
}

fun HTMLTag.hxSwapOob(swap: String) {
    attributes["hx-swap-oob"] = swap
}
