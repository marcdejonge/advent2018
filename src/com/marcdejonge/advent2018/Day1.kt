package com.marcdejonge.advent2018

import java.util.*

class Day1 : Day<Int>(1, Integer::valueOf) {

    override fun part1(data: List<Int>): Int {
        return data.fold(0) { a, b -> a + b }
    }

    override fun part2(data: List<Int>): Int {
        val foundNumbers = HashSet<Int>()

        var freq = 0;
        while (true) {
            for (nr in data) {
                freq += nr;
                if (foundNumbers.contains(freq)) {
                    return freq;
                } else {
                    foundNumbers.add(freq);
                }
            }
        }
    }
}
