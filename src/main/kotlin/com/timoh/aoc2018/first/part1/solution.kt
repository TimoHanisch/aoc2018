package com.timoh.aoc2018.first.part1

import java.io.File

fun main(args: Array<String>) {
    val resource = ClassLoader.getSystemClassLoader().getResource("input/input1")
    val value = File(resource.toURI())
        .useLines { it.toList() }
        .fold(0L) { acc, line -> acc + line.toLong() }

    println(value)
}