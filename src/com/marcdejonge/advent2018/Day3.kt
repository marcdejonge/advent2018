package com.marcdejonge.advent2018

import java.util.concurrent.atomic.AtomicInteger

class Day3 : Day<Day3.Rect>(3, {
    Day3.Rect(Regex("#([0-9]+) @ ([0-9]+),([0-9]+): ([0-9]+)x([0-9]+)").matchEntire(it)
            ?: throw IllegalArgumentException("Line does not match expected format"))
}) {
    class Rect(val id: Int, val x: Int, val y: Int, val width: Int, val height: Int, val counters: MutableList<AtomicInteger>) {
        constructor(match: MatchResult) : this(
                match.groups[1]?.value?.toInt() ?: 0,
                match.groups[2]?.value?.toInt() ?: 0,
                match.groups[3]?.value?.toInt() ?: 0,
                match.groups[4]?.value?.toInt() ?: 0,
                match.groups[5]?.value?.toInt() ?: 0,
                ArrayList<AtomicInteger>())
    }

    private val counters = HashMap<Int, AtomicInteger>()

    override fun prepare(data: List<Rect>) {
        for (rect in data) {
            for (x in rect.x until (rect.x + rect.width)) {
                for (y in rect.y until (rect.y + rect.height)) {
                    val counter = counters.computeIfAbsent(x + 100_000 * y) { AtomicInteger() }
                    counter.incrementAndGet()
                    rect.counters.add(counter)
                }
            }
        }
    }

    override fun part1(data: List<Rect>) = counters.values.filter { it.get() > 1 }.count()
    override fun part2(data: List<Rect>) = data.first { it.counters.all { nr -> nr.get() == 1 } }.id
}
