package com.kotlin.one.character

import com.kotlin.one.combat.Weapon
abstract class Character(
    val name: String,
    var health: Int,
    val weapon: Weapon
) {

    val isAlive: Boolean
        get() = health > 0

    fun takeDamage(damage: Int) {
        health -= damage
        if (health < 0) {
            health = 0
        }
    }

    abstract fun action(target: Character)
}