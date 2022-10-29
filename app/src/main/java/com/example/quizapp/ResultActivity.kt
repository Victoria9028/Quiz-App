package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Hides the status bar on mobile - battery, clock, notifications etc.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        // Shows user their name
        val username = intent.getStringExtra(Constants.USER_NAME)
        tv_name.text = username

        // Calculates number of correct questions to total questions
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        // Shows user their score
        tv_score.text = "Your score is $correctAnswers out of $totalQuestions"

        // Finish button sends user back to the Main Activity screen
        btn_finish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
}