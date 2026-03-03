package com.kotlin.one.character

import com.kotlin.one.combat.Attacker
import com.kotlin.one.combat.Weapon

class Warrior(name: String) :
    Character(
        name = name,
        health = 100,
        weapon = Weapon("Sword", 20)
    ),
    Attacker {

    override fun action(target: Character) {
        attack(target)
    }

    override fun attack(target: Character) {
        if (!isAlive) return

        target.takeDamage(weapon.power)

        println("$name attacks ${target.name} for ${weapon.power} damage.")
    }
}