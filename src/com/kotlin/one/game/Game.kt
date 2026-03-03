package com.kotlin.one.game

import com.kotlin.one.player.Player
import com.kotlin.one.character.*
import com.kotlin.one.combat.Healer

class Game {

    private lateinit var player1: Player
    private lateinit var player2: Player
    private var roundCount = 0

    fun start() {
        println("=== Welcome to Battle Arena ===")

        createPlayers()
        createTeams()

        battleLoop()

        showResults()
    }

    // -------------------------
    // PLAYER CREATION
    // -------------------------

    private fun createPlayers() {
        println("Enter name for Player 1:")
        val name1 = readln()

        println("Enter name for Player 2:")
        val name2 = readln()

        player1 = Player(name1)
        player2 = Player(name2)
    }

    // -------------------------
    // TEAM CREATION
    // -------------------------

    private fun createTeams() {
        println("\n=== Team Creation ===")
        createTeamFor(player1)
        createTeamFor(player2)
    }

    private fun createTeamFor(player: Player) {
        println("\n${player.name}, create your team!")

        val usedTypes = mutableSetOf<String>()

        while (player.team.size < 3) {

            println("\nChoose character type:")
            println("1 - Warrior")
            println("2 - Magus")
            println("3 - Colossus")
            println("4 - Dwarf")

            val choice = readln()

            val typeName = when (choice) {
                "1" -> "Warrior"
                "2" -> "Magus"
                "3" -> "Colossus"
                "4" -> "Dwarf"
                else -> {
                    println("Invalid choice.")
                    continue
                }
            }

            if (typeName in usedTypes) {
                println("You already chose this type.")
                continue
            }

            println("Enter character name:")
            val characterName = readln()

            val character = when (typeName) {
                "Warrior" -> Warrior(characterName)
                "Magus" -> Magus(characterName)
                "Colossus" -> Colossus(characterName)
                else -> Dwarf(characterName)
            }

            player.team.add(character)
            usedTypes.add(typeName)

            println("$characterName the $typeName added to team.")
        }
    }

    // -------------------------
    // BATTLE LOOP
    // -------------------------

    private fun battleLoop() {
        while (player1.hasLivingCharacters() && player2.hasLivingCharacters()) {
            roundCount++
            println("\n=== Round $roundCount ===")

            playTurn(player1, player2)
            if (!player2.hasLivingCharacters()) break

            playTurn(player2, player1)
        }
    }

    private fun playTurn(attacker: Player, defender: Player) {

        println("\n${attacker.name}'s turn")

        val attackingCharacter = chooseCharacter(attacker)

        if (!attackingCharacter.isAlive) {
            println("This character is dead.")
            return
        }

        // If character can heal
        if (attackingCharacter is Healer) {
            println("Choose action:")
            println("1 - Attack")
            println("2 - Heal")

            when (readln()) {
                "2" -> {
                    val target = chooseCharacter(attacker)
                    attackingCharacter.heal(target)
                    return
                }
            }
        }

        // Default = attack
        val target = chooseCharacter(defender)
        attackingCharacter.action(target)
    }

    private fun chooseCharacter(player: Player): Character {
        val livingCharacters = player.getLivingCharacters()

        println("Choose a character:")

        livingCharacters.forEachIndexed { index, character ->
            println("${index + 1} - ${character.name} (HP: ${character.health})")
        }

        while (true) {
            val input = readln()
            val index = input.toIntOrNull()?.minus(1)

            if (index != null && index in livingCharacters.indices) {
                return livingCharacters[index]
            }

            println("Invalid selection. Try again.")
        }
    }

    // -------------------------
    // END GAME
    // -------------------------

    private fun showResults() {
        println("\n=== Game Over ===")
        println("Total rounds: $roundCount")

        val winner =
            if (player1.hasLivingCharacters()) player1.name
            else player2.name

        println("Winner: $winner")

        player1.showTeamStatus()
        player2.showTeamStatus()
    }
}