package com.example.week3day11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week3day11.adapter.IdAdapter
import com.example.week3day11.model.DataId
import com.example.week3day11.viewmodel.DataViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var dataViewModel:DataViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initIdApi()
    }
    private fun initIdApi() {
        dataViewModel = ViewModelProvider(this).get(DataViewModel::class.java)
        dataViewModel.GetApiData()
        dataViewModel.Datalist.observe(this, Observer {
        initAdapter(it)
        })
    }

         private fun initAdapter(data:List<DataId>){
            dataid.layoutManager = LinearLayoutManager(this)
            val adapter = IdAdapter(data)
            dataid.adapter = adapter

        }
    }
