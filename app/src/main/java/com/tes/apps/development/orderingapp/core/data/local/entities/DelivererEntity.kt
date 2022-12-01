package com.tes.apps.development.orderingapp.core.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DelivererEntity(
    @PrimaryKey val delivererId:String,
    val name:String
)
