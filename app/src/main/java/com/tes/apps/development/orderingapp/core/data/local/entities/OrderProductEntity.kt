package com.tes.apps.development.orderingapp.core.data.local.entities

import androidx.room.Entity

@Entity(primaryKeys = ["orderId","productId"])
data class OrderProductEntity(
    val orderId:String,
    val productId:String,
    val amount:Int
)