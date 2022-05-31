package com.example.lets_talk.ui.hotels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.lets_talk.R

class ListActivity : AppCompatActivity() {
    val mobileArray = arrayOf("Android", "Iphone", "Windows Mobile", "Blackberry", "Linux Ubuntu", "Windows 11", "Mac OS")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val arrayAdapter = ArrayAdapter(this, R.layout.activity_list, mobileArray)
        val listView: ListView = findViewById<ListView>(R.id.mobile_list)


    }
}