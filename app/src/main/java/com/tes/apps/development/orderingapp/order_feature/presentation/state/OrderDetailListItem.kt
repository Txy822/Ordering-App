package com.tes.apps.development.orderingapp.order_feature.presentation.state

data class OrderDetailListItem(
    val orderId:String,
    val delivererName:String,
    val orderDate:String,
    val products:List<ProductListItem>
)
