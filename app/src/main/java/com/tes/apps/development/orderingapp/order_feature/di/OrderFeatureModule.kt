package com.tes.apps.development.orderingapp.order_feature.di

import com.tes.apps.development.orderingapp.core.data.local.DelivererDao
import com.tes.apps.development.orderingapp.core.data.local.OrderDao
import com.tes.apps.development.orderingapp.core.data.local.ProductDao
import com.tes.apps.development.orderingapp.order_feature.data.repository.OrderRepositoryImpl
import com.tes.apps.development.orderingapp.order_feature.domain.repository.OrderRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OrderFeatureModule {

    @Provides
    @Singleton
    fun provideOrderRepository(
        orderDao: OrderDao,
        delivererDao: DelivererDao,
        productDao: ProductDao
    ): OrderRepository {
        return OrderRepositoryImpl(orderDao,delivererDao,productDao)
    }

}