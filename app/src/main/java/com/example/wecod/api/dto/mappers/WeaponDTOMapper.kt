package com.example.wecod.api.dto.mappers

import com.example.wecod.api.dto.CustomWeaponDTO
import com.example.wecod.api.dto.WeaponDTO
import com.example.wecod.model.CustomWeapon
import com.example.wecod.model.Weapon

class WeaponDTOMapper {
    fun fromWeaponDTOToWeaponDomain(weaponDTO: WeaponDTO): Weapon {
        return Weapon(
            id = weaponDTO.id,
            name = weaponDTO.name,
            category = weaponDTO.category,
            imgUrl = weaponDTO.img_url,
        )
    }

    fun fromCustomWeaponDTOListToCustomWeaponDomainList(weaponDTOList: List<WeaponDTO>): List<Weapon> {
        return weaponDTOList.map {
            fromWeaponDTOToWeaponDomain(it)
        }
    }
}