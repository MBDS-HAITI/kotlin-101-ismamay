package com.kotlin.one.combat

import com.kotlin.one.character.Character
interface Attacker {
    fun attack(target: Character)
}