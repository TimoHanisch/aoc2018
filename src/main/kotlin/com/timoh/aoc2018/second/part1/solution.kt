package com.timoh.aoc2018.second.part1

import java.io.File

fun main(args: Array<String>) {
    val resource = ClassLoader.getSystemClassLoader().getResource("input/input2")
    val value = File(resource.toURI())
        .useLines { it.toList() }
        .map {
            it.toList().fold(HashMap<Char, Int>()) { acc, c ->
                val count = acc[c]
                if (count != null) {
                    acc[c] = count + 1
                } else {
                    acc[c] = 1
                }
                acc
            }
        }.fold(Pair(0L, 0L)) { acc, map ->
            val pair = map.values.filter { it >= 2 }.distinct().fold(Pair(0L, 0L)) { acc, count ->
                Pair(if (count == 2) 1L else acc.first, if (count == 3) 1L else acc.second)
            }
            Pair(acc.first + pair.first, acc.second + pair.second)
        }

    println(value.first * value.second)
}