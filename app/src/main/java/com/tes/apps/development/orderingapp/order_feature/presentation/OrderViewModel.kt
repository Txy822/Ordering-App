package com.tes.apps.development.orderingapp.order_feature.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tes.apps.development.orderingapp.core.util.DummyData
import com.tes.apps.development.orderingapp.deliverer_feature.domain.repository.DelivererRepository
import com.tes.apps.development.orderingapp.order_feature.domain.model.Order
import com.tes.apps.development.orderingapp.order_feature.domain.repository.OrderRepository
import com.tes.apps.development.orderingapp.order_feature.presentation.mapper.toOrderDetailListItem
import com.tes.apps.development.orderingapp.order_feature.presentation.mapper.toOrderListItem
import com.tes.apps.development.orderingapp.order_feature.presentation.state.OrderDetailListItem
import com.tes.apps.development.orderingapp.order_feature.presentation.state.OrderListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import javax.xml.datatype.Duration

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val orderRepository: OrderRepository,
    //private val delivererRepository: DelivererRepository
): ViewModel(){

    private lateinit var orders:List<Order>

    var orderList by mutableStateOf<List<OrderListItem>>(emptyList())
        private set //set only here

    var isOrderDialogShown by mutableStateOf(false)
        private set

    var clickedOrderItem by mutableStateOf<OrderDetailListItem?>(null)
        private set

    init {
        viewModelScope.launch {
            orders=orderRepository.getOrders()
            setupOrderList()
           // delivererRepository.insertDeliverers(DummyData.deliverers)
        }
    }


    fun onOrderClick(orderId:String){
        initOrderForDialog(orderId)
        isOrderDialogShown = true
    }

    private fun initOrderForDialog(orderId: String){
        clickedOrderItem =
            orders.firstOrNull { it.orderId == orderId }?.toOrderDetailListItem()
    }

    fun onDismissOrderDialog(){
        isOrderDialogShown = false
        clickedOrderItem = null
    }

    private fun setupOrderList(){
        val formatter: DateTimeFormatter
                = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")

        orderList = orders.map { order ->
            order.toOrderListItem()
        }.sortedByDescending { orderListItem ->
            LocalDateTime.parse(orderListItem.orderDate,formatter)
        }
    }
}