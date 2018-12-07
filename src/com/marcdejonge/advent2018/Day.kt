package com.marcdejonge.advent2018

import java.io.FileReader
import java.util.*

abstract class Day<T>(private val day: Int, mapper: (String) -> T) {
    private val data: List<T> = Collections.unmodifiableList(FileReader("res/day$day.txt").readLines().map(mapper))

    abstract fun part1(data: List<T>): Any

    abstract fun part2(data: List<T>): Any

    fun run() {
        var start = System.nanoTime();
        val result1 = part1(data)
        val time1 = (System.nanoTime() - start) / 1000000.0
        println("Day $day part 1: $result1")
        println("Took $time1 ms")

        start = System.nanoTime();
        val result2 = part2(data)
        val time2 = (System.nanoTime() - start) / 1000000.0
        println("Day $day part 2: $result2")
        println("Took $time2 ms")
    }
}
