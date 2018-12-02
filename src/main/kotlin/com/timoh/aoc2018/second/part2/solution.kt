package com.timoh.aoc2018.second.part2

import java.io.File

fun main(args: Array<String>) {
    val resource = ClassLoader.getSystemClassLoader().getResource("input/input2")
    val ids = File(resource.toURI())
        .useLines { it.toList() }
    var id = ""
    var intersect = ""
    for (i in 0 until ids.size) {
        for (j in 0 until ids.size) {
            if (i != j) {
                for (k in 0 until ids[i].length) {
                    if (ids[i][k] == ids[j][k]) {
                        intersect += ids[i][k]
                    }
                }
                if (intersect.length > id.length) {
                    id = intersect
                }
                intersect = ""
            }
        }
    }

    println(id)
}