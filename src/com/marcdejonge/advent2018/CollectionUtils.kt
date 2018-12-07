package com.marcdejonge.advent2018

import java.util.concurrent.atomic.AtomicInteger

fun <T> Iterable<T>.frequency(): Map<T, Int> {
    val result = HashMap<T, AtomicInteger>()

    for (elem in this) {
        result.computeIfAbsent(elem) { AtomicInteger() }.incrementAndGet()
    }

    return result.mapValues { e -> e.value.get() }
}