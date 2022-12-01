package com.tes.apps.development.orderingapp.core.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductEntity(
    @PrimaryKey val productId:String,
    val name:String,
    val pricePerAmount:Float,
    val belongsToDeliverer:String
)
