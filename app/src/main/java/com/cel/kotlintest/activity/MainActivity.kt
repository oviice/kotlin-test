package com.cel.kotlintest.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.cel.kotlintest.CountViewModel
import com.cel.kotlintest.MyViewModel
import com.cel.kotlintest.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var text: TextView
    lateinit var edit: EditText
    lateinit var countBtn: Button
    private val myViewModel: MyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text = findViewById(R.id.text2)
        countBtn = findViewById(R.id.count)
        edit = findViewById(R.id.edit)

        countBtn.setOnClickListener {
            myViewModel.getUser(edit.text.toString());
//            countViewModel.setInitialCount(edit.text.toString().toInt())
//            countViewModel.incrementCount()
        }
        myViewModel.userLiveData.observe(this, Observer {
            text.text="Name: ${it.name} \nURL: ${it.url}"
        })

        findViewById<Button>(R.id.next).setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }

//        countViewModel.count.observe(this
//        ) { count ->
//            text.text = "Count : ${count}"
//        }


    }
}