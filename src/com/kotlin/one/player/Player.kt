package com.kotlin.one.player

import com.kotlin.one.character.Character

class Player(
    val name: String
) {

    val team = mutableListOf<Character>()

    fun hasLivingCharacters(): Boolean {
        return team.any { it.isAlive }
    }

    fun getLivingCharacters(): List<Character> {
        return team.filter { it.isAlive }
    }

    fun showTeamStatus() {
        println("---- $name team status ----")
        for (character in team) {
            val status = if (character.isAlive) "Alive" else "Dead"
            println("${character.name} - HP: ${character.health} - $status")
        }
        println("---------------------------")
    }
}