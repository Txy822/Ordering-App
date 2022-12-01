package com.tes.apps.development.orderingapp.deliverer_feature.data.mapper

import com.tes.apps.development.orderingapp.core.data.local.entities.ProductEntity
import com.tes.apps.development.orderingapp.core.domain.model.Product


fun Product.toProductEntity(delivererId:String): ProductEntity {
    return ProductEntity(
        productId = productId,
        name = name,
        pricePerAmount = pricePerAmount,
        belongsToDeliverer = delivererId
    )
}