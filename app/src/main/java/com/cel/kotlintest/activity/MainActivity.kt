package com.cel.kotlintest.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.cel.kotlintest.MyViewModel
import com.cel.kotlintest.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var text: TextView
    private lateinit var edit: EditText
    private lateinit var countBtn: Button
    private val myViewModel: MyViewModel by viewModels()
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text = findViewById(R.id.text2)
        countBtn = findViewById(R.id.count)
        edit = findViewById(R.id.edit)

        countBtn.setOnClickListener {
            if (!TextUtils.isEmpty(edit.text))
                myViewModel.getUser(edit.text.toString())
            else
                Toast.makeText(this,"Edit text is empty",Toast.LENGTH_SHORT).show()
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