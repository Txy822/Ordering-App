package com.tes.apps.development.orderingapp.order_feature.presentation.mapper

import com.tes.apps.development.orderingapp.core.domain.model.Deliverer
import com.tes.apps.development.orderingapp.order_feature.presentation.state.DelivererListItem

fun Deliverer.toDelivererListItem(): DelivererListItem {
    return DelivererListItem(
        delivererId = delivererId,
        name = name
    )
}