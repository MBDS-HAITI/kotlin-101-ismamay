package com.kotlin.one.character

import com.kotlin.one.combat.Attacker
import com.kotlin.one.combat.Healer
import com.kotlin.one.combat.Weapon

class Magus(name: String) :
    Character(
        name = name,
        initialHealth = 120,
        weapon = Weapon("Magic Staff", 10)
    ),
    Attacker,
    Healer {

    override fun action(target: Character) {
        attack(target)
    }

    override fun attack(target: Character) {
        if (!isAlive) return

        target.takeDamage(weapon.power)
        println("$name casts a spell on ${target.name} for ${weapon.power} damage.")
    }

    override fun heal(target: Character) {
        if (!isAlive) return

        val healAmount = 15
        target.restoreHealth(healAmount)

        println("$name heals ${target.name} for $healAmount HP.")
    }
}