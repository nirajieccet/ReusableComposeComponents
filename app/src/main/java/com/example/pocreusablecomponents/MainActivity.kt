package com.example.pocreusablecomponents

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.pocreusablecomponents.ui.ButtonActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCommonButton = findViewById<Button>(R.id.btnCommonButton)
        val btnCommonTextField = findViewById<Button>(R.id.btnCommonTextField)

        btnCommonButton.setOnClickListener {
            val intent = Intent(this, ButtonActivity::class.java)
            startActivity(intent)
        }

        btnCommonTextField.setOnClickListener {
            val intent = Intent(this, ButtonActivity::class.java)
            startActivity(intent)
        }
    }
}