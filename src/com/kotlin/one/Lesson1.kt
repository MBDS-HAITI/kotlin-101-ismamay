package com.android.com.kotlin.one

import java.lang.IO.println

fun main() {

    println("👋 Welcome to the Kotlin Playground!")
    println("Let's start learning step by step.\n")


    // ✅ EXERCISE 1 Variables:
    // Create two variables: `city` (String) and `temperature` (Double)
    // Then print: "It is {temperature}°C in {city}"
    // Enforce `city` to be immutable and `temperature` mutable
    // Then print the sentence again after changing `temperature`

    val city: String = "Paris"
    var temperature: Double = 22.5

    println("il fait $temperature degre C a $city")


    temperature = 25.0

    println("il fait $temperature degre C a $city")

//    TODO(
//        "Exercise 1 Variables implementation"
//    )


    // ✅ EXERCISE 2 Conditionals:
    // Create a variable `score` (Int)
    // Handle the following cases:
    // - If score is exactly 100, print "Perfect score!"
    // - If score is below 0 or above 100, print "Invalid score"
    // - If score between 0 and 49, print "You failed!"
    // - If score between 50 and 60, print "Just passed!"
    // - If score between 61 and 99, print "Well done!"

    val score: Int = 75   // Change la valeur pour tester

    when {
        score == 100 -> println("Perfect score!")
        score < 0 || score > 100 -> println("Invalid score")
        score in 0..49 -> println("You failed!")
        score in 50..60 -> println("Just passed!")
        score in 61..99 -> println("Well done!")
    }

    // ✅ EXERCISE 3 list and Loops:
    // Create a list of your favorite fruits
    // Loop through the list and print each fruit in uppercase
    // Then, print the total number of fruits in the list
    // Ask the user to enter a fruit name and check if it's in the list

    val fruits = listOf("apple", "banana", "mango", "orange")


    println("Fruits in uppercase:")
    for (fruit in fruits) {
        println(fruit.uppercase())
    }

    // Print total number of fruits
    println("\nTotal number of fruits: ${fruits.size}")

    // Ask user to enter a fruit
    print("\nEnter a fruit name: ")
    val userInput = readLine()?.lowercase()

    // Check if fruit exists in list
    if (userInput != null && userInput in fruits) {
        println("Yes, $userInput is in the list!")
    } else {
        println("Sorry, that fruit is not in the list.")
    }

    // ✅EXERCISE 4 Elvis Operator:
    // Create a nullable variable `nickname` of type String? and assign it null
    // Print the number of characters in `nickname`
    // Print the nickname or "No nickname provided" if it's null using the Elvis operator

    val nickname: String? = null

    // Print number of characters
    val length = nickname?.length ?: 0
    println("Number of characters: $length")


    val displayName = nickname ?: "No nickname provided"
    println(displayName)

}

