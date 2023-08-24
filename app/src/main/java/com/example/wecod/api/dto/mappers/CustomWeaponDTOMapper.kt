package com.example.wecod.api.dto.mappers

import com.example.wecod.api.dto.WeaponDTO
import com.example.wecod.model.CustomWeapon

class CustomWeaponDTOMapper {
    fun fromCustomWeaponDTOToCustomWeaponDomain(weaponDTO: WeaponDTO): CustomWeapon {
        return CustomWeapon(
            id = weaponDTO.id,
            name = weaponDTO.name,
            category = weaponDTO.category,
            rate = weaponDTO.rate,
            imgUrl = weaponDTO.img_url,
            gameMode = weaponDTO.game_mode
        )
    }

    fun fromCustomWeaponDTOListToCustomWeaponDomainList(weaponDTOList: List<WeaponDTO>): List<CustomWeapon> {

        return weaponDTOList.map {
            fromCustomWeaponDTOToCustomWeaponDomain(it)
        }
    }
}