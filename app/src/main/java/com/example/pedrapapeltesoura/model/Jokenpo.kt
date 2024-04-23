package com.example.pedrapapeltesoura.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Jokenpo(
    var pedra: String = "",
    var papel: String = "",
    var tesoura: String ="",

): Parcelable
