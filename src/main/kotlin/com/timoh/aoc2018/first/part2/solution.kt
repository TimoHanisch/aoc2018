package com.timoh.aoc2018.first.part2

import java.io.File

fun main(args: Array<String>) {
    val resource = ClassLoader.getSystemClassLoader().getResource("input/input1")
    val lines = File(resource.toURI())
        .useLines { it.toList() }
    val map = HashMap<Long, Int>()
    var pair = Pair(0L, map)
    while (map.size % lines.size == 0) {
        pair = run breaker@{
            lines
                .fold(pair) { acc, line ->
                    val freq = acc.first + line.toLong()
                    if (acc.second[freq] != null) {
                        return@breaker Pair(freq, acc.second)
                    }
                    acc.second[freq] = 1
                    Pair(freq, acc.second)
                }
        }
    }
    println(pair.first)
}