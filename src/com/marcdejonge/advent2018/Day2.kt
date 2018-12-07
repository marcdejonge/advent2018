package com.marcdejonge.advent2018

class Day2 : Day<CharArray>(2, String::toCharArray) {
    override fun part1(data: List<CharArray>): Int {
        var twice = 0
        var trice = 0

        data.forEach {
            val freq = it.toList().frequency()

            if (freq.values.contains(2))
                twice++
            if (freq.values.contains(3))
                trice++
        }

        return twice * trice
    }

    override fun part2(data: List<CharArray>): String {
        for (i in 0 until data.size) {
            for (j in i + 1 until data.size) {
                val result = data[i].zip(data[j]) { a, b -> if (a == b) a else '_' }

                if (result.count{ it == '_' } == 1) {
                    return String(result.filter { it != '_' }.toCharArray())
                }
            }
        }

        throw IllegalStateException("Could not find match")
    }
}