package com.tes.apps.development.orderingapp.order_feature.data.mapper

import com.tes.apps.development.orderingapp.core.data.local.entities.OrderEntity
import com.tes.apps.development.orderingapp.order_feature.domain.model.Order

fun Order.toOrderEntity(delivererName:String): OrderEntity {
    return OrderEntity(
        orderId = orderId,
        date = date,
        delivererTime = delivererTime,
        delivererName = delivererName
    )
}