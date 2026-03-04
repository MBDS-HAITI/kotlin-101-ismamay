package com.kotlin.one.character

import com.kotlin.one.combat.Attacker
import com.kotlin.one.combat.Weapon

class Dwarf(name: String) :
    Character(
        name = name,
        initialHealth = 80,
        weapon = Weapon("Battle Axe", 30)
    ),
    Attacker {

    override fun action(target: Character) {
        attack(target)
    }

    override fun attack(target: Character) {
        if (!isAlive) return

        target.takeDamage(weapon.power)

        println("$name strikes ${target.name} with brutal force for ${weapon.power} damage.")
    }
}