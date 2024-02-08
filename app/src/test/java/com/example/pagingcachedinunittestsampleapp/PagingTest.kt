package com.example.pagingcachedinunittestsampleapp

import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class PagingTest {
//    @get:Rule
//    val coroutineTestRule = CoroutineTestRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `paging cachedIn collect`() = runTest {
        val pagingData = PagingData.from(listOf(42))
        val testFlow = flow {
            emit(pagingData)
        }
        var invokeCount = 0

        val job = launch {
            testFlow.cachedIn(this).collect {
                invokeCount++
            }
        }

        advanceUntilIdle()

        job.cancel()

        assertEquals(1, invokeCount)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `paging cachedIn collect more advanced`() = runTest {
        var invokeCount = 0

        val vm = TestScopeViewModel(StandardTestDispatcher())

        val job = launch {
            vm.flow2.collect {
                invokeCount++
            }
        }

        advanceUntilIdle()

        job.cancel()

        assertEquals(1, invokeCount)
    }
}
