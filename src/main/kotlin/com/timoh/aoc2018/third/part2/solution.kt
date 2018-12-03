package com.timoh.aoc2018.third.part2

import java.io.File

fun main(args: Array<String>) {
    val resource = ClassLoader.getSystemClassLoader().getResource("input/input3")
    val size = 1000
    val fabric = Array(size) { IntArray(size) }
    var idSet = mutableSetOf<Int>()
    File(resource.toURI())
        .useLines { it.toList() }
        .forEach { line ->
            val splitLine = line.split(' ')
            val (startX, startY) = splitLine[2].substring(0, splitLine[2].length - 1).split(",").map { it.toInt() }
            val (width, height) = splitLine[3].split("x").map { it.toInt() }
            val id = splitLine[0].substring(1).toInt()
            idSet.add(id)
            for (x in startX until (startX + width)) {
                for (y in startY until (startY + height)) {
                    if (fabric[x][y] == 0) {
                        fabric[x][y] = id
                    } else {
                        idSet.remove(id)
                        idSet.remove(fabric[x][y])
                    }
                }
            }
        }

    println(idSet.toList()[0])
}