package com.example.challengechapter3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataMain(
    val gaji: Int,
    val iuranBulanan: Int,
    val belanja: Int):
    Parcelable {
}