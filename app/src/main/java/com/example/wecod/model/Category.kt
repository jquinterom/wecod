package com.example.wecod.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Category(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
) : Parcelable, Comparable<Category> {
    override fun compareTo(other: Category): Int =
        if (this.id > other.id) {
            1
        } else {
            -1
        }
}