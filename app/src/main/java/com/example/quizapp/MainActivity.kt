package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Hides the status bar on mobile - battery, clock, notifications etc.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        // Set on click listener for the button named Start
        btn_start.setOnClickListener {

            // If the user hasn't entered a name then ask them to enter it
            if(et_name.text.toString().isEmpty()){
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            }else {
                // If there is a name then send user to next screen (Quiz Question Activity Screen)
                val intent = Intent(this, QuizzQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, et_name.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}