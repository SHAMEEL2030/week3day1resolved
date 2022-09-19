package com.example.week3day11.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.week3day11.model.DataId
import com.example.week3day11.network.RetrofitInstance
import com.example.week3day11.network.RetrofitService
import retrofit2.Response

class DataViewModel:ViewModel() {
    var Datalist = MutableLiveData<List<DataId>>()
    fun GetApiData() {
        val retrofitService =
            RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)
        retrofitService.getData().enqueue(object : retrofit2.Callback<List<DataId>> {
            override fun onResponse(
                call: retrofit2.Call<List<DataId>>,
                response: Response<List<DataId>>
            ) {
                Datalist.value = response.body()
            }

            override fun onFailure(call: retrofit2.Call<List<DataId>>, t: Throwable) {

            }


        })

    }
}





