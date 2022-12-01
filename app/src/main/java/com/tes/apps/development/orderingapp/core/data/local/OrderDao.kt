package com.tes.apps.development.orderingapp.core.data.local

import androidx.room.*
import com.tes.apps.development.orderingapp.core.data.local.entities.OrderEntity
import com.tes.apps.development.orderingapp.core.data.local.entities.OrderProductEntity
import com.tes.apps.development.orderingapp.core.data.local.entities.OrderWithProductsDataObject

@Dao
interface OrderDao {
    @Transaction
    @Query("SELECT * FROM OrderEntity")
    suspend fun getOrderWithProducts():List<OrderWithProductsDataObject>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrder(orderEntity: OrderEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrderProductEntities(orderProductEntities:List<OrderProductEntity>)

}