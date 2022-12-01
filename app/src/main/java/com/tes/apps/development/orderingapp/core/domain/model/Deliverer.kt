package com.tes.apps.development.orderingapp.core.domain.model


data class Deliverer(
    val delivererId:String,
    val name:String,
    val products:List<Product>
)
