package me.victor.myapplication

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import me.victor.baselibrary.FindView
import me.victor.baselibrary.Onclick
import me.victor.baselibrary.ViewUtils

class MainActivity : AppCompatActivity() {

    @FindView(R.id.tv)
    private lateinit var text: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewUtils.inject(this)
        text.setText("hello")
    }
    @Onclick([R.id.tv,R.id.test])
    fun hello(view: View){
        when(view.id){
            R.id.tv -> Toast.makeText(this,"hello",Toast.LENGTH_LONG).show()
            R.id.test -> Toast.makeText(this,"world",Toast.LENGTH_LONG).show()
        }

    }
}