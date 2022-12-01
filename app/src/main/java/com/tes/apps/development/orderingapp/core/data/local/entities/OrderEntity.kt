package com.tes.apps.development.orderingapp.core.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class OrderEntity(
    @PrimaryKey val orderId:String,
    val date:String,
    val delivererTime:String,
    val delivererName:String
)
