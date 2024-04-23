package com.example.pedrapapeltesoura.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Jokenpo(
    var stone: String = "",
    var paper: String = "",
    var scizor: String ="",

): Parcelable
