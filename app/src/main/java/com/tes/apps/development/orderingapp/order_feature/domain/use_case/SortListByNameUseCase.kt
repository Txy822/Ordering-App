package com.tes.apps.development.orderingapp.order_feature.domain.use_case

import com.tes.apps.development.orderingapp.core.domain.SelectAndSortableByName


class SortListByNameUseCase {

    operator fun <T> invoke(list:List<T>):List<T> where T: SelectAndSortableByName {
        return list.sortedBy { item ->
            item.name
        }
    }

}