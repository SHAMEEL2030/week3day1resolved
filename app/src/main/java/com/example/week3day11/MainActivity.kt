package com.example.week3day11

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week3day11.adapter.IdAdapter
import com.example.week3day11.model.DataId
import com.example.week3day11.viewmodel.DataViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var dataViewModel:DataViewModel
    private lateinit var dataid:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataid=findViewById(R.id.dataid)
        initIdApi()

    }
    private fun initIdApi() {
        dataViewModel = ViewModelProvider(this)[DataViewModel::class.java]
        dataViewModel.getApiData()
        dataViewModel.datalist?.observe(this) {
            initAdapter(it)
        }
    }

         private fun initAdapter(data:List<DataId>){
            dataid.layoutManager = LinearLayoutManager(this)
            val adapter = IdAdapter(data)
            dataid.adapter = adapter

        }
    }
