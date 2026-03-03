package com.android.com.kotlin.one


//exo 1
fun ex1(): List<Int> {
    return listOf(1, 2, 3, 4, 5)
}

//exo 2
fun ex2(): MutableList<String> {
    val list = mutableListOf("Apple", "Banana", "Cherry")
    list.add("Orange")
    return list
}

//exo 3
fun ex3(): List<Int> {
    return (1..10)
        .filter { it % 2 == 0 }
}

//exo 4

fun ex4(): List<String> {
    val ages = listOf(15, 18, 22, 30, 12, 40)

    return ages
        .filter { it >= 18 }
        .map { "Adult: $it" }
}

//exo 5
fun ex5(): List<Int> {
    val nested = listOf(
        listOf(1, 2),
        listOf(3, 4),
        listOf(5)
    )

    return nested.flatten()
}

//exo 6

fun ex6(): List<String> {
    val phrases = listOf("Kotlin is fun", "I love lists")

    return phrases.flatMap { phrase ->
        phrase.split(" ")
    }
}

//exo 7

fun ex7(): List<Int> {
    val start = System.currentTimeMillis()

    val result = (1..1_000_000)
        .filter { it % 3 == 0 }
        .map { it * it }
        .take(5)

    val end = System.currentTimeMillis()
    println("Time: ${end - start} ms")

    return result
}

//exo 8

fun ex8(): List<Int> {
    val start = System.currentTimeMillis()

    val result = (1..1_000_000)
        .asSequence()
        .filter { it % 3 == 0 }
        .map { it * it }
        .take(5)
        .toList()

    val end = System.currentTimeMillis()
    println("Time: ${end - start} ms")

    return result
}
// exo 9

fun ex9(): List<String> {
    val names = listOf("Alice", "Bob", "Anna", "David", "alex", "Amanda")

    return names
        .filter { it.startsWith("A") }
        .map { it.uppercase() }
        .sorted()
}





fun main() {
    println("Ex1: ${ex1()}")
    println("Ex2: ${ex2()}")
    println("Ex3: ${ex3()}")
    println("Ex4: ${ex4()}")
    println("Ex5: ${ex5()}")
    println("Ex6: ${ex6()}")

    println("Ex7 (Eager): ${ex7()}")
    println("Ex8 (Lazy): ${ex8()}")

    println("Ex9: ${ex9()}")

}