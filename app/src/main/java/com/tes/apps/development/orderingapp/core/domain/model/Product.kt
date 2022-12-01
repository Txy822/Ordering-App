package com.tes.apps.development.orderingapp.core.domain.model

import com.tes.apps.development.orderingapp.core.domain.SelectAndSortableByName


data class Product(
    val productId:String,
    override val name:String,
    val pricePerAmount:Float
): SelectAndSortableByName
