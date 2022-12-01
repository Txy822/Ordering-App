package com.tes.apps.development.orderingapp.deliverer_feature.data.mapper

import com.tes.apps.development.orderingapp.core.data.local.entities.DelivererEntity
import com.tes.apps.development.orderingapp.core.domain.model.Deliverer

fun Deliverer.toDelivererEntity(): DelivererEntity {
    return DelivererEntity(
        delivererId = delivererId,
        name = name
    )
}