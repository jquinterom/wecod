package com.example.wecod.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class CustomWeapon(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val category: Int,
    val rate: Float,
    val imgUrl: String,
    val gameMode: String,
) : Parcelable, Comparable<CustomWeapon> {
    override fun compareTo(other: CustomWeapon): Int =
        if (this.id > other.id) {
            1
        } else {
            -1
        }

}