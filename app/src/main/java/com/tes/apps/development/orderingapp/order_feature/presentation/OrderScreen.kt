package com.tes.apps.development.orderingapp.order_feature.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.tes.apps.development.orderingapp.core.presentation.ScreenRoutes
import com.tes.apps.development.orderingapp.order_feature.presentation.components.OrderDetailDialog
import com.tes.apps.development.orderingapp.order_feature.presentation.components.OrderUiListItem
import com.tes.apps.development.orderingapp.ui.theme.gray
import com.tes.apps.development.orderingapp.ui.theme.orange
import com.tes.apps.development.orderingapp.ui.theme.white

@Composable
fun OrderScreen(
    navController: NavController,
    orderViewModel: OrderViewModel = hiltViewModel()
) {

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(ScreenRoutes.OrderChooseDelivererScreen.route)
                },
                backgroundColor = orange
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "fab_add_order",
                    tint = white
                )
            }
        },
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Order overview",
                        color = white
                    )
                },
                backgroundColor = orange
            )
        }
    ){
        if(orderViewModel.orderList.isEmpty()){
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Text("There are no orders yet")
            }
        }else{
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(gray)
                    .padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ){
                items(
                    orderViewModel.orderList,
                    key = {orderListItem ->
                        orderListItem.orderId
                    }
                ){
                    OrderUiListItem(
                        it,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .border(1.dp, color = white, RoundedCornerShape(10.dp))
                            .clickable {
                                orderViewModel.onOrderClick(it.orderId)
                            }
                            .padding(15.dp)
                    )
                }
            }
        }
    }

    if(orderViewModel.isOrderDialogShown && orderViewModel.clickedOrderItem != null){
        OrderDetailDialog(
            onDismiss = {
                orderViewModel.onDismissOrderDialog()
            },
            orderDetailListItem = orderViewModel.clickedOrderItem!!
        )
    }

}