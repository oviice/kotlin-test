package com.cel.kotlintest.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cel.kotlintest.MyViewModel
import com.cel.kotlintest.R
import com.cel.kotlintest.adapters.ListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListActivity : AppCompatActivity() {
    private val myViewModel: MyViewModel by viewModels()
    lateinit var listAdapter:ListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        var list:RecyclerView =findViewById(R.id.list)
        list.layoutManager=LinearLayoutManager(this)
        myViewModel.getUserList()
        myViewModel.userListLiveData.observe(this) {
            listAdapter = ListAdapter(this, it)
            list.adapter = listAdapter
            Log.d("TAG", "onCreate: ${it.get(2).organizationsUrl}")
        }
    }
}