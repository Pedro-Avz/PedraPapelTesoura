package com.example.pedrapapeltesoura.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Jokenpo(
    val maos: List<String> = listOf("pedra", "papel", "tesoura", "lagarto", "spock")
): Parcelable
