package com.fm.bountysystem.rest.hello

fun serviceHello(): String {
    return "Holaaaaaa"
}

fun ho(f: () -> String ): String {
    return f()
}

val s = ho(::serviceHello)

