package com.example.wecod.api.dto

import com.example.wecod.model.Category

class WeaponDTO(
    val id: Int,
    val name: String,
    val category : Category,
    val img_url : String,
)