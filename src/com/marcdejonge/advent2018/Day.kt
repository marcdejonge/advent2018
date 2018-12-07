package com.marcdejonge.advent2018

import java.io.FileReader
import java.util.*

abstract class Day<T>(private val day: Int, mapper: (String) -> T) {
    private val data: List<T> = Collections.unmodifiableList(FileReader("res/day$day.txt").readLines().map(mapper))

    abstract fun part1(data: List<T>): Any

    abstract fun part2(data: List<T>): Any

    fun <R> time(name: String, function: (List<T>) -> R): R {
        val start = System.nanoTime()
        val result = function(data)
        val time = Math.round((System.nanoTime() - start) / 100000.0) / 10.0
        println("$name took $time ms")
        return result
    }

    fun run() {
        println("=== Day $day ===")
        time("Preparing", this::prepare)
        println()
        val result1 = time("Part 1", this::part1)
        println("Result part 1: $result1")
        println()
        val result2 = time("Part 2", this::part2)
        println("Result part 2: $result2")
        println()
    }

    open fun prepare(data: List<T>) {}
}
