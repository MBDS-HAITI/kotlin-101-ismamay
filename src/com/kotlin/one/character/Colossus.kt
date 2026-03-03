package com.kotlin.one.character

import com.kotlin.one.combat.Attacker
import com.kotlin.one.combat.Weapon

class Colossus(name: String) :
    Character(
        name = name,
        health = 150,
        weapon = Weapon("Heavy Hammer", 15)
    ),
    Attacker {

    override fun action(target: Character) {
        attack(target)
    }

    override fun attack(target: Character) {
        if (!isAlive) return

        target.takeDamage(weapon.power)

        println("$name smashes ${target.name} for ${weapon.power} damage.")
    }
}