package com.kotlin.one.character

import com.kotlin.one.combat.Weapon

abstract class Character(
    val name: String,
    initialHealth: Int,
    val weapon: Weapon
) {
    var health: Int = initialHealth
        private  set

    val maxHealth: Int = initialHealth

    val isAlive: Boolean
        get() = health > 0

    fun takeDamage(damage: Int) {
        health -= damage
        if (health < 0) {
            health = 0
        }
    }

    fun restoreHealth(amount: Int) {
        health += amount
        if(health>maxHealth) {
            health = maxHealth
        }
    }

    abstract fun action(target: Character)
}