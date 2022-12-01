package com.tes.apps.development.orderingapp.core.domain.model

import com.tes.apps.development.orderingapp.core.domain.SelectAndSortableByName


data class Deliverer(
    val delivererId:String,
    override val name:String,
    val products:List<Product>
): SelectAndSortableByName
