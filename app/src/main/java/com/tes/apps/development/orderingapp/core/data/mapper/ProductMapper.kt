package com.tes.apps.development.orderingapp.core.data.mapper

import com.tes.apps.development.orderingapp.core.data.local.entities.ProductEntity
import com.tes.apps.development.orderingapp.core.domain.Product

fun ProductEntity.toProduct(): Product {
    return Product(
        productId = productId,
        name = name,
        pricePerAmount = pricePerAmount
    )
}