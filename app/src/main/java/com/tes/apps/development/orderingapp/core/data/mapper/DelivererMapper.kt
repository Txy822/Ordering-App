package com.tes.apps.development.orderingapp.core.data.mapper

import com.tes.apps.development.orderingapp.core.data.local.entities.DelivererEntity
import com.tes.apps.development.orderingapp.core.domain.model.Deliverer
import com.tes.apps.development.orderingapp.core.domain.model.Product

fun DelivererEntity.toDeliver(products:List<Product>): Deliverer {
    return Deliverer(
        delivererId = delivererId,
        name = name,
        products = products
    )
}