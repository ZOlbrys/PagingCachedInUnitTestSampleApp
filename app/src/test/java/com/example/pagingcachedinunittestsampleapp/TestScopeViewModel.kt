package com.example.pagingcachedinunittestsampleapp

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow

class TestScopeViewModel(
    val customDispatcher: CoroutineDispatcher,
    customScope: CloseableCoroutineScope = CloseableCoroutineScope(customDispatcher)
) : ViewModel(customScope) {
    val flow1 = flow {
        emit(PagingData.from(listOf(42)))
    }
    val flow2 = flow1.cachedIn(customScope)
}
