package com.example.wecod.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Weapon(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val category: Category,
    val imgUrl: String,

): Parcelable, Comparable<Weapon> {
    override fun compareTo(other: Weapon): Int =
        if (this.id > other.id) {
            1
        } else {
            -1
        }
}
