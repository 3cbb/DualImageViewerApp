package edu.temple.dualimageviewerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        var textView: TextView = findViewById(R.id.textView2)

        var imageView: ImageView = findViewById(R.id.imageView)
    }


}