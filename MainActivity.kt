package com.example.relativelayouttogglebuttonscrollview

import android.os.Bundle

import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var textView: TextView
    private val dataBase = Database()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        button = findViewById(R.id.buttonBTN)
        textView = findViewById(R.id.textTV)

        button.setOnClickListener {
            val bookText  = loadBook(dataBase.text)
            textView.text = bookText.joinToString(" ")

        }
    }
    private fun loadBook(text:String):List<String>{
        return text.split(" ")
    }
}


