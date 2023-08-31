package com.example.wecod.constants

import com.example.wecod.model.CustomWeapon


val FAKE_CUSTOM_WEAPONS = listOf(
    CustomWeapon(1, "DLQ", 1, 2f, "https://i.ytimg.com/vi/xRp0l_qZi9Y/maxresdefault.jpg", "BR"),
    CustomWeapon(2, "AK47", 2, 3f, "https://i.ytimg.com/vi/uhRWkQG5Rhk/maxresdefault.jpg", "MJ"),
)

val FAKE_CUSTOM_WEAPON =
    CustomWeapon(1, "DLQ", 1, 3f, "https://i.ytimg.com/vi/xRp0l_qZi9Y/maxresdefault.jpg", "BR")

// retrofit
const val BASE_URL = "https://wecod-backend.onrender.com/api/v1/weapons/"
const val GET_ALL_CUSTOM_WEAPONS_URL = "customWeapons/"

const val MAX_RATE = 4