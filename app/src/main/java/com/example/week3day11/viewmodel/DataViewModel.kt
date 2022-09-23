package com.example.week3day11.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.week3day11.model.DataId
import com.example.week3day11.repository.Repository

class DataViewModel:ViewModel() {
    var datalist : MutableLiveData<List<DataId>>? = null
    private var repository  : Repository? = null
    fun setRepository(repository:Repository){
        this.repository=repository
    }
    fun getApiData():LiveData<List<DataId>>{
        datalist = Repository.getApiData()
        return datalist as MutableLiveData<List<DataId>>
    }
    fun getFailure(): LiveData<String>?{
        return repository?.failureData

    }
}






