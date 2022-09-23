package com.example.week3day11.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.example.week3day11.model.DataId
import com.example.week3day11.repository.Repository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test


internal class Repository {
    lateinit var model: DataViewModel

    @MockK
    lateinit var homeActivityRepository: Repository

    @get:Rule
    val rule =  InstantTaskExecutorRule()



    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)

        model = DataViewModel()
        model.setRepository(homeActivityRepository)
    }

    @Test
    fun `test API call`() {
        every { homeActivityRepository.getApiData() } returns MutableLiveData<List<DataId>>().apply {
            postValue(
                listOf(
                    (DataId("1", "1","delectusautautem",false)
                    ))
                )

        }
        model.getApiData()
        Assert.assertNotEquals(
            model.datalist?.value, listOf(
                DataId("1", "1","delectusautautem",false)

            )
        )
    }



    }

