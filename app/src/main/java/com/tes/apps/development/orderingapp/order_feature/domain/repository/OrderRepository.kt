package com.tes.apps.development.orderingapp.order_feature.domain.repository

import com.tes.apps.development.orderingapp.core.domain.model.Deliverer
import com.tes.apps.development.orderingapp.core.domain.model.Product
import com.tes.apps.development.orderingapp.order_feature.domain.model.Order

interface OrderRepository {

    suspend fun insertOrder(order: Order)

    suspend fun getOrders():List<Order>

    suspend fun getDeliverers():List<Deliverer>

    suspend fun getProductsForDeliverer(delivererId:String):List<Product>

    suspend fun getDelivererNameById(delivererId: String):String
}