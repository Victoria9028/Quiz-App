package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quizz_questions.*

class QuizzQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition:Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null

    // On opening quiz questions screen
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizz_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        // Hides the status bar on mobile - battery, clock, notifications etc.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        // Get the questions list from constants.kt
        mQuestionsList  = Constants.getQuestions()

        setQuestion()

        // Set on click listener for the options and submit buttons
        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)


    }

    // Set the question
    private fun setQuestion(){

        // Start from question id 1
        val question = mQuestionsList!![mCurrentPosition-1]

        // Set default options view
        defaultOptionsView()

        // Submit button functionality for when user has finished quiz
        if(mCurrentPosition == mQuestionsList!!.size){
            btn_submit.text = "FINISHED"
        }else{

            // Or when the user is still progressing through the quiz
            btn_submit.text = "SUBMIT"
        }

        // Setting the progress on the progress bar as user goes through questions
        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.max

        // Show the questions, flag image, and answer options
        tv_question.text = question!!.question
        iv_image.setImageResource(question.image)
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour
    }

    // Set the default style for the options buttons
    private fun defaultOptionsView(){

        val options = ArrayList<TextView>()

        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,
                R.drawable.default_option_border_bg
            )
        }
    }

    // On click options button function called from quiz questions.xml
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_option_one ->{
                selectedOptionView(tv_option_one, 1)
            }
            R.id.tv_option_two ->{
                selectedOptionView(tv_option_two, 2)
            }
            R.id.tv_option_three ->{
                selectedOptionView(tv_option_three, 3)
            }
            R.id.tv_option_four ->{
                selectedOptionView(tv_option_four, 4)
            }
            // Submit button functionality
            R.id.btn_submit ->{

                // If user is at start of quiz then go to next question
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition ++

                    // When user is not at start or end of quiz progress them accordingly
                    when{
                        mCurrentPosition <= mQuestionsList!!.size ->{
                            setQuestion()
                        }else ->{ // else tell them they have completed quiz
                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra(Constants.USER_NAME, mUserName)
                        intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                        intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                        startActivity(intent)
                        finish()
                        }
                    }
                }else{
                    val question = mQuestionsList?.get(mCurrentPosition -1)

                    // If question is answered incorrectly show user by giving answer red background
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else {
                        mCorrectAnswers++
                    }

                    // If answer is correct show user by giving answer green background
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mQuestionsList!!.size){
                        btn_submit.text = "FINISHED"
                    }else{
                        btn_submit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    // Set the background color of options buttons if user answers correctly or wrong
    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 ->{
                tv_option_one.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 ->{
                tv_option_two.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 ->{
                tv_option_three.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 ->{
                tv_option_four.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }

    // Define style function for the options buttons when clicked
    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,
            R.drawable.selected_option_border_bg
        )
    }
}