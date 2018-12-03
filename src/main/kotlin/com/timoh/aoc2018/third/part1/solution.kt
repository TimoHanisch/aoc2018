package com.timoh.aoc2018.third.part1

import java.io.File

fun main(args: Array<String>) {
    val resource = ClassLoader.getSystemClassLoader().getResource("input/input3")
    val size = 1000
    val fabric = Array(size) { IntArray(size) }
    var doubleAssigned = 0
    File(resource.toURI())
        .useLines { it.toList() }
        .forEach { line ->
            val splitLine = line.split(' ')
            val (startX, startY) = splitLine[2].substring(0, splitLine[2].length - 1).split(",").map { it.toInt() }
            val (width, height) = splitLine[3].split("x").map { it.toInt() }
            for (x in startX until (startX + width)) {
                for (y in startY until (startY + height)) {
                    if (fabric[x][y] == 0) {
                        fabric[x][y] = splitLine[0].substring(1).toInt()
                    } else if (fabric[x][y] != -1) {
                        fabric[x][y] = -1
                        doubleAssigned += 1
                    }
                }
            }
        }

    println(doubleAssigned)
}