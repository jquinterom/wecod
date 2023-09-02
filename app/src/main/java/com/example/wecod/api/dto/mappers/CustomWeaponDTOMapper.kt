package com.example.wecod.api.dto.mappers

import com.example.wecod.api.dto.CustomWeaponDTO
import com.example.wecod.model.CustomWeapon

class CustomWeaponDTOMapper {
    fun fromCustomWeaponDTOToCustomWeaponDomain(customWeaponDTO: CustomWeaponDTO): CustomWeapon {
        return CustomWeapon(
            id = customWeaponDTO.id,
            name = customWeaponDTO.name,
            category = customWeaponDTO.category,
            rate = customWeaponDTO.rate,
            imgUrl = customWeaponDTO.img_url,
            gameMode = customWeaponDTO.game_mode
        )
    }

    fun fromCustomWeaponDTOListToCustomWeaponDomainList(customWeaponDTOList: List<CustomWeaponDTO>): List<CustomWeapon> {

        return customWeaponDTOList.map {
            fromCustomWeaponDTOToCustomWeaponDomain(it)
        }
    }
}