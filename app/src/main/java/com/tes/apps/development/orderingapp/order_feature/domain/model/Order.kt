package com.tes.apps.development.orderingapp.order_feature.domain.model



data class Order(
    val orderId:String,
    val date:String,
    val delivererTime:String,
    val delivererName:String,
    val products:List<BoughtProduct>
)
