package com.tes.apps.development.orderingapp.deliverer_feature.domain.repository


import com.tes.apps.development.orderingapp.core.domain.model.Deliverer
import com.tes.apps.development.orderingapp.core.domain.model.Product


interface DelivererRepository {

    suspend fun insertDeliverers(list:List<Deliverer>)

    suspend fun insertProducts(list:List<Product>, delivererId:String)

}